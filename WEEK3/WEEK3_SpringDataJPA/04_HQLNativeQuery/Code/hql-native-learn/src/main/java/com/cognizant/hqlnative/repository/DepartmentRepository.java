package com.cognizant.hqlnative.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.hqlnative.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

} 