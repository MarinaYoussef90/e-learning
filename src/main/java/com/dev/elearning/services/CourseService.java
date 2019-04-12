package com.dev.elearning.services;

import java.util.List;

import com.dev.elearning.dto.CourseDTO;
import com.dev.elearning.entities.Course;

public interface CourseService {

	public List<CourseDTO> getAllCourses();

	public CourseDTO getCourseDTOByID(long id);

	public CourseDTO getCourseByName(String name);
	
	public Course getCourseByID(long id);
	
	public void addCourse(CourseDTO courseDTO);
	
}
