package com.aspire.traineesservices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aspire.traineesservices.beans.Mentor;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Integer> {
	Mentor findByEmployeeNo(String employeeNo);
}

