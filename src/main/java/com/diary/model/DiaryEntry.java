package com.diary.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class DiaryEntry implements Serializable {

	private static final long serialVersionUID = 82077455483358576L;

	private Long id;

	@NotNull(message = "Title is mandatory")
	@NotEmpty(message = "Title is mandatory")
	@Size(max = 50, message = "Max size is 50")
	private String title;

	@NotNull(message = "Post is mandatory")
	@NotEmpty(message = "Post is mandatory")
	@Size(max = 2000, message = "Max size is 2000")
	private String post;

	private Date createDate;

	private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}