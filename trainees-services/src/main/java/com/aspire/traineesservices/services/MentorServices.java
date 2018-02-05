package com.aspire.traineesservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.traineesservices.beans.Mentor;
import com.aspire.traineesservices.dto.MentorDTO;
import com.aspire.traineesservices.repositories.MentorRepository;

import com.aspire.traineesservices.services.IMentorServices;
/**
 * 
 * @author vinoth.madhu
 *
 */
@Service
public class MentorServices implements IMentorServices{

	@Autowired
	private MentorRepository mentorRepository;

	public Mentor addNewMentorInfo(MentorDTO newMentor) {
		Mentor mentor = new Mentor(newMentor.getName(), newMentor.getEmail(), newMentor.getEmployeeNo(),
				newMentor.getLocation(), newMentor.getDomain());
		return this.mentorRepository.save(mentor);
	}

	public Iterable<Mentor> getAllMentorsInfo() {
		return this.mentorRepository.findAll();
	}

	public Mentor getMentorById(Integer mentorId) {

		return this.mentorRepository.findOne(mentorId);
	}
	
	public Mentor getMentorByEmployeeID(String mentorId) {
		System.out.println(this.mentorRepository.findByEmployeeNo(mentorId).getEmployeeNo());
		return this.mentorRepository.findByEmployeeNo(mentorId);
	}

	public void deleteTraineeInfo(Mentor mentor) {
		this.mentorRepository.delete(mentor);
	}

	public Object getMentor(String employeeNo) {
		
		return this.mentorRepository.findByEmployeeNo(employeeNo);
	}

}
