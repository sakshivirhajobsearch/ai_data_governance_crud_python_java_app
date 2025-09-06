package com.ai.data.governance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.data.governance.model.DataEntity;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
