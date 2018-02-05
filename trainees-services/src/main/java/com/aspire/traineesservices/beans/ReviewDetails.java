package com.aspire.traineesservices.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author vinoth.madhu
 * POJO class for ReviewDetails.
 */
@Entity
public class ReviewDetails {
	@EmbeddedId
	private TMRKey id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String location;
	private int minutes;
	private String traineeFeedback;
	private String reviewerFeedback;
	private String overAllFeedback;
	
	@ManyToOne()
	@JoinColumn(name = "reviewer_id", nullable = false)
	private Reviewer reviewer;
	
	@ManyToOne()
	@JoinColumn(name = "mentor_id", nullable = false)
	private Mentor mentor;
	
	public ReviewDetails() {
	}

	public ReviewDetails(TMRKey id) {
		super();
		this.id = id;
	}
	
	public ReviewDetails(TMRKey id, Date date, String location, int minutes, String traineeFeedback,
			String reviewerFeedback, String overAllFeedback, Reviewer reviewer, Mentor mentor) {
		super();
		this.id = id;
		this.date = date;
		this.location = location;
		this.minutes = minutes;
		this.traineeFeedback = traineeFeedback;
		this.reviewerFeedback = reviewerFeedback;
		this.overAllFeedback = overAllFeedback;
		this.reviewer = reviewer;
		this.mentor = mentor;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public TMRKey getId() {
		return id;
	}

	public void setId(TMRKey id) {
		this.id = id;
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

}
