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

import com.cl.entity.WeixiuyuanEntity;
import com.cl.entity.view.WeixiuyuanView;

import com.cl.service.WeixiuyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:14:23
 */
@RestController
@RequestMapping("/weixiuyuan")
public class WeixiuyuanController {
    @Autowired
    private WeixiuyuanService weixiuyuanService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WeixiuyuanEntity u = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"weixiuyuan",  "维修员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeixiuyuanEntity weixiuyuan){
    	//ValidatorUtils.validateEntity(weixiuyuan);
    	WeixiuyuanEntity u = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", weixiuyuan.getWeixiugonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weixiuyuan.setId(uId);
        weixiuyuanService.insert(weixiuyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        WeixiuyuanEntity u = weixiuyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WeixiuyuanEntity u = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        weixiuyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuyuanEntity weixiuyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("weixiuyuan")) {
			weixiuyuan.setWeixiugonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiuyuanEntity> ew = new EntityWrapper<WeixiuyuanEntity>();

		PageUtils page = weixiuyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiuyuanEntity weixiuyuan, 
		HttpServletRequest request){
        EntityWrapper<WeixiuyuanEntity> ew = new EntityWrapper<WeixiuyuanEntity>();

		PageUtils page = weixiuyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuyuanEntity weixiuyuan){
       	EntityWrapper<WeixiuyuanEntity> ew = new EntityWrapper<WeixiuyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuyuan, "weixiuyuan")); 
        return R.ok().put("data", weixiuyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuyuanEntity weixiuyuan){
        EntityWrapper< WeixiuyuanEntity> ew = new EntityWrapper< WeixiuyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuyuan, "weixiuyuan")); 
		WeixiuyuanView weixiuyuanView =  weixiuyuanService.selectView(ew);
		return R.ok("查询维修员成功").put("data", weixiuyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
		weixiuyuan = weixiuyuanService.selectView(new EntityWrapper<WeixiuyuanEntity>().eq("id", id));
        return R.ok().put("data", weixiuyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
		weixiuyuan = weixiuyuanService.selectView(new EntityWrapper<WeixiuyuanEntity>().eq("id", id));
        return R.ok().put("data", weixiuyuan);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
        if(type.equals("1")) {
        	weixiuyuan.setThumbsupnum(weixiuyuan.getThumbsupnum()+1);
        } else {
        	weixiuyuan.setCrazilynum(weixiuyuan.getCrazilynum()+1);
        }
        weixiuyuanService.updateById(weixiuyuan);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request){
        if(weixiuyuanService.selectCount(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", weixiuyuan.getWeixiugonghao()))>0) {
            return R.error("维修工号已存在");
        }
    	weixiuyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuyuan);
    	WeixiuyuanEntity u = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", weixiuyuan.getWeixiugonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiuyuan.setId(new Date().getTime());
        weixiuyuanService.insert(weixiuyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request){
        if(weixiuyuanService.selectCount(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", weixiuyuan.getWeixiugonghao()))>0) {
            return R.error("维修工号已存在");
        }
    	weixiuyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuyuan);
    	WeixiuyuanEntity u = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("weixiugonghao", weixiuyuan.getWeixiugonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		weixiuyuan.setId(new Date().getTime());
        weixiuyuanService.insert(weixiuyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuyuan);
        weixiuyuanService.updateById(weixiuyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiuyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
