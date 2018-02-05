package com.aspire.traineesservices.controllers;

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

import com.aspire.traineesservices.beans.Trainee;
import com.aspire.traineesservices.dto.TraineeDTO;
import com.aspire.traineesservices.exception.BadRequestException;
import com.aspire.traineesservices.exception.Error;
import com.aspire.traineesservices.exception.ErrorCode;
import com.aspire.traineesservices.exception.ErrorMessage;
import com.aspire.traineesservices.services.TraineeServices;
import com.aspire.traineesservices.util.ValidationUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author vinoth.madhu Trainee Controller that maps all Trainee related
 *         operations like add new details, view, delete and find.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/training-dept")
public class TraineeController {

	@Autowired
	private TraineeServices traineeServices;

	private static final Logger logger = Logger.getLogger(TraineeController.class.getName()); 
	
	/**
	 * All Trainees information.
	 * 
	 * @return
	 */
	
	@GetMapping("/all-trainees-info")
	public Iterable<Trainee> allTraineesInfo() {
		logger.log(Level.INFO, "All trainees information");
		Iterable<Trainee> traineesList = this.traineeServices.getAllTraineesInfo();
		return traineesList;
	}

	/**
	 * Adding new Trainee information.
	 * 
	 * @param newTainee
	 * @return
	 * @throws BadRequestException
	 */
	@PostMapping("/add-new-trainee-info")
	public Iterable<Trainee> addNewTraineeInfo(@Valid TraineeDTO newTainee, BindingResult bindingResult)
			throws BadRequestException {
		logger.log(Level.INFO, "Adding new Trainee details");
		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		if (bindingResult.hasErrors()) {
			errorMessage = ValidationUtil.getErrorMessage(bindingResult);
			flag = true;
		}
		if (traineeServices.getTraineeByEmployeeId(newTainee.getEmployeeId()) != null) {
			logger.log(Level.WARNING, "Employee id already exists");
			errorMessage.addError(new Error(ErrorCode.EMPLOYEE_ID_ALREADY_EXISTS));
			flag = true;
		}
		if (flag) {
			logger.log(Level.WARNING, "Error on adding new Trainee");
			throw new BadRequestException(errorMessage);
		}
		Iterable<Trainee> traineesList = this.traineeServices.addNewTraineeInfo(newTainee);

		return traineesList;

	}

	/**
	 * Getting Trainee details by EmployeeId
	 * 
	 * @param traineeId
	 * @return
	 * @throws BadRequestException
	 */
	@GetMapping("/trainee/{employeeId}")
	public Trainee getTraineeById(@PathVariable(name = "employeeId", required = true) String employeeId)
			throws BadRequestException {

		return this.traineeServices.getTraineeByEmployeeId(employeeId);
	}

	/**
	 * Deleting Trainee details by EmployeeId
	 * 
	 * @param traineeId
	 * @return
	 */
	@DeleteMapping("/delete-trainee/{employeeId}")
	public ResponseEntity<Trainee> deleteTraineeById(
			@PathVariable(name = "employeeId", required = true) String employeeId) throws BadRequestException {
		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		if (traineeServices.getTraineeByEmployeeId(employeeId) == null) {
			errorMessage.addError(new Error(ErrorCode.NO_INFORMATION_FOUND));	 
			flag = true;
		}
		if (flag) {
			logger.log(Level.WARNING, "Error on deleting Trainee");
			throw new BadRequestException(errorMessage);
		}
		this.traineeServices.deleteTraineeInfo(employeeId);
		return ResponseEntity.ok().build();
	}
}
