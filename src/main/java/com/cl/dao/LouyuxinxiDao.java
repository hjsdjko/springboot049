package com.cl.dao;

import com.cl.entity.LouyuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LouyuxinxiView;


/**
 * 楼宇信息
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
public interface LouyuxinxiDao extends BaseMapper<LouyuxinxiEntity> {
	
	List<LouyuxinxiView> selectListView(@Param("ew") Wrapper<LouyuxinxiEntity> wrapper);

	List<LouyuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LouyuxinxiEntity> wrapper);
	
	LouyuxinxiView selectView(@Param("ew") Wrapper<LouyuxinxiEntity> wrapper);
	

}
