package com.aspire.traineesservices.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * @author vinoth.madhu
 * DTO class for Mentor details.
 */
public class MentorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Employee Name", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String name;

	@ApiModelProperty(value = "Employee mail ID", required = true)
	@NotEmpty(message = "ETF01")
	@Email(message = "ETF03")
	private String email;
	
	@ApiModelProperty(value = "Unique ID for an Aspire employee. Start with 'ACE'", required = true, position = 1)
	@NotNull(message = "ETF05")
	@Pattern(message = "ETF04", regexp = "^ACE([0-9]{4})$")
	private String employeeNo;
	
	@ApiModelProperty(value = "Working location", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String location;

	@ApiModelProperty(value = "Employee working domain", required = true)
	@NotEmpty(message = "ETF01")
	@Size(message = "ETF02", min = 3, max = 30)
	private String domain;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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

}
