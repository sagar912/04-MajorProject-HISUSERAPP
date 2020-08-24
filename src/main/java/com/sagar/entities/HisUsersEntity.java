package com.sagar.entities;

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
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="HIS_USERS")
@Data
public class HisUsersEntity {

	
	@Id
	@SequenceGenerator(name="his_users",sequenceName="his_users_id_seq",allocationSize=1)
	@GeneratedValue(generator="his_users", strategy=GenerationType.SEQUENCE)
	@Column(name="HIS_USERS_ID")
	private int his_usersId;
	
	@Column(name="HIS_USERS_FIRSTNAME")
    private String firstName;
	

	@Column(name="HIS_USERS_LASTNAME")
    private String lastName;
	
	@Column(name="HIS_USERS_EMAIL")
    private String email;
	

	@Column(name="HIS_USERS_GENDER")
    private String gender;
	
	@Column(name="HIS_USERS_ROLE")
    private Integer adminRoleId;
	
	@Column(name="HIS_USER_PWD")
    private String pwd;
	
	@Column(name="HIS_USER_ISACTIVE")
    private String isActive;
	
	@Column(name="HIS_USER_ISDELETED")
    private String isDeleted;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
