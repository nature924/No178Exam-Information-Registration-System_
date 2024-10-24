package com.dao;

import com.entity.ZhunkaozhengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhunkaozhengVO;
import com.entity.view.ZhunkaozhengView;


/**
 * 准考证
 * 
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
public interface ZhunkaozhengDao extends BaseMapper<ZhunkaozhengEntity> {
	
	List<ZhunkaozhengVO> selectListVO(@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);
	
	ZhunkaozhengVO selectVO(@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);
	
	List<ZhunkaozhengView> selectListView(@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);

	List<ZhunkaozhengView> selectListView(Pagination page,@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);
	
	ZhunkaozhengView selectView(@Param("ew") Wrapper<ZhunkaozhengEntity> wrapper);
	

}
