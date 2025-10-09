package com.example.demo.repository;

import com.example.demo.model.datamodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jparepository extends JpaRepository<datamodel, Integer> {
    datamodel findByUsername(String username);
}
