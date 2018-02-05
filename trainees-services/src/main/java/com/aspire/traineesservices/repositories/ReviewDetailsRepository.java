package com.aspire.traineesservices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aspire.traineesservices.beans.ReviewDetails;
import com.aspire.traineesservices.beans.TMRKey;

@Repository
public interface ReviewDetailsRepository extends CrudRepository<ReviewDetails, TMRKey> {
	ReviewDetails findById(String reviewType, String traineeId);
}
