package com.cl.dao;

import com.cl.entity.DiscussfuwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfuwuxinxiView;


/**
 * 服务信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface DiscussfuwuxinxiDao extends BaseMapper<DiscussfuwuxinxiEntity> {
	
	List<DiscussfuwuxinxiView> selectListView(@Param("ew") Wrapper<DiscussfuwuxinxiEntity> wrapper);

	List<DiscussfuwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussfuwuxinxiEntity> wrapper);
	
	DiscussfuwuxinxiView selectView(@Param("ew") Wrapper<DiscussfuwuxinxiEntity> wrapper);
	

}
