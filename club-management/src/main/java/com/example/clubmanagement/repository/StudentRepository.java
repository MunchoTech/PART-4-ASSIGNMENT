package com.example.clubmanagement.repository;

import com.example.clubmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // JpaRepository provides methods like findAll(), findById(), save(), etc.
  
}