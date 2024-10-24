package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhunkaozhengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhunkaozhengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhunkaozhengView;


/**
 * 准考证
 *
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
public interface ZhunkaozhengService extends IService<ZhunkaozhengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhunkaozhengVO> selectListVO(Wrapper<ZhunkaozhengEntity> wrapper);
   	
   	ZhunkaozhengVO selectVO(@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);
   	
   	List<ZhunkaozhengView> selectListView(Wrapper<ZhunkaozhengEntity> wrapper);
   	
   	ZhunkaozhengView selectView(@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhunkaozhengEntity> wrapper);
   	

}

