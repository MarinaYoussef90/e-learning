package com.dev.elearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.elearning.dto.StudentDTO;
import com.dev.elearning.services.CourseService;
import com.dev.elearning.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void registerNewStudent(@RequestBody StudentDTO studentDTO) {
		studentService.registerNewStudent(studentDTO);
	}

}
