package com.aspire.traineesservices.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
/**
 * 
 * @author vinoth.madhu
 * POJO class Trainee.
 */
@Entity
public class Trainee {
	@Id
	@Column(name = "trainee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String surname;
	private String gender;
	@Column(unique = true)
	private String employeeId;
	private String email;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfJoining;
	private String trainingBatch;
	private String nationality;
	private String location;
	private String domain;
	private String traineeStatus;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainingStartDate;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date trainingEndDate;

	private String genralFeedback;
	private String allocatedProject;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectAllocationDate;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt = new Date();

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt = new Date();

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Trainee() {
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getTrainingBatch() {
		return trainingBatch;
	}

	public void setTrainingBatch(String trainingBatch) {
		this.trainingBatch = trainingBatch;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTraineeStatus() {
		return traineeStatus;
	}

	public void setTraineeStatus(String traineeStatus) {
		this.traineeStatus = traineeStatus;
	}

	public Date getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(Date trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public Date getTrainingEndDate() {
		return trainingEndDate;
	}

	public void setTrainingEndDate(Date trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}

	public String getGenralFeedback() {
		return genralFeedback;
	}

	public void setGenralFeedback(String genralFeedback) {
		this.genralFeedback = genralFeedback;
	}

	public String getAllocatedProject() {
		return allocatedProject;
	}

	public void setAllocatedProject(String allocatedProject) {
		this.allocatedProject = allocatedProject;
	}

	public Date getProjectAllocationDate() {
		return projectAllocationDate;
	}

	public void setProjectAllocationDate(Date projectAllocationDate) {
		this.projectAllocationDate = projectAllocationDate;
	}

	public Trainee(String name, String surname, String gender, String employeeId, String email, Date dateOfJoining,
			String trainingBatch, String nationality, String location, String domain, String traineeStatus,
			Date trainingStartDate, Date trainingEndDate, String genralFeedback, String allocatedProject,
			Date projectAllocationDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.employeeId = employeeId;
		this.email = email;
		this.dateOfJoining = dateOfJoining;
		this.trainingBatch = trainingBatch;
		this.nationality = nationality;
		this.location = location;
		this.domain = domain;
		this.traineeStatus = traineeStatus;
		this.trainingStartDate = trainingStartDate;
		this.trainingEndDate = trainingEndDate;
		this.genralFeedback = genralFeedback;
		this.allocatedProject = allocatedProject;
		this.projectAllocationDate = projectAllocationDate;
	}
}
