package com.cl.dao;

import com.cl.entity.DiscussweixiuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussweixiuyuanView;


/**
 * 维修员评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface DiscussweixiuyuanDao extends BaseMapper<DiscussweixiuyuanEntity> {
	
	List<DiscussweixiuyuanView> selectListView(@Param("ew") Wrapper<DiscussweixiuyuanEntity> wrapper);

	List<DiscussweixiuyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussweixiuyuanEntity> wrapper);
	
	DiscussweixiuyuanView selectView(@Param("ew") Wrapper<DiscussweixiuyuanEntity> wrapper);
	

}
