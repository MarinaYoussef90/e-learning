package com.dev.elearning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.dev.elearning.dto.CourseDTO;
import com.dev.elearning.entities.Course;

public class ElearningTest extends AbstractTest {

	@Test
	public void createCourse() throws Exception {
	   String uri = "/course";
	   Course course = new Course();
	   course.setId(1);
	   course.setName("Java SE");
	   course.setDescription("Basic Java Programming");
	   course.setPublishDate(new Date());
   
	   String inputJson = super.mapToJson(course);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "Course is created successfully");
	}
	
	//@Test
	public void getCoursesList() throws Exception {
	   String uri = "/course";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   CourseDTO[] CourseList = super.mapFromJson(content, CourseDTO[].class);
	   assertTrue(CourseList.length > 0);
	}
}
