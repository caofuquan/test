package com.caofuquan.bean;

import java.util.Date;

	public class Book {
		
		private Integer id;
		private String name;
		private Double price;
		private String author;
		private String picture;
		private Integer number;
		private Date publishDate;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public Integer getNumber() {
			return number;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}
		public Date getPublishDate() {
			return publishDate;
		}
		public void setPublishDate(Date publishDate) {
			this.publishDate = publishDate;
		}
	}


