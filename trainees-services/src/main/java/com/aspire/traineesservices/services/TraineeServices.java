package com.aspire.traineesservices.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.traineesservices.beans.Trainee;
import com.aspire.traineesservices.dto.TraineeDTO;
import com.aspire.traineesservices.repositories.TraineeRepository;
/**
 * 
 * @author vinoth.madhu
 * 
 */
@Service
public class TraineeServices implements ITraineeServices{

	@Autowired
	private TraineeRepository traineeRepository;

	public Iterable<Trainee> getAllTraineesInfo() {
		return this.traineeRepository.findAll();
	}

	public Iterable<Trainee> addNewTraineeInfo(TraineeDTO newTainee) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date dateOfJoin = null;
		try {
			dateOfJoin = formatter.parse(newTainee.getDateOfJoining());
		} catch (ParseException e) {
			System.out.println("Date conversion failed - TraineeDTO");
			e.printStackTrace();
		}
		Trainee newTraineeBean = new Trainee(newTainee.getName(), newTainee.getSurname(), newTainee.getGender(),
				newTainee.getEmployeeId(), newTainee.getEmail(), dateOfJoin, newTainee.getTrainingBatch(),
				newTainee.getNationality(), newTainee.getLocation(), newTainee.getDomain(),
				newTainee.getTraineeStatus(), newTainee.getTrainingStartDate(), newTainee.getTrainingEndDate(),
				newTainee.getGenralFeedback(), newTainee.getAllocatedProject(), newTainee.getProjectAllocationDate());
		try {
			this.traineeRepository.save(newTraineeBean);
		} catch (Exception exception) {
			System.out.println("Exception at inserting new Trainee :" + exception.getMessage());
		}
		return this.traineeRepository.findAll();
	}

	public Trainee getTraineeByEmployeeId(String noteId) {
		return this.traineeRepository.findByEmployeeId(noteId);
	}

	public void deleteTraineeInfo(String traineeId) {
		this.traineeRepository.delete(getTraineeByEmployeeId(traineeId));
	}

	public Trainee getTraineeById(int trainee_id) {
		
		return this.traineeRepository.findOne(trainee_id);
	}

}
