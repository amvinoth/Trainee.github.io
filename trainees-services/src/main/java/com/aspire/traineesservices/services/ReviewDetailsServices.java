package com.aspire.traineesservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.traineesservices.beans.ReviewDetails;
import com.aspire.traineesservices.beans.TMRKey;
import com.aspire.traineesservices.dto.ReviewDetailDTO;
import com.aspire.traineesservices.dto.ReviewDetailsDTO;
import com.aspire.traineesservices.repositories.ReviewDetailsRepository;
/**
 * 
 * @author vinoth.madhu
 *
 */
@Service
public class ReviewDetailsServices implements IReviewDetailsServices {
	@Autowired
	private ReviewDetailsRepository allReviewDetailsRepository;
	@Autowired
	private MentorServices mentorServices;
	@Autowired
	private ReviewerServices reviewerServices;
	@Autowired
	private TraineeServices traineeServices;

	public Iterable<ReviewDetails> getAllReviewDetails() {
		return this.allReviewDetailsRepository.findAll();
	}

	public ReviewDetails addNewReviewInfo(ReviewDetailsDTO reviewDetailsDTO) {
		System.out.println("Inside add addNewReviewInfo");
		TMRKey compositekey = new TMRKey(reviewDetailsDTO.getReviewType(),
				this.traineeServices.getTraineeById(reviewDetailsDTO.getTrainee_id()));

		ReviewDetails reviewDetails = new ReviewDetails(compositekey, reviewDetailsDTO.getDate(),
				reviewDetailsDTO.getLocation(), reviewDetailsDTO.getMinutes(), reviewDetailsDTO.getTraineeFeedback(),
				reviewDetailsDTO.getReviewerFeedback(), reviewDetailsDTO.getOverAllFeedback(),
				this.reviewerServices.getReviewerById(reviewDetailsDTO.getReviewer_id()),
				this.mentorServices.getMentorById(reviewDetailsDTO.getMentor_id()));
		return this.allReviewDetailsRepository.save(reviewDetails);
	}

	public ReviewDetails getReviewDetailsById(ReviewDetailDTO reviewDetailDTO) {
		TMRKey compositekey = new TMRKey(reviewDetailDTO.getReviewType(),
				this.traineeServices.getTraineeByEmployeeId(reviewDetailDTO.getTraineeEmployeeId()));
		return this.allReviewDetailsRepository.findOne(compositekey);
	}
}
