package com.aspire.traineesservices.dto;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class ReviewDetailsDTO {

	@ApiModelProperty(value = "Review Type", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max = 30)
	private String reviewType;
	
	@ApiModelProperty(value = "Review date", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01")
	private Date date;
	
	@ApiModelProperty(value = "Review location", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01")
	private String location;
	
	@ApiModelProperty(value = "Review minutes", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01")
	private int minutes;
	
	@ApiModelProperty(value = "Review Feedback", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max = 30)
	private String traineeFeedback;
	
	@ApiModelProperty(value = "Reviewer Feedback", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max = 30)
	private String reviewerFeedback;
	
	@ApiModelProperty(value = "Overall Feedback", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max = 30)
	private String overAllFeedback;
	
	@ApiModelProperty(value = "Reviewer ID", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max = 7)
	private int reviewer_id;
	
	@ApiModelProperty(value = "Trainee ID", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max =7) 
	private int trainee_id;
	
	@ApiModelProperty(value = "Mentor ID", required = true)
	@NotEmpty(message = "ETF06")
	@Size(message = "ETF06", min = 3, max =7) 
	private int mentor_id;

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getTraineeFeedback() {
		return traineeFeedback;
	}

	public void setTraineeFeedback(String traineeFeedback) {
		this.traineeFeedback = traineeFeedback;
	}

	public String getReviewerFeedback() {
		return reviewerFeedback;
	}

	public void setReviewerFeedback(String reviewerFeedback) {
		this.reviewerFeedback = reviewerFeedback;
	}

	public String getOverAllFeedback() {
		return overAllFeedback;
	}

	public void setOverAllFeedback(String overAllFeedback) {
		this.overAllFeedback = overAllFeedback;
	}

	public int getReviewer_id() {
		return reviewer_id;
	}

	public void setReviewer_id(int reviewer_id) {
		this.reviewer_id = reviewer_id;
	}

	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public int getMentor_id() {
		return mentor_id;
	}

	public void setMentor_id(int mentor_id) {
		this.mentor_id = mentor_id;
	}

}
