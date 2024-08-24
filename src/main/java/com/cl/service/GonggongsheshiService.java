package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GonggongsheshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggongsheshiView;


/**
 * 公共设施
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
public interface GonggongsheshiService extends IService<GonggongsheshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonggongsheshiView> selectListView(Wrapper<GonggongsheshiEntity> wrapper);
   	
   	GonggongsheshiView selectView(@Param("ew") Wrapper<GonggongsheshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonggongsheshiEntity> wrapper);
   	

}

