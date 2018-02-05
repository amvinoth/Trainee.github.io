package com.aspire.traineesservices.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aspire.traineesservices.beans.Trainee;

@Repository
public interface TraineeRepository extends CrudRepository<Trainee, Integer> {
	Trainee findByEmployeeId(String employeeNo);
}