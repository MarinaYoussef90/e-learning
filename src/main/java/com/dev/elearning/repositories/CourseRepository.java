package com.dev.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.elearning.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	public Course findByName(String name);

}
