package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaoshibaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaoshibaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshibaomingView;


/**
 * 考试报名
 *
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
public interface KaoshibaomingService extends IService<KaoshibaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoshibaomingVO> selectListVO(Wrapper<KaoshibaomingEntity> wrapper);
   	
   	KaoshibaomingVO selectVO(@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);
   	
   	List<KaoshibaomingView> selectListView(Wrapper<KaoshibaomingEntity> wrapper);
   	
   	KaoshibaomingView selectView(@Param("ew") Wrapper<KaoshibaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoshibaomingEntity> wrapper);
   	

}

