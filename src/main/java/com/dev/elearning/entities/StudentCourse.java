package com.dev.elearning.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_COURSES")
public class StudentCourse {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id")
	private Student student;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id")
	private Course course;

	private Date registrationDate;

	private boolean retired;

	private Date retiredOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isRetired() {
		return retired;
	}

	public void setRetired(boolean retired) {
		this.retired = retired;
	}

	public Date getRetiredOn() {
		return retiredOn;
	}

	public void setRetiredOn(Date retiredOn) {
		this.retiredOn = retiredOn;
	}

}
