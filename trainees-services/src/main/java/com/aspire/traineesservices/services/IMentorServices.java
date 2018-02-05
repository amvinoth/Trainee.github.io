package com.aspire.traineesservices.services;

import com.aspire.traineesservices.beans.Mentor;
import com.aspire.traineesservices.dto.MentorDTO;

/**
 * 
 * @author vinoth.madhu
 *
 */
public interface IMentorServices {
	/**
	 * 
	 * @param newMentor
	 * @return
	 */
	public Mentor addNewMentorInfo(MentorDTO newMentor);
	/**
	 * 
	 * @return
	 */
	public Iterable<Mentor> getAllMentorsInfo();
	/**
	 * 
	 * @param mentorId
	 * @return
	 */
	public Mentor getMentorByEmployeeID(String mentorId);
	/**
	 * 
	 * @param mentor
	 */
	public void deleteTraineeInfo(Mentor mentor);
}
