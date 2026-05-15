package com.crudapi.rest_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapi.rest_api.Models.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
    
}
