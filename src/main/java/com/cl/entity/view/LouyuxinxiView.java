package com.cl.entity.view;

import com.cl.entity.LouyuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 楼宇信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
@TableName("louyuxinxi")
public class LouyuxinxiView  extends LouyuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LouyuxinxiView(){
	}
 
 	public LouyuxinxiView(LouyuxinxiEntity louyuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, louyuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
