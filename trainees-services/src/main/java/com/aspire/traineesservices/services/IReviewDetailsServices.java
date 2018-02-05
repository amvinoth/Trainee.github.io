package com.aspire.traineesservices.services;

import com.aspire.traineesservices.beans.ReviewDetails;
import com.aspire.traineesservices.dto.ReviewDetailDTO;
import com.aspire.traineesservices.dto.ReviewDetailsDTO;
/**
 * 
 * @author vinoth.madhu
 *
 */
public interface IReviewDetailsServices {
	/**
	 * 
	 * @return
	 */
	public Iterable<ReviewDetails> getAllReviewDetails();
	/**
	 * 
	 * @param reviewDetailsDTO
	 * @return
	 */
	public ReviewDetails addNewReviewInfo(ReviewDetailsDTO reviewDetailsDTO);
	/**
	 * 
	 * @param reviewDetailDTO
	 * @return
	 */
	public ReviewDetails getReviewDetailsById(ReviewDetailDTO reviewDetailDTO);
}
