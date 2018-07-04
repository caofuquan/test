package com.caofuquan.service;

import java.util.List;

import com.caofuquan.bean.Discuss;

public interface DiscussService {

	public void insertDiscuss(String content, Integer id);

	public List<Discuss> slectcontent(Integer id);

	

	

}
