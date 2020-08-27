package com.sagar.admin_module.model;



import lombok.Data;

@Data
public class HIS_USERS {
	

private int his_usersId;

private String firstName;
	
private String lastName;
	
private String email;
    
private String gender;
	
private Integer adminRoleId;
	
private String pwd;
	
private String isActive;

private String isDeleted;
	
}
