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


import com.cl.dao.WeixiuwanchengDao;
import com.cl.entity.WeixiuwanchengEntity;
import com.cl.service.WeixiuwanchengService;
import com.cl.entity.view.WeixiuwanchengView;

@Service("weixiuwanchengService")
public class WeixiuwanchengServiceImpl extends ServiceImpl<WeixiuwanchengDao, WeixiuwanchengEntity> implements WeixiuwanchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiuwanchengEntity> page = this.selectPage(
                new Query<WeixiuwanchengEntity>(params).getPage(),
                new EntityWrapper<WeixiuwanchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiuwanchengEntity> wrapper) {
		  Page<WeixiuwanchengView> page =new Query<WeixiuwanchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WeixiuwanchengView> selectListView(Wrapper<WeixiuwanchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiuwanchengView selectView(Wrapper<WeixiuwanchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
