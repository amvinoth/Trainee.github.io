package com.aspire.traineesservices.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * 
 * @author vinoth.madhu
 * POJO class for composite key
 */
@SuppressWarnings("serial")
@Embeddable
public class TMRKey implements Serializable {

	private String review_type;

	@ManyToOne()
	@JoinColumn(name = "trainee_id", nullable = false)
	private Trainee trainee;

	public TMRKey() {
	}

	public TMRKey(String review_type, Trainee trainee) {
		super();
		this.trainee = trainee;
		this.review_type = review_type;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public String getReview_type() {
		return review_type;
	}

	public void setReview_type(String review_type) {
		this.review_type = review_type;
	}

}
