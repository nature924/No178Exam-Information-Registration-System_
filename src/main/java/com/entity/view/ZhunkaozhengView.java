package com.entity.view;

import com.entity.ZhunkaozhengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 准考证
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
@TableName("zhunkaozheng")
public class ZhunkaozhengView  extends ZhunkaozhengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhunkaozhengView(){
	}
 
 	public ZhunkaozhengView(ZhunkaozhengEntity zhunkaozhengEntity){
 	try {
			BeanUtils.copyProperties(this, zhunkaozhengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
