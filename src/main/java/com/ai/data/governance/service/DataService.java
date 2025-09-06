package com.ai.data.governance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.data.governance.model.DataEntity;
import com.ai.data.governance.repository.DataRepository;

@Service
public class DataService {

	@Autowired
	private DataRepository repository;

	public List<DataEntity> getAll() {
		return repository.findAll();
	}

	public Optional<DataEntity> getById(Long id) {
		return repository.findById(id);
	}

	public DataEntity create(DataEntity entity) {
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}