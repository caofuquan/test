package com.caofuquan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caofuquan.bean.Praise;
import com.caofuquan.dao.PraiseDao;
import com.caofuquan.service.PraiseService;
@Service
public class PraiseServiceImpl implements PraiseService {

	@Autowired
	PraiseDao praiseDao;
	
	@Override
	public Praise selecount(Integer bookId) {
		Praise praise = new Praise();
		praise.setBookId(bookId);
		Praise priseList = praiseDao.templateOne(praise);
		return priseList;
		
	}
	@Override
	public int updatetemp(Integer bookId) {
		Praise praise = new Praise();
		praise.setBookId(bookId);
		Praise templateOne = praiseDao.templateOne(praise);
		/**
		 * 判断是否为空
		 */
		if(templateOne == null) {
			//为空的话插入一条新的数据
			praise.setPraiseCount(1);
			praiseDao.insert(praise);
			return praise.getPraiseCount();
		}
		/**
		 * 有记录的话，在原有的记录上+1
		 */
		templateOne.setPraiseCount(templateOne.getPraiseCount()+1);
		praiseDao.updateById(templateOne);
		return templateOne.getPraiseCount();
		
	}

}
