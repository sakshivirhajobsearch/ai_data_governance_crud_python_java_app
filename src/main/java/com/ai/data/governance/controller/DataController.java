package com.ai.data.governance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.data.governance.model.DataEntity;
import com.ai.data.governance.repository.DataRepository;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping
    public List<DataEntity> getAll() {
        return dataRepository.findAll();
    }

    @PostMapping
    public DataEntity create(@RequestBody DataEntity dataEntity) {
        return dataRepository.save(dataEntity);
    }

    @GetMapping("/{id}")
    public DataEntity getById(@PathVariable Long id) {
        return dataRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public DataEntity update(@PathVariable Long id, @RequestBody DataEntity updatedData) {
        return dataRepository.findById(id).map(existing -> {
            existing.setName(updatedData.getName());
            existing.setDataValue(updatedData.getDataValue());
            return dataRepository.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        dataRepository.deleteById(id);
        return "Deleted successfully";
    }
}
