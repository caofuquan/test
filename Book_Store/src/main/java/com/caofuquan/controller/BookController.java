package com.caofuquan.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.caofuquan.bean.Book;
import com.caofuquan.bean.Discuss;
import com.caofuquan.bean.Praise;
import com.caofuquan.bean.Trample;
import com.caofuquan.service.BookService;
import com.caofuquan.service.DiscussService;
import com.caofuquan.service.PraiseService;
import com.caofuquan.service.TrampleService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired 
	BookService bookService;
	@Autowired
	PraiseService praiseService ;
	@Autowired
	DiscussService discussService;
	@Autowired
	TrampleService trampleService;
	
	
	
	@RequestMapping("/index")
	//@ResponseBody
	public String templet(Book book,Model model) {
		 List<Book> list = bookService.temple(book);
		 model.addAttribute("books", list);
		return "bookHome";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Book book,MultipartFile file,HttpServletRequest request) throws Exception {
		//保存D盘
		String fileName = file.getOriginalFilename();//得到上传时的文件名
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String fileNewName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
		
		//String root = request.getServletContext().getRealPath("/");
		
		String path = "D:/book/upload" + File.separator + fileNewName;
		
		File destFile = new File(path);
		
		if(!destFile.getParentFile().exists())destFile.getParentFile().mkdirs();
		
		file.transferTo(destFile);
		
		book.setPicture(fileNewName);
		
		bookService.insert(book);
		
		return "success";
	}
	
	/**
	 * 在首页点修改时先根据ID查询出相应记录后跳转到修改页面，将查出来的 值赋上
	 * @param book
	 * @param model
	 * @return
	 */
	@RequestMapping("/upd")
	//@ResponseBody
	public String updtemplet(Integer id,Model model,HttpServletRequest request) {
		Book templeupd = bookService.single(id);
		model.addAttribute("b", templeupd);
		return "update";
	}
	
	
	
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(Book book,MultipartFile file,HttpServletRequest request) throws Exception {
		//保存D盘
	/*	String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String fileNewName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
		//在使用ServletContext.getRealPath() 时，传入的参数是从 当前servlet 
		 // 部署在tomcat中的文件夹算起的相对路径，要以"/" 开头，否则会找不到路径，导致NullPointerException
		String root = request.getServletContext().getRealPath("/");
		
		System.out.println(root);
		
		String path = root + File.separator + "upload" + File.separator + fileNewName;
		
		File destFile = new File(path);
		
		if(!destFile.getParentFile().exists())destFile.getParentFile().mkdirs();
		
		file.transferTo(new File(path));
		
		book.setPicture("upload" + File.separator + fileNewName);*/
		
		Integer update = bookService.updateTemplateById(book);
		
		return update;
	}
	/**\
	 * 删除方法
	 */
	@RequestMapping("/delete")
	@ResponseBody
     public int delete (Integer id) {
		return bookService.delete(id);
	}
	/**
	 * 查询详情
	 */
	@RequestMapping("/selecxiangqing")
	//@ResponseBody
	public String selecxiangqign(Integer id,Model model,HttpServletRequest request) {
		
		//详情方法
		Book templeupd = bookService.xiangsele(id);
		//点赞条数
		Praise selecount = praiseService.selecount(id);
		//踩的条数
		int trCount =trampleService.selectramplCount(id);
		
		//评价查询
		List<Discuss> slectcontent = discussService.slectcontent(id);
		//点赞条数查询后处理
		int pCount= 0;
		
		//点赞条数如果为null，则设置为1，否则条数加1
		if(selecount != null && selecount.getPraiseCount()!=null) {
			pCount = selecount.getPraiseCount();
		}
		//praiseService.updatetemp(praiseBean);
		
		model.addAttribute("ben", templeupd);
		model.addAttribute("pCount", pCount);
		model.addAttribute("trCount", trCount);
		model.addAttribute("slectcontent", slectcontent);
		
		
		return "xiangqing";
	}
	
	/**
	 * 点赞跳转方法
	 */
	@RequestMapping("/praise")
	@ResponseBody
	public int praise(Integer id) {
		return this.praiseService.updatetemp(id);
	}
	/**\
	 * 踩
	 */
	@RequestMapping("/trample")
	@ResponseBody
	public int trample(Integer id) {
		return trampleService.updateTramp(id);
	}
	/**
	 * 评价
	 */
	@RequestMapping("/evaluate")
	@ResponseBody
	public String evaluate(String content,Integer id) {
		discussService.insertDiscuss(content,id);
		return "seccess";
	}
}
