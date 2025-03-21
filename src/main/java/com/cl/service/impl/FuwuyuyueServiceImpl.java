package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.FuwuyuyueDao;
import com.cl.entity.FuwuyuyueEntity;
import com.cl.service.FuwuyuyueService;
import com.cl.entity.view.FuwuyuyueView;

@Service("fuwuyuyueService")
public class FuwuyuyueServiceImpl extends ServiceImpl<FuwuyuyueDao, FuwuyuyueEntity> implements FuwuyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FuwuyuyueEntity> page = this.selectPage(
                new Query<FuwuyuyueEntity>(params).getPage(),
                new EntityWrapper<FuwuyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FuwuyuyueEntity> wrapper) {
		  Page<FuwuyuyueView> page =new Query<FuwuyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FuwuyuyueView> selectListView(Wrapper<FuwuyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FuwuyuyueView selectView(Wrapper<FuwuyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
