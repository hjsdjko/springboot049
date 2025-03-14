package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussfuwuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussfuwuxinxiView;


/**
 * 服务信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
public interface DiscussfuwuxinxiService extends IService<DiscussfuwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussfuwuxinxiView> selectListView(Wrapper<DiscussfuwuxinxiEntity> wrapper);
   	
   	DiscussfuwuxinxiView selectView(@Param("ew") Wrapper<DiscussfuwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussfuwuxinxiEntity> wrapper);
   	

}

