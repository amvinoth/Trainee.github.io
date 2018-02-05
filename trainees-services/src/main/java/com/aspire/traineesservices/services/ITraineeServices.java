package com.aspire.traineesservices.services;

import com.aspire.traineesservices.beans.Trainee;
import com.aspire.traineesservices.dto.TraineeDTO;
/**
 * 
 * @author vinoth.madhu
 *
 */
public interface ITraineeServices {
	/**
	 * 
	 * @return
	 */
	public Iterable<Trainee> getAllTraineesInfo();
	/**
	 * 
	 * @param newTainee
	 * @return
	 */
	public Iterable<Trainee> addNewTraineeInfo(TraineeDTO newTainee);
	/**
	 * 
	 * @param noteId
	 * @return
	 */
	public Trainee getTraineeByEmployeeId(String noteId);
	/**
	 * 
	 * @param traineeId
	 */
	public void deleteTraineeInfo(String traineeId);
	/**
	 * 
	 * @param trainee_id
	 * @return
	 */
	public Trainee getTraineeById(int trainee_id);	
}
