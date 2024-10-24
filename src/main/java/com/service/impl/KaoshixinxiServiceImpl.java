package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KaoshixinxiDao;
import com.entity.KaoshixinxiEntity;
import com.service.KaoshixinxiService;
import com.entity.vo.KaoshixinxiVO;
import com.entity.view.KaoshixinxiView;

@Service("kaoshixinxiService")
public class KaoshixinxiServiceImpl extends ServiceImpl<KaoshixinxiDao, KaoshixinxiEntity> implements KaoshixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshixinxiEntity> page = this.selectPage(
                new Query<KaoshixinxiEntity>(params).getPage(),
                new EntityWrapper<KaoshixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshixinxiEntity> wrapper) {
		  Page<KaoshixinxiView> page =new Query<KaoshixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshixinxiVO> selectListVO(Wrapper<KaoshixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshixinxiVO selectVO(Wrapper<KaoshixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshixinxiView> selectListView(Wrapper<KaoshixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshixinxiView selectView(Wrapper<KaoshixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
