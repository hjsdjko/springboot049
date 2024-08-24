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


import com.cl.dao.DiscussweixiuyuanDao;
import com.cl.entity.DiscussweixiuyuanEntity;
import com.cl.service.DiscussweixiuyuanService;
import com.cl.entity.view.DiscussweixiuyuanView;

@Service("discussweixiuyuanService")
public class DiscussweixiuyuanServiceImpl extends ServiceImpl<DiscussweixiuyuanDao, DiscussweixiuyuanEntity> implements DiscussweixiuyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussweixiuyuanEntity> page = this.selectPage(
                new Query<DiscussweixiuyuanEntity>(params).getPage(),
                new EntityWrapper<DiscussweixiuyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussweixiuyuanEntity> wrapper) {
		  Page<DiscussweixiuyuanView> page =new Query<DiscussweixiuyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussweixiuyuanView> selectListView(Wrapper<DiscussweixiuyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussweixiuyuanView selectView(Wrapper<DiscussweixiuyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
