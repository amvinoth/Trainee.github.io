package com.aspire.traineesservices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aspire.traineesservices.beans.Reviewer;

@Repository
public interface ReviewerRepository extends CrudRepository<Reviewer, Integer> {
	Reviewer findByEmployeeNo(String employeeNo);
}

