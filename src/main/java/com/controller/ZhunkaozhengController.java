package com.controller;

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

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.ZhunkaozhengEntity;
import com.entity.view.ZhunkaozhengView;

import com.service.ZhunkaozhengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 准考证
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
@RestController
@RequestMapping("/zhunkaozheng")
public class ZhunkaozhengController {
    @Autowired
    private ZhunkaozhengService zhunkaozhengService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhunkaozhengEntity zhunkaozheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zhunkaozheng.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			zhunkaozheng.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhunkaozhengEntity> ew = new EntityWrapper<ZhunkaozhengEntity>();

		PageUtils page = zhunkaozhengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhunkaozheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhunkaozhengEntity zhunkaozheng, 
		HttpServletRequest request){
        EntityWrapper<ZhunkaozhengEntity> ew = new EntityWrapper<ZhunkaozhengEntity>();

		PageUtils page = zhunkaozhengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhunkaozheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhunkaozhengEntity zhunkaozheng){
       	EntityWrapper<ZhunkaozhengEntity> ew = new EntityWrapper<ZhunkaozhengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhunkaozheng, "zhunkaozheng")); 
        return R.ok().put("data", zhunkaozhengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhunkaozhengEntity zhunkaozheng){
        EntityWrapper< ZhunkaozhengEntity> ew = new EntityWrapper< ZhunkaozhengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhunkaozheng, "zhunkaozheng")); 
		ZhunkaozhengView zhunkaozhengView =  zhunkaozhengService.selectView(ew);
		return R.ok("查询准考证成功").put("data", zhunkaozhengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhunkaozhengEntity zhunkaozheng = zhunkaozhengService.selectById(id);
        return R.ok().put("data", zhunkaozheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhunkaozhengEntity zhunkaozheng = zhunkaozhengService.selectById(id);
        return R.ok().put("data", zhunkaozheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhunkaozhengEntity zhunkaozheng, HttpServletRequest request){
    	zhunkaozheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhunkaozheng);
        zhunkaozhengService.insert(zhunkaozheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhunkaozhengEntity zhunkaozheng, HttpServletRequest request){
    	zhunkaozheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhunkaozheng);
        zhunkaozhengService.insert(zhunkaozheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhunkaozhengEntity zhunkaozheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhunkaozheng);
        zhunkaozhengService.updateById(zhunkaozheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhunkaozhengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
