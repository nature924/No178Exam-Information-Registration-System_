package com.entity;

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
 * 考试成绩
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
@TableName("kaoshichengji")
public class KaoshichengjiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaoshichengjiEntity() {
		
	}
	
	public KaoshichengjiEntity(T t) {
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
	 * 准考证编号
	 */
					
	private String zhunkaozhengbianhao;
	
	/**
	 * 考试编号
	 */
					
	private String kaoshibianhao;
	
	/**
	 * 科目名称
	 */
					
	private String kemumingcheng;
	
	/**
	 * 考试地点
	 */
					
	private String kaoshididian;
	
	/**
	 * 考试日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date kaoshiriqi;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 考试成绩
	 */
					
	private String kaoshichengji;
	
	/**
	 * 试卷
	 */
					
	private String shijuan;
	
	/**
	 * 教师账号
	 */
					
	private String jiaoshizhanghao;
	
	
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
	 * 设置：准考证编号
	 */
	public void setZhunkaozhengbianhao(String zhunkaozhengbianhao) {
		this.zhunkaozhengbianhao = zhunkaozhengbianhao;
	}
	/**
	 * 获取：准考证编号
	 */
	public String getZhunkaozhengbianhao() {
		return zhunkaozhengbianhao;
	}
	/**
	 * 设置：考试编号
	 */
	public void setKaoshibianhao(String kaoshibianhao) {
		this.kaoshibianhao = kaoshibianhao;
	}
	/**
	 * 获取：考试编号
	 */
	public String getKaoshibianhao() {
		return kaoshibianhao;
	}
	/**
	 * 设置：科目名称
	 */
	public void setKemumingcheng(String kemumingcheng) {
		this.kemumingcheng = kemumingcheng;
	}
	/**
	 * 获取：科目名称
	 */
	public String getKemumingcheng() {
		return kemumingcheng;
	}
	/**
	 * 设置：考试地点
	 */
	public void setKaoshididian(String kaoshididian) {
		this.kaoshididian = kaoshididian;
	}
	/**
	 * 获取：考试地点
	 */
	public String getKaoshididian() {
		return kaoshididian;
	}
	/**
	 * 设置：考试日期
	 */
	public void setKaoshiriqi(Date kaoshiriqi) {
		this.kaoshiriqi = kaoshiriqi;
	}
	/**
	 * 获取：考试日期
	 */
	public Date getKaoshiriqi() {
		return kaoshiriqi;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：考试成绩
	 */
	public void setKaoshichengji(String kaoshichengji) {
		this.kaoshichengji = kaoshichengji;
	}
	/**
	 * 获取：考试成绩
	 */
	public String getKaoshichengji() {
		return kaoshichengji;
	}
	/**
	 * 设置：试卷
	 */
	public void setShijuan(String shijuan) {
		this.shijuan = shijuan;
	}
	/**
	 * 获取：试卷
	 */
	public String getShijuan() {
		return shijuan;
	}
	/**
	 * 设置：教师账号
	 */
	public void setJiaoshizhanghao(String jiaoshizhanghao) {
		this.jiaoshizhanghao = jiaoshizhanghao;
	}
	/**
	 * 获取：教师账号
	 */
	public String getJiaoshizhanghao() {
		return jiaoshizhanghao;
	}

}
