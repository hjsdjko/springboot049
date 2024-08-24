package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussweixiuyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussweixiuyuanView;


/**
 * 维修员评论表
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface DiscussweixiuyuanService extends IService<DiscussweixiuyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussweixiuyuanView> selectListView(Wrapper<DiscussweixiuyuanEntity> wrapper);
   	
   	DiscussweixiuyuanView selectView(@Param("ew") Wrapper<DiscussweixiuyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussweixiuyuanEntity> wrapper);
   	

}

