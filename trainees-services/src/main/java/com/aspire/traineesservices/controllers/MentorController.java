package com.aspire.traineesservices.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.traineesservices.beans.Mentor;
import com.aspire.traineesservices.dto.MentorDTO;
import com.aspire.traineesservices.exception.BadRequestException;
import com.aspire.traineesservices.exception.ErrorCode;
import com.aspire.traineesservices.exception.ErrorMessage;
import com.aspire.traineesservices.services.MentorServices;
import com.aspire.traineesservices.util.ValidationUtil;
import com.aspire.traineesservices.exception.Error;

/**
 * 
 * @author vinoth.madhu Mentor Controller that maps all Mentor related
 *         operations like add new details, view, delete and find.
 * 
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/training-dept")
public class MentorController {

	@Autowired
	private MentorServices mentorServices;

	private static final Logger logger = Logger.getLogger(MentorController.class.getName());

	/**
	 * Adding new Mentor information.
	 * 
	 * @param newMentor
	 * @return
	 * @throws BadRequestException
	 */
	@PostMapping("/add-mentor")
	public Mentor addMentorInfo(@Valid MentorDTO newMentor, BindingResult bindingResult) throws BadRequestException {

		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		if (bindingResult.hasErrors()) {
			errorMessage = ValidationUtil.getErrorMessage(bindingResult);
			flag = true;
		}
		if (mentorServices.getMentor(newMentor.getEmployeeNo()) != null) {
			logger.log(Level.WARNING, "Employee id already exists");
			errorMessage.addError(new Error(ErrorCode.EMPLOYEE_ID_ALREADY_EXISTS));
			flag = true;
		}

		if (flag) {
			logger.log(Level.WARNING, "Error on adding Trainee");
			throw new BadRequestException(errorMessage);
		}
		logger.log(Level.INFO, "Adding new Mentor details successfully");
		return this.mentorServices.addNewMentorInfo(newMentor);
	}

	/**
	 * All Mentors information.
	 * 
	 * @return
	 */
	@GetMapping("/all-mentors-info")
	public Iterable<Mentor> allMentorsInfo() {
		logger.log(Level.INFO, "All Mentor informations");
		Iterable<Mentor> mentorsList = this.mentorServices.getAllMentorsInfo();
		return mentorsList;
	}

	/**
	 * Getting Mentor details by EmployeeId
	 * 
	 * @param mentorId
	 * @return
	 */
	@GetMapping("/mentor/{employeeId}")
	public Mentor getMentorById(@PathVariable(name = "employeeId", required = true) String employeeId) {
		Mentor mentor = this.mentorServices.getMentorByEmployeeID(employeeId);
		if (mentor == null) {
			System.out.println("Mentor information not found");
		}
		return mentor;
	}

	/**
	 * Deleting Mentor details by EmployeeId
	 * 
	 * @param mentorId
	 * @return
	 * @throws BadRequestException
	 */
	@DeleteMapping("/delete-mentor/{employeeId}")
	public ResponseEntity<Mentor> deleteMentorById(@PathVariable(name = "employeeId") String employeeId)
			throws BadRequestException {
		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		Mentor mentor = this.mentorServices.getMentorByEmployeeID(employeeId);
		if (mentor == null) {
			errorMessage.addError(new Error(ErrorCode.NO_INFORMATION_FOUND));
			flag = true;
		}
		if (flag) {
			logger.log(Level.WARNING, "Error on deleting Mentor details");
			throw new BadRequestException(errorMessage);
		}
		this.mentorServices.deleteTraineeInfo(mentor);
		return ResponseEntity.ok().build();
	}

}
