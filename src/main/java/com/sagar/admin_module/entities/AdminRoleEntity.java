package com.sagar.admin_module.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="ADMIN_ROLES")
@Data
public class AdminRoleEntity {
			

		@Id
		@SequenceGenerator(name="admin_role",sequenceName="admin_roles_id_seq",allocationSize=1)
		@GeneratedValue(generator="admin_role", strategy=GenerationType.SEQUENCE)
		@Column(name="ADMINROLE_ID")
		private int adminRoleId;
		
		@Column(name="ADMINROLE_NAME")
		private String adminRoleName;
		
}
