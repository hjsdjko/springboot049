package com.cl.dao;

import com.cl.entity.GonggongsheshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggongsheshiView;


/**
 * 公共设施
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
public interface GonggongsheshiDao extends BaseMapper<GonggongsheshiEntity> {
	
	List<GonggongsheshiView> selectListView(@Param("ew") Wrapper<GonggongsheshiEntity> wrapper);

	List<GonggongsheshiView> selectListView(Pagination page,@Param("ew") Wrapper<GonggongsheshiEntity> wrapper);
	
	GonggongsheshiView selectView(@Param("ew") Wrapper<GonggongsheshiEntity> wrapper);
	

}
