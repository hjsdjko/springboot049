package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.LouyuxinxiEntity;
import com.cl.entity.view.LouyuxinxiView;

import com.cl.service.LouyuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 楼宇信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
@RestController
@RequestMapping("/louyuxinxi")
public class LouyuxinxiController {
    @Autowired
    private LouyuxinxiService louyuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LouyuxinxiEntity louyuxinxi,
		HttpServletRequest request){
        EntityWrapper<LouyuxinxiEntity> ew = new EntityWrapper<LouyuxinxiEntity>();

		PageUtils page = louyuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, louyuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LouyuxinxiEntity louyuxinxi, 
		HttpServletRequest request){
        EntityWrapper<LouyuxinxiEntity> ew = new EntityWrapper<LouyuxinxiEntity>();

		PageUtils page = louyuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, louyuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LouyuxinxiEntity louyuxinxi){
       	EntityWrapper<LouyuxinxiEntity> ew = new EntityWrapper<LouyuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( louyuxinxi, "louyuxinxi")); 
        return R.ok().put("data", louyuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LouyuxinxiEntity louyuxinxi){
        EntityWrapper< LouyuxinxiEntity> ew = new EntityWrapper< LouyuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( louyuxinxi, "louyuxinxi")); 
		LouyuxinxiView louyuxinxiView =  louyuxinxiService.selectView(ew);
		return R.ok("查询楼宇信息成功").put("data", louyuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LouyuxinxiEntity louyuxinxi = louyuxinxiService.selectById(id);
		louyuxinxi = louyuxinxiService.selectView(new EntityWrapper<LouyuxinxiEntity>().eq("id", id));
        return R.ok().put("data", louyuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LouyuxinxiEntity louyuxinxi = louyuxinxiService.selectById(id);
		louyuxinxi = louyuxinxiService.selectView(new EntityWrapper<LouyuxinxiEntity>().eq("id", id));
        return R.ok().put("data", louyuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LouyuxinxiEntity louyuxinxi, HttpServletRequest request){
    	louyuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(louyuxinxi);
        louyuxinxiService.insert(louyuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LouyuxinxiEntity louyuxinxi, HttpServletRequest request){
    	louyuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(louyuxinxi);
        louyuxinxiService.insert(louyuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LouyuxinxiEntity louyuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(louyuxinxi);
        louyuxinxiService.updateById(louyuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        louyuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
