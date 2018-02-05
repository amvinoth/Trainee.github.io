package com.aspire.traineesservices.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class TraineeDTO {
	
	@ApiModelProperty(value = "Employee Name", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String name;
	
	@ApiModelProperty(value = "Surname/Last Name", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String surname;
	
	@ApiModelProperty(value = "Gender", required = true)
	@NotEmpty(message = "ETF0")
	@Size(message = "ETF02", min = 3, max = 30)
	private String gender;
	
	@ApiModelProperty(value = "Unique ID for an Aspire employee. Start with 'ACE'", required = true, position = 1)
	@NotNull(message = "ETF05")
	@Pattern(message = "ETF04", regexp = "^ACE([0-9]{4})$")
	private String employeeId;
	
	@ApiModelProperty(value = "Employee mail ID", required = true)
	@NotEmpty(message = "ETF01")
	@Email(message = "ETF03")
	private String email;
	
	@ApiModelProperty(value = "Joining date", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01")
	private String dateOfJoining;
	
	@ApiModelProperty(value = "Degree completion year", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01")
	private String trainingBatch;
	
	@ApiModelProperty(value = "Nationality", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01")
	private String nationality;
	
	@ApiModelProperty(value = "Working location", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String location;
	
	@ApiModelProperty(value = "Employee working domain", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String domain;
	
	@ApiModelProperty(value = "Employee Confirmation", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF01", min = 3, max = 30)
	private String traineeStatus;
	
	@ApiModelProperty(value = "Training start date", required = true)
	@NotNull
//    @DateTimeFormat
	private Date trainingStartDate;
	
	@ApiModelProperty(value = "Training end date", required = true)
	@NotNull
   
	private Date trainingEndDate;
	
	@ApiModelProperty(value = "Genral feedback", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min =3, max = 30)
	private String genralFeedback;
	
	@ApiModelProperty(value = "Allocated project name", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 2, max = 30)
	private String allocatedProject;
	
	@ApiModelProperty(value = "Project allocation date", required = true)
	@NotNull
	private Date projectAllocationDate;
	
	
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
	
	
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
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
	
}
