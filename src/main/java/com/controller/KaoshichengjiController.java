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

import com.entity.KaoshichengjiEntity;
import com.entity.view.KaoshichengjiView;

import com.service.KaoshichengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 考试成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
@RestController
@RequestMapping("/kaoshichengji")
public class KaoshichengjiController {
    @Autowired
    private KaoshichengjiService kaoshichengjiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaoshichengjiEntity kaoshichengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			kaoshichengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			kaoshichengji.setJiaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();

		PageUtils page = kaoshichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoshichengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaoshichengjiEntity kaoshichengji, 
		HttpServletRequest request){
        EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();

		PageUtils page = kaoshichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoshichengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaoshichengjiEntity kaoshichengji){
       	EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaoshichengji, "kaoshichengji")); 
        return R.ok().put("data", kaoshichengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaoshichengjiEntity kaoshichengji){
        EntityWrapper< KaoshichengjiEntity> ew = new EntityWrapper< KaoshichengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaoshichengji, "kaoshichengji")); 
		KaoshichengjiView kaoshichengjiView =  kaoshichengjiService.selectView(ew);
		return R.ok("查询考试成绩成功").put("data", kaoshichengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaoshichengjiEntity kaoshichengji = kaoshichengjiService.selectById(id);
        return R.ok().put("data", kaoshichengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaoshichengjiEntity kaoshichengji = kaoshichengjiService.selectById(id);
        return R.ok().put("data", kaoshichengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request){
    	kaoshichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoshichengji);
        kaoshichengjiService.insert(kaoshichengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request){
    	kaoshichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoshichengji);
        kaoshichengjiService.insert(kaoshichengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaoshichengji);
        kaoshichengjiService.updateById(kaoshichengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaoshichengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
