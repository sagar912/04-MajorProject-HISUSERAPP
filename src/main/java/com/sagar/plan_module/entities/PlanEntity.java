package com.sagar.plan_module.entities;

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
@Table(name="PLAN_MASTER")
@Data
public class PlanEntity {

	
	@Id
	@SequenceGenerator(name="plan",sequenceName="plan_id_seq",allocationSize=1)
	@GeneratedValue(generator="plan", strategy=GenerationType.SEQUENCE)
	@Column(name="PLAN_ID")
	private int planId;
	
	@Column(name="PLAN_NAME")
    private String planName;
	

	@Column(name="PLAN_DESCRIPTION")
    private String planDescription;
	
	@Column(name="PLAN_START_DATE")
    private String planStartDate;
	
	@Column(name="PLAN_END_DATE")
    private String planEndDate;
	

	@Column(name="PLAN_ISDELETED")
    private String isPlanDeleted;
	

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
