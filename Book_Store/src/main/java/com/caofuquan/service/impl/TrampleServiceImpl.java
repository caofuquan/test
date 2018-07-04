package com.caofuquan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caofuquan.bean.Trample;
import com.caofuquan.dao.TrampleDao;
import com.caofuquan.service.TrampleService;
@Service
public class TrampleServiceImpl implements TrampleService {

	@Autowired
	TrampleDao trampleDao;
	
	@Override
	public int selectramplCount(Integer id) {
		Trample trample =new Trample();
		trample.setBookId(id);
		Trample tramplCount =trampleDao.templateOne(trample);
		//如果tramplCount.getTrampleCount()为空，则设为0，如果不为空返回去正常显示
		
		if (tramplCount==null || tramplCount.getTrampleCount()==null) {
			
			return 0;
		}
		
		return tramplCount.getTrampleCount();
		
		
	}

	@Override
	public int updateTramp(Integer id) {
		Trample trample =new Trample();
		trample.setBookId(id);
		Trample cp = trampleDao.templateOne(trample);
		if(cp==null) {
			trample.setTrampleCount(1);
			trampleDao.insert(trample);
			return trample.getTrampleCount();
		}
			cp.setTrampleCount(cp.getTrampleCount()+1);
			trampleDao.updateTemplateById(cp);
			return cp.getTrampleCount();
			
		
	}

}
