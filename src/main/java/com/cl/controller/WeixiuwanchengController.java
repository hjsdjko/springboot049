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

import com.cl.entity.WeixiuwanchengEntity;
import com.cl.entity.view.WeixiuwanchengView;

import com.cl.service.WeixiuwanchengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修完成
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:14:24
 */
@RestController
@RequestMapping("/weixiuwancheng")
public class WeixiuwanchengController {
    @Autowired
    private WeixiuwanchengService weixiuwanchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuwanchengEntity weixiuwancheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weixiuwancheng.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("weixiuyuan")) {
			weixiuwancheng.setWeixiugonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();

		PageUtils page = weixiuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuwancheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiuwanchengEntity weixiuwancheng, 
		HttpServletRequest request){
        EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();

		PageUtils page = weixiuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuwancheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuwanchengEntity weixiuwancheng){
       	EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuwancheng, "weixiuwancheng")); 
        return R.ok().put("data", weixiuwanchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuwanchengEntity weixiuwancheng){
        EntityWrapper< WeixiuwanchengEntity> ew = new EntityWrapper< WeixiuwanchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuwancheng, "weixiuwancheng")); 
		WeixiuwanchengView weixiuwanchengView =  weixiuwanchengService.selectView(ew);
		return R.ok("查询维修完成成功").put("data", weixiuwanchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
		weixiuwancheng = weixiuwanchengService.selectView(new EntityWrapper<WeixiuwanchengEntity>().eq("id", id));
        return R.ok().put("data", weixiuwancheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
		weixiuwancheng = weixiuwanchengService.selectView(new EntityWrapper<WeixiuwanchengEntity>().eq("id", id));
        return R.ok().put("data", weixiuwancheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
    	weixiuwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuwancheng);
        weixiuwanchengService.insert(weixiuwancheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
    	weixiuwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuwancheng);
        weixiuwanchengService.insert(weixiuwancheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuwancheng);
        weixiuwanchengService.updateById(weixiuwancheng);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<WeixiuwanchengEntity> list = new ArrayList<WeixiuwanchengEntity>();
        for(Long id : ids) {
            WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
            weixiuwancheng.setSfsh(sfsh);
            weixiuwancheng.setShhf(shhf);
            list.add(weixiuwancheng);
        }
        weixiuwanchengService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiuwanchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
