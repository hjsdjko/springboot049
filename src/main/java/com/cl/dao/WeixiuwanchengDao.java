package com.cl.dao;

import com.cl.entity.WeixiuwanchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuwanchengView;


/**
 * 维修完成
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface WeixiuwanchengDao extends BaseMapper<WeixiuwanchengEntity> {
	
	List<WeixiuwanchengView> selectListView(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);

	List<WeixiuwanchengView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
	
	WeixiuwanchengView selectView(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
	

}
