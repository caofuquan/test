package com.caofuquan.service.impl;

import java.util.List;

import org.beetl.sql.core.db.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caofuquan.bean.Book;
import com.caofuquan.dao.BookDao;
import com.caofuquan.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookdao;
	
	@Override
	public List<Book> temple(Book book){
		return bookdao.template(book);
		
	}

	@Override
	public void insert(Book book) {
		/*bookdao.insert(book, true);
		System.out.println(book.getId());*/
		KeyHolder insertReturnKey = bookdao.insertReturnKey(book);
		
	}

//	@Override
//	public Integer update(Book book) {
//		int i = bookdao.updateTemplateById(book);
//		System.out.println(i);
//		return i;
//	}

	@Override
	public Book single(Integer id) {
		 Book single = bookdao.single(id);
		return single;
	}

	@Override
	public Integer updateTemplateById(Book book) {
		int num = bookdao.updateTemplateById(book);
		return num;
	}

	@Override
	public int delete(Integer id) {
		return bookdao.deleteById(id);
		
	}

	@Override
	public Book xiangsele(Integer id) {
		Book sle = bookdao.single(id);
		return sle;
	}

}
