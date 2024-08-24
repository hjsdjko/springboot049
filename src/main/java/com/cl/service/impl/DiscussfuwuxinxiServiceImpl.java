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


import com.cl.dao.DiscussfuwuxinxiDao;
import com.cl.entity.DiscussfuwuxinxiEntity;
import com.cl.service.DiscussfuwuxinxiService;
import com.cl.entity.view.DiscussfuwuxinxiView;

@Service("discussfuwuxinxiService")
public class DiscussfuwuxinxiServiceImpl extends ServiceImpl<DiscussfuwuxinxiDao, DiscussfuwuxinxiEntity> implements DiscussfuwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussfuwuxinxiEntity> page = this.selectPage(
                new Query<DiscussfuwuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussfuwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussfuwuxinxiEntity> wrapper) {
		  Page<DiscussfuwuxinxiView> page =new Query<DiscussfuwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussfuwuxinxiView> selectListView(Wrapper<DiscussfuwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussfuwuxinxiView selectView(Wrapper<DiscussfuwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
