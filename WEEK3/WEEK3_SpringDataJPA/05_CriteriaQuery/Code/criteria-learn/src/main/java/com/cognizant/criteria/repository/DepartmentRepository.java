package com.cognizant.criteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.criteria.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

} 