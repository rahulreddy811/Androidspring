package com.example.demo.repository;

import com.example.demo.model.reviewmodel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface reviewrepository extends JpaRepository<reviewmodel,String> {
   Optional<reviewmodel> findbyMoviename(String Moviename);
}
