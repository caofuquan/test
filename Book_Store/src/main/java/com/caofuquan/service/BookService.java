package com.caofuquan.service;

import java.util.List;

import com.caofuquan.bean.Book;

public interface BookService {

	public List<Book> temple(Book book);

	public void insert(Book book);

	//public Integer update(Book book);

	public Book single(Integer id);

	public Integer updateTemplateById(Book book);

	public int delete(Integer id);

	public Book xiangsele(Integer id);
		
		
	

}
