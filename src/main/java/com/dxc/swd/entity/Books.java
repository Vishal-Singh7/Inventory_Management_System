package com.dxc.swd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "books")
public class Books implements Serializable {

	@Id
	@Column(name = "bcode")
	@NotNull(message = "bcode can not be blank")
	private Integer bcode;

	@Column(name = "title", nullable = false)
	@NotBlank(message = "title can not be blank")
	@Size(min = 4, max = 45, message = "title must be of 5 to 45 chars in length")
	private String title;

	@Column(name = "author", nullable = false)
	@NotBlank(message = "author can not be blank")
	@Size(min = 4, max = 45, message = "title must be of 5 to 45 chars in length")
	private String author;

	@Column(name = "publishDate", nullable = true)
	@NotNull(message = "date can not be blank")
	@PastOrPresent(message = "Publish Date can not be a future date")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate publishDate;

	public Books() {
		// left unimplemented
	}

	public Integer getBcode() {
		return bcode;
	}

	public void setBcode(Integer bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getpublishDate() {
		return publishDate;
	}

	public void setpublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

}
