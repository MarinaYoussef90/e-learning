package com.dev.elearning.services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.elearning.dto.StudentDTO;
import com.dev.elearning.entities.Student;
import com.dev.elearning.exception.ElearningException;
import com.dev.elearning.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void registerNewStudent(StudentDTO studentDTO) {

		if (studentDTO != null) {
			// Validation
			if (studentDTO.getName() == null || studentDTO.getName().equals("")) {
				throw new ElearningException("Please, provide student name.");
			}
			if (studentDTO.getEmail() == null || studentDTO.getEmail().equals("") || !validateEmailRegix(studentDTO.getEmail())) {
				throw new ElearningException("Please, provide correct student email.");
			}
			if (studentDTO.getUsername() == null || studentDTO.getUsername().equals("")) {
				throw new ElearningException("Please, provide student username.");
			}
			if (studentDTO.getPassword() == null || studentDTO.getPassword().equals("")) {
				throw new ElearningException("Please, provide student password.");
			}
			// validate repeated email
			int count = studentRepository.countByEmail(studentDTO.getEmail());
			if(count > 0) 
				throw new ElearningException("Your email alredy exist, Please Login.");
			
			// Prepare the object
			Student student = new Student();
			student.setName(studentDTO.getName());
			student.setEmail(studentDTO.getEmail());
			student.setUsername(studentDTO.getUsername());
			student.setPassword(studentDTO.getPassword());
			student.setGender(studentDTO.getGender());
			student.setBirthDate(studentDTO.getBirthDate());
			
			// Save
			studentRepository.save(student);
		}
	}

	
	@Override
	public Student getStudentById(long id) {

		if(id != 0) {
			Optional<Student> optional = studentRepository.findById(id);
			if(optional.isPresent()) {
				Student student = optional.get();
				return student;
			} else 
				throw new ElearningException("ID should be greater than 0.");
		}
		return null;
	}
	
	private boolean validateEmailRegix(String email) {
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
