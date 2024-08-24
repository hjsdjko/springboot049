package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LouyuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LouyuxinxiView;


/**
 * 楼宇信息
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
public interface LouyuxinxiService extends IService<LouyuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LouyuxinxiView> selectListView(Wrapper<LouyuxinxiEntity> wrapper);
   	
   	LouyuxinxiView selectView(@Param("ew") Wrapper<LouyuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LouyuxinxiEntity> wrapper);
   	

}

