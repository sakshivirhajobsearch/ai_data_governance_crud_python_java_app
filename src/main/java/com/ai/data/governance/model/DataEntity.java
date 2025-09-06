package com.ai.data.governance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "data_value")
	private String dataValue;

	// Required for JPA
	public DataEntity() {
	}

	public DataEntity(String name, String dataValue) {
		this.name = name;
		this.dataValue = dataValue;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDataValue() {
		return dataValue;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
}
