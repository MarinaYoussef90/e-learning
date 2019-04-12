package com.dev.elearning.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.elearning.dto.CourseDTO;
import com.dev.elearning.entities.Course;
import com.dev.elearning.exception.ElearningException;
import com.dev.elearning.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	//TODO: should cache the return List
	@Override
	public List<CourseDTO> getAllCourses() {
		
		List<Course> courses = courseRepository.findAll();
		if(courses != null) {
			List<CourseDTO> courseDTOs = new ArrayList<>();
			for (Course course : courses) {
				courseDTOs.add(convertToDTO(course));
			}
			return courseDTOs;
		}
		return null;
	}

	@Override
	public CourseDTO getCourseDTOByID(long id) {
	
		if(id != 0) {
			Optional<Course> optional = courseRepository.findById(id);
			if(optional.isPresent()) {
				Course course = optional.get();
				return convertToDTO(course);
			} else 
				throw new ElearningException("ID should be greater than 0.");
		}
		
		return null;
	}

	@Override
	public CourseDTO getCourseByName(String name) {
		
		if(name !=  null && !name.equals("")) {
			Course course  = courseRepository.findByName(name);
			if(course != null) {
				return convertToDTO(course);
			} else
				throw new ElearningException("Please, provide the name of the course.");
		}
		return null;
	}
	
	@Override
	public Course getCourseByID(long id) {
		
		if(id != 0) {
			Optional<Course> optional = courseRepository.findById(id);
			if(optional.isPresent()) {
				Course course = optional.get();
				return course;
			} else 
				throw new ElearningException("ID should be greater than 0.");
		}
		return null;
	}

	//For Testing only
	@Override
	public void addCourse(CourseDTO courseDTO) {
		if(courseDTO != null) {
			Course course = new Course();
			course.setName(courseDTO.getName());
			course.setDescription(courseDTO.getDescription());
			course.setPublishDate(courseDTO.getPublishDate());
			course.setInstructor(courseDTO.getInstractor());
			course.setTotalHours(courseDTO.getTotalHours());
			course.setLastUpdated(courseDTO.getLastUpdated());
			
			courseRepository.save(course);
		}else
			throw new ElearningException("not valid data");
		
	}

	private CourseDTO convertToDTO(Course course) {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setId(course.getId());
		courseDTO.setName(course.getName());
		courseDTO.setDescription(course.getDescription());
		courseDTO.setLastUpdated(course.getLastUpdated());
		courseDTO.setPublishDate(course.getPublishDate());
		courseDTO.setInstractor(course.getInstructor());
		courseDTO.setTotalHours(course.getTotalHours());
		return courseDTO;
	}

	
}
