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


import com.cl.dao.LouyuxinxiDao;
import com.cl.entity.LouyuxinxiEntity;
import com.cl.service.LouyuxinxiService;
import com.cl.entity.view.LouyuxinxiView;

@Service("louyuxinxiService")
public class LouyuxinxiServiceImpl extends ServiceImpl<LouyuxinxiDao, LouyuxinxiEntity> implements LouyuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LouyuxinxiEntity> page = this.selectPage(
                new Query<LouyuxinxiEntity>(params).getPage(),
                new EntityWrapper<LouyuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LouyuxinxiEntity> wrapper) {
		  Page<LouyuxinxiView> page =new Query<LouyuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LouyuxinxiView> selectListView(Wrapper<LouyuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LouyuxinxiView selectView(Wrapper<LouyuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
