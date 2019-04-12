package com.dev.elearning.services;

import java.util.List;

import com.dev.elearning.dto.CourseDTO;

public interface CourseRegistrationService {
	
	public void registerStudent(long studentId, long courseId);
	
	public void unRegisterStudent(long studentId, long courseId);

	public List<CourseDTO> getStudentRegisteredCourses(long studentId);
}
