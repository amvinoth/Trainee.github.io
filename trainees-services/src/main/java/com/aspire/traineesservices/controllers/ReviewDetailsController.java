package com.aspire.traineesservices.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.traineesservices.beans.ReviewDetails;
import com.aspire.traineesservices.dto.ReviewDetailDTO;
import com.aspire.traineesservices.dto.ReviewDetailsDTO;
import com.aspire.traineesservices.exception.BadRequestException;
import com.aspire.traineesservices.exception.ErrorMessage;
import com.aspire.traineesservices.services.ReviewDetailsServices;
import com.aspire.traineesservices.util.ValidationUtil;

/**
 * 
 * @author vinoth.madhu ReviewDetails Controller that maps all reviews related
 *         operations like add new details, view and find.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/training-dept")
public class ReviewDetailsController {

	@Autowired
	private ReviewDetailsServices reviewDetailsServices;

	private static final Logger logger = Logger.getLogger(ReviewDetailsController.class.getName()); 
	/**
	 * All ReviewDetails information.
	 * 
	 * @return
	 */
	@GetMapping("/all-review-details-info")
	@ResponseBody
	public Iterable<ReviewDetails> allReviewDetails() {
		Iterable<ReviewDetails> reviewDetails = this.reviewDetailsServices.getAllReviewDetails();
		return reviewDetails;
	}

	/**
	 * Adding new ReviewDetails information.
	 * 
	 * @param reviewDetailsDTO
	 * @return
	 */
	@PostMapping("/add-review-details")
	public ReviewDetails addReviewDetails(@Valid ReviewDetailsDTO reviewDetailsDTO, BindingResult bindingResult)
			throws BadRequestException {
		boolean flag = false;
		ErrorMessage errorMessage = new ErrorMessage();
		if (bindingResult.hasErrors()) {
			errorMessage = ValidationUtil.getErrorMessage(bindingResult);
			flag = true;
		}

		if (flag) {
			logger.log(Level.WARNING, "Error on adding Review details");
			throw new BadRequestException(errorMessage);
		}
		ReviewDetails reviewHistory = this.reviewDetailsServices.addNewReviewInfo(reviewDetailsDTO);
		return reviewHistory;
	}

	/**
	 * Getting ReviewDetails details by EmployeeId
	 * 
	 * @param reviewDetailDTO
	 * @return
	 */
	@GetMapping("/find-review-details")
	public ReviewDetails getReviewDetailsById(@Valid ReviewDetailDTO reviewDetailDTO) {
		ReviewDetails reviewDetail = this.reviewDetailsServices.getReviewDetailsById(reviewDetailDTO);
		logger.log(Level.INFO, "Finding review details");
		return reviewDetail;
	}
}
