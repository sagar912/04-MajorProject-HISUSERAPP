package com.sagar.plan_module.model;


import lombok.Data;

@Data
public class Plan {

	private int planId;

	private String planName;

	private String planDescription;

	private String planStartDate;

	private String planEndDate;

	private String isPlanDeleted;

}
