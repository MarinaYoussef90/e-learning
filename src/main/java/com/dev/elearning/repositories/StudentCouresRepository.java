package com.dev.elearning.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev.elearning.entities.Course;
import com.dev.elearning.entities.StudentCourse;

@Repository
public interface StudentCouresRepository extends JpaRepository<StudentCourse, Long> {
	
	public StudentCourse findByStudentIdAndCourseIdAndRetired(long studentId, long courseId, boolean retired);

	public List<StudentCourse> findByStudentIdAndRetired(long studentId, boolean retired);
}
