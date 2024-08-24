package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WeixiuwanchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WeixiuwanchengView;


/**
 * 维修完成
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface WeixiuwanchengService extends IService<WeixiuwanchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuwanchengView> selectListView(Wrapper<WeixiuwanchengEntity> wrapper);
   	
   	WeixiuwanchengView selectView(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuwanchengEntity> wrapper);
   	

}

