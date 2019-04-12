package com.dev.elearning.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.elearning.dto.CourseDTO;
import com.dev.elearning.entities.Course;
import com.dev.elearning.entities.Student;
import com.dev.elearning.entities.StudentCourse;
import com.dev.elearning.exception.ElearningException;
import com.dev.elearning.repositories.StudentCouresRepository;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

	@Autowired
	StudentCouresRepository studentCouresRepository;

	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;

	@Override
	public void registerStudent(long studentId, long courseId) {

		// Validate Student Id
		Student student = studentService.getStudentById(studentId);
		if (student == null)
			throw new ElearningException("Could not found a student with ID: " + studentId);

		// Validate CourseId
		Course course = courseService.getCourseByID(courseId);
		if (course == null)
			throw new ElearningException("Could not found a course with ID: " + courseId);

		// Validate Student not registered before
		StudentCourse studentCourse = studentCouresRepository.findByStudentIdAndCourseIdAndRetired(studentId, courseId, false);
		if (studentCourse != null)
			throw new ElearningException(
					"Student: " + student.getName() + " is already registered to " + course.getName() + " course.");

		StudentCourse studentCourseRegister = new StudentCourse();
		studentCourseRegister.setStudent(student);
		studentCourseRegister.setCourse(course);
		studentCourseRegister.setRegistrationDate(new Date());
		studentCouresRepository.save(studentCourseRegister);

	}

	@Override
	public void unRegisterStudent(long studentId, long courseId) {
		
		// Validate Student Id
		Student student = studentService.getStudentById(studentId);
		if (student == null)
			throw new ElearningException("Could not found a student with ID: " + studentId);

		// Validate CourseId
		Course course = courseService.getCourseByID(courseId);
		if (course == null)
			throw new ElearningException("Could not found a course with ID: " + courseId);

		// Validate Student not registered before
		StudentCourse studentCourse = studentCouresRepository.findByStudentIdAndCourseIdAndRetired(studentId, courseId, false);
		if (studentCourse == null)
			throw new ElearningException(
					"Student: " + student.getName() + " is not registered to " + courseId + " course.");

		studentCourse.setRetired(true);
		studentCourse.setRetiredOn(new Date());
		studentCouresRepository.save(studentCourse);
	}

	@Override
	public List<CourseDTO> getStudentRegisteredCourses(long studentId) {
		
		// Validate Student Id
		Student student = studentService.getStudentById(studentId);
		if (student == null)
			throw new ElearningException("Could not found a student with ID: " + studentId);
	
		List<StudentCourse> studentCourses = studentCouresRepository.findByStudentIdAndRetired(studentId, false);
		
		if(studentCourses != null) {
			List<CourseDTO> courseDTOs = new ArrayList<>();
			for (StudentCourse studentCourse : studentCourses) {
				courseDTOs.add(convertToDTO(studentCourse.getCourse()));
			}
			return courseDTOs;
		}
		
		return null;
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
