package com.dev.elearning.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.elearning.dto.CourseDTO;
import com.dev.elearning.services.CourseRegistrationService;
import com.dev.elearning.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRegisterationController {
		
	@Autowired
	CourseService courseService;

	@Autowired
	CourseRegistrationService courseRegistrationService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void addCourse(@RequestBody CourseDTO courseDTO ) {
		courseService.addCourse(courseDTO);	
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CourseDTO> getAllCourses() {
		List<CourseDTO> courseDTOs = courseService.getAllCourses();
        return courseDTOs;
    }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void registerStudent(@RequestParam("studentId")long studentId, @RequestParam("courseId")long courseId) {
		//TODO: get studentId from session after login
		courseRegistrationService.registerStudent(studentId, courseId);	
	}
	
	@RequestMapping(value="/unregister", method=RequestMethod.PUT)
	public void unRegisterStudent(@RequestParam("studentId")long studentId, @RequestParam("courseId")long courseId) {
		//TODO: get studentId from session after login
		courseRegistrationService.unRegisterStudent(studentId, courseId);	
	}
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public List<CourseDTO> getStudentRegisteredCourses(@RequestParam("studentId") long studentId) {
		List<CourseDTO> courseDTOs = courseRegistrationService.getStudentRegisteredCourses(studentId);
        return courseDTOs;
    }
}
