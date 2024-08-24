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
 * 楼宇信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
@TableName("louyuxinxi")
public class LouyuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LouyuxinxiEntity() {
		
	}
	
	public LouyuxinxiEntity(T t) {
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
	 * 楼宇编号
	 */
					
	private String louyubianhao;
	
	/**
	 * 楼宇名称
	 */
					
	private String louyumingcheng;
	
	/**
	 * 楼层数
	 */
					
	private String loucengshu;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 楼宇位置
	 */
					
	private String louyuweizhi;
	
	/**
	 * 楼宇详情
	 */
					
	private String louyuxiangqing;
	
	
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
	 * 设置：楼宇编号
	 */
	public void setLouyubianhao(String louyubianhao) {
		this.louyubianhao = louyubianhao;
	}
	/**
	 * 获取：楼宇编号
	 */
	public String getLouyubianhao() {
		return louyubianhao;
	}
	/**
	 * 设置：楼宇名称
	 */
	public void setLouyumingcheng(String louyumingcheng) {
		this.louyumingcheng = louyumingcheng;
	}
	/**
	 * 获取：楼宇名称
	 */
	public String getLouyumingcheng() {
		return louyumingcheng;
	}
	/**
	 * 设置：楼层数
	 */
	public void setLoucengshu(String loucengshu) {
		this.loucengshu = loucengshu;
	}
	/**
	 * 获取：楼层数
	 */
	public String getLoucengshu() {
		return loucengshu;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：楼宇位置
	 */
	public void setLouyuweizhi(String louyuweizhi) {
		this.louyuweizhi = louyuweizhi;
	}
	/**
	 * 获取：楼宇位置
	 */
	public String getLouyuweizhi() {
		return louyuweizhi;
	}
	/**
	 * 设置：楼宇详情
	 */
	public void setLouyuxiangqing(String louyuxiangqing) {
		this.louyuxiangqing = louyuxiangqing;
	}
	/**
	 * 获取：楼宇详情
	 */
	public String getLouyuxiangqing() {
		return louyuxiangqing;
	}

}
