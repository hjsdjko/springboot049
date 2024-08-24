package com.cl.dao;

import com.cl.entity.FuwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.FuwuxinxiView;


/**
 * 服务信息
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface FuwuxinxiDao extends BaseMapper<FuwuxinxiEntity> {
	
	List<FuwuxinxiView> selectListView(@Param("ew") Wrapper<FuwuxinxiEntity> wrapper);

	List<FuwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FuwuxinxiEntity> wrapper);
	
	FuwuxinxiView selectView(@Param("ew") Wrapper<FuwuxinxiEntity> wrapper);
	

}
