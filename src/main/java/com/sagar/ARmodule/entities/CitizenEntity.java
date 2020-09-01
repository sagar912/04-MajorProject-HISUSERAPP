package com.sagar.ARmodule.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "APPLICANTS_MASTER")
@Data
public class CitizenEntity {

	@Id
	@Column(name = "APPLICANTS_ID")
	@GenericGenerator(name = "applicants_id_gen", strategy = "com.sagar.ARmodule.generators.SSNGenerator")
	@GeneratedValue(generator = "applicants_id_gen")

	//@SequenceGenerator(name = "applicants", sequenceName = "applicants_id_seq", allocationSize = 1)
	//@GeneratedValue(generator = "applicants", strategy = GenerationType.SEQUENCE)
	private String applicantsId;

	@Column(name = "APPLICANTS_FIRSTNAME")
	private String firstName;

	@Column(name = "APPLICANTS_LASTNAME")
	private String lastName;

	@Column(name = "APPLICANTS_EMAIL")
	private String email;

	@Column(name = "APPLICANTS_GENDER")
	private String gender;

	@Column(name = "APPLICANTS_DOB")
	private String dob;

	@Column(name = "APPLICANTS_SSN")
	private String ssn;

	@Column(name = "APPLICANTS_CONTACTNUMBER")
	private String contactNumber;

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
