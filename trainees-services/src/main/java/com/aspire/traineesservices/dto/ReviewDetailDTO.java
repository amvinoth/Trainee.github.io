package com.aspire.traineesservices.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class ReviewDetailDTO {

	@ApiModelProperty(value = "Review type", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String reviewType;

	@ApiModelProperty(value = "Unique ID for an Aspire employee. Start with 'ACE'", required = true)
	@NotNull(message = "ETF05")
	@Pattern(message = "ETF04", regexp = "^ACE([0-9]{4})$")
	private String traineeEmployeeId;

	public String getTraineeEmployeeId() {
		return traineeEmployeeId;
	}

	public void setTraineeEmployeeId(String traineeEmployeeId) {
		this.traineeEmployeeId = traineeEmployeeId;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

}
