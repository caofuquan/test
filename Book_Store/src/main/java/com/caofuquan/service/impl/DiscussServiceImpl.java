package com.caofuquan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caofuquan.bean.Discuss;
import com.caofuquan.dao.DiscussDao;
import com.caofuquan.service.DiscussService;
@Service
public class DiscussServiceImpl implements DiscussService {

	@Autowired
	DiscussDao discussDao;
	@Override
	public void insertDiscuss(String content, Integer id) {
		Discuss discuss = new Discuss();
		discuss.setBookId(id);
		discuss.setDiscuss(content);
		discussDao.insert(discuss);
		
	}
	@Override
	public List<Discuss> slectcontent(Integer id) {
		Discuss discuss = new Discuss();
		discuss.setBookId(id);
//		 List<Discuss> template = discussDao.template(discuss);
//		 for (Discuss discusscontent : template) {
//			
//		 if(discusscontent!=null) {
//			 return template;
//		 }else {
//			 
//		 }
//		 }
		 return discussDao.template(discuss);
	}

}
