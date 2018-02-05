package com.aspire.traineesservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.traineesservices.beans.Reviewer;
import com.aspire.traineesservices.dto.ReviewerDTO;
import com.aspire.traineesservices.repositories.ReviewerRepository;

/**
 * 
 * @author vinoth.madhu
 *
 */
@Service
public class ReviewerServices implements IReviewerServices {

	@Autowired
	private ReviewerRepository reviewerRepository;

	public Iterable<Reviewer> getAllMentorsInfo() {
		return this.reviewerRepository.findAll();
	}

	public Reviewer addNewReviewerInfo(ReviewerDTO newReviewer) {

		Reviewer newReviewerData = new Reviewer(newReviewer.getName(), newReviewer.getEmail(),
				newReviewer.getEmployeeNo(), newReviewer.getLocation(), newReviewer.getDomain());
		try {
			this.reviewerRepository.save(newReviewerData);
		} catch (Exception exception) {
			System.out.println("Exception at inserting new reviewer :" + exception.getMessage());
		}
		return newReviewerData;
	}

	public Reviewer getReviewerById(Integer reviewerId) {

		return this.reviewerRepository.findOne(reviewerId);
	}

	public Reviewer getReviewerByEmpId(String reviewerId) {

		return this.reviewerRepository.findByEmployeeNo(reviewerId);
	}

	public void deleteReviewerInfo(Reviewer reviewer) {
		this.reviewerRepository.delete(reviewer);

	}

}
