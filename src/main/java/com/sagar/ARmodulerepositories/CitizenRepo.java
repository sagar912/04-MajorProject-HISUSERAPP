package com.sagar.ARmodulerepositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.ARmodule.entities.CitizenEntity;


public interface CitizenRepo extends JpaRepository<CitizenEntity, Serializable> {

	
}

