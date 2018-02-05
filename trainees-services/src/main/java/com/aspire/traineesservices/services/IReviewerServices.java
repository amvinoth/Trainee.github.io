package com.aspire.traineesservices.services;

import com.aspire.traineesservices.beans.Reviewer;
import com.aspire.traineesservices.dto.ReviewerDTO;
/**
 * 
 * @author vinoth.madhu
 *
 */
public interface IReviewerServices {
	/**
	 * 
	 * @return
	 */
	public Iterable<Reviewer> getAllMentorsInfo();
	/**
	 * 
	 * @param newReviewer
	 * @return
	 */
	public Reviewer addNewReviewerInfo(ReviewerDTO newReviewer);
	/**
	 * 
	 * @param reviewerId
	 * @return
	 */
	public Reviewer getReviewerById(Integer reviewerId);
	/**
	 * 
	 * @param reviewerId
	 * @return
	 */
	public Reviewer getReviewerByEmpId(String reviewerId);
}
