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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.traineesservices.beans.Reviewer;
import com.aspire.traineesservices.dto.ReviewerDTO;
import com.aspire.traineesservices.exception.BadRequestException;
import com.aspire.traineesservices.exception.Error;
import com.aspire.traineesservices.exception.ErrorCode;
import com.aspire.traineesservices.exception.ErrorMessage;
import com.aspire.traineesservices.services.ReviewerServices;
import com.aspire.traineesservices.util.ValidationUtil;

/**
 * 
 * @author vinoth.madhu Reviewer Controller that maps all Reviewer related
 *         operations like add new details, view, delete and find.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/training-dept")
public class ReviewerController {

	@Autowired
	private ReviewerServices reviewerServices;

	private static final Logger logger = Logger.getLogger(ReviewerController.class.getName()); 	
	/**
	 * All Reviewers information.
	 * 
	 * @return
	 */
	@GetMapping("/all-reviewers-info")
	public Iterable<Reviewer> allReviewersInfo() {
		Iterable<Reviewer> reviewerList = this.reviewerServices.getAllMentorsInfo();
		return reviewerList;
	}

	/**
	 * Adding new Reviewer information.
	 * 
	 * @param newReviewer
	 * @return
	 */
	@PostMapping("/add-reviewer")
	public Reviewer addReviewerInfo(@Valid ReviewerDTO newReviewer, BindingResult bindingResult)
			throws BadRequestException {

		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		if (bindingResult.hasErrors()) {
			errorMessage = ValidationUtil.getErrorMessage(bindingResult);
			flag = true;
		}
		if (reviewerServices.getReviewerByEmpId(newReviewer.getEmployeeNo()) != null) {
			logger.log(Level.WARNING, "Employee id already exists");
			errorMessage.addError(new Error(ErrorCode.EMPLOYEE_ID_ALREADY_EXISTS));
			flag = true;
		}
		if (flag) {
			logger.log(Level.WARNING, "Error on adding Reviewer");
			throw new BadRequestException(errorMessage);
		}
		return this.reviewerServices.addNewReviewerInfo(newReviewer);
	}

	/**
	 * Getting Reviewer details by EmployeeId
	 * 
	 * @param reviewerId
	 * @return
	 */
	@GetMapping("/reviewer/{employeeId}")
	public ResponseEntity<Reviewer> getReviewerById(@PathVariable(value = "employeeId") String employeeId) {
		Reviewer reviewer = this.reviewerServices.getReviewerByEmpId(employeeId);
		if (reviewer == null) {
			logger.log(Level.WARNING, "Reviewer information not found");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(reviewer);
	}

	/**
	 * Deleting Reviewer details by EmployeeId
	 * 
	 * @param reviewerId
	 * @return
	 * @throws BadRequestException
	 */
	@DeleteMapping("/delete-reviewer/{employeeId}")
	public ResponseEntity<Reviewer> deleteReviewerById(@PathVariable(value = "employeeId") String employeeId)
			throws BadRequestException {

		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		Reviewer reviewer = this.reviewerServices.getReviewerByEmpId(employeeId);
		if (reviewer == null) {
			
			errorMessage.addError(new Error(ErrorCode.NO_INFORMATION_FOUND));
			flag = true;
		}
		if (flag) {
			logger.log(Level.WARNING, "Error on deleting Reviewer");
			throw new BadRequestException(errorMessage);
		}

		this.reviewerServices.deleteReviewerInfo(reviewer);
		return ResponseEntity.ok().build();
	}
}
