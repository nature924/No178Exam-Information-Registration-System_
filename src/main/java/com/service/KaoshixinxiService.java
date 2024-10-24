package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaoshixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaoshixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshixinxiView;


/**
 * 考试信息
 *
 * @author 
 * @email 
 * @date 2023-05-05 21:09:31
 */
public interface KaoshixinxiService extends IService<KaoshixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoshixinxiVO> selectListVO(Wrapper<KaoshixinxiEntity> wrapper);
   	
   	KaoshixinxiVO selectVO(@Param("ew") Wrapper<KaoshixinxiEntity> wrapper);
   	
   	List<KaoshixinxiView> selectListView(Wrapper<KaoshixinxiEntity> wrapper);
   	
   	KaoshixinxiView selectView(@Param("ew") Wrapper<KaoshixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoshixinxiEntity> wrapper);
   	

}

