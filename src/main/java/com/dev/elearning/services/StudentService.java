package com.dev.elearning.services;

import com.dev.elearning.dto.StudentDTO;
import com.dev.elearning.entities.Student;

public interface StudentService {
	
	public void registerNewStudent (StudentDTO studentDTO);
	
	public Student getStudentById (long Id);
}
