package com.dao;

import com.entity.KaoshibaomingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaoshibaomingVO;
import com.entity.view.KaoshibaomingView;


/**
 * 考试报名
 * 
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
public interface KaoshibaomingDao extends BaseMapper<KaoshibaomingEntity> {
	
	List<KaoshibaomingVO> selectListVO(@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);
	
	KaoshibaomingVO selectVO(@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);
	
	List<KaoshibaomingView> selectListView(@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);

	List<KaoshibaomingView> selectListView(Pagination page,@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);
	
	KaoshibaomingView selectView(@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);
	

}
