package com.clubmanagement.entities.repository;



import com.clubmanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
