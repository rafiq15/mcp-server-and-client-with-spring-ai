package com.spring.ai.mcp.server.repository;

import com.spring.ai.mcp.server.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByName(String name);  // For tool usage
}