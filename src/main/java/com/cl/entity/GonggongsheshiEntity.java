package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 公共设施
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
@TableName("gonggongsheshi")
public class GonggongsheshiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GonggongsheshiEntity() {
		
	}
	
	public GonggongsheshiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 设施编号
	 */
					
	private String sheshibianhao;
	
	/**
	 * 设施名称
	 */
					
	private String sheshimingcheng;
	
	/**
	 * 设施图片
	 */
					
	private String sheshitupian;
	
	/**
	 * 施设位置
	 */
					
	private String shisheweizhi;
	
	/**
	 * 施设规模
	 */
					
	private String shisheguimo;
	
	/**
	 * 设施详情
	 */
					
	private String sheshixiangqing;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：设施编号
	 */
	public void setSheshibianhao(String sheshibianhao) {
		this.sheshibianhao = sheshibianhao;
	}
	/**
	 * 获取：设施编号
	 */
	public String getSheshibianhao() {
		return sheshibianhao;
	}
	/**
	 * 设置：设施名称
	 */
	public void setSheshimingcheng(String sheshimingcheng) {
		this.sheshimingcheng = sheshimingcheng;
	}
	/**
	 * 获取：设施名称
	 */
	public String getSheshimingcheng() {
		return sheshimingcheng;
	}
	/**
	 * 设置：设施图片
	 */
	public void setSheshitupian(String sheshitupian) {
		this.sheshitupian = sheshitupian;
	}
	/**
	 * 获取：设施图片
	 */
	public String getSheshitupian() {
		return sheshitupian;
	}
	/**
	 * 设置：施设位置
	 */
	public void setShisheweizhi(String shisheweizhi) {
		this.shisheweizhi = shisheweizhi;
	}
	/**
	 * 获取：施设位置
	 */
	public String getShisheweizhi() {
		return shisheweizhi;
	}
	/**
	 * 设置：施设规模
	 */
	public void setShisheguimo(String shisheguimo) {
		this.shisheguimo = shisheguimo;
	}
	/**
	 * 获取：施设规模
	 */
	public String getShisheguimo() {
		return shisheguimo;
	}
	/**
	 * 设置：设施详情
	 */
	public void setSheshixiangqing(String sheshixiangqing) {
		this.sheshixiangqing = sheshixiangqing;
	}
	/**
	 * 获取：设施详情
	 */
	public String getSheshixiangqing() {
		return sheshixiangqing;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
