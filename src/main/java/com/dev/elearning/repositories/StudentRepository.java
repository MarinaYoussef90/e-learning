package com.dev.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.elearning.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public int countByEmail(String email);
}