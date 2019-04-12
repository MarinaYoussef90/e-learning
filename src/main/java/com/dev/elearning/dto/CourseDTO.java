package com.dev.elearning.dto;

import java.io.Serializable;
import java.util.Date;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = -8506321466713485640L;
	private long id;
	private String name;
	private String description;
	private Date publishDate;
	private Date lastUpdated;
	private float totalHours;
	private String instractor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public float getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(float totalHours) {
		this.totalHours = totalHours;
	}

	public String getInstractor() {
		return instractor;
	}

	public void setInstractor(String instractor) {
		this.instractor = instractor;
	}

}
