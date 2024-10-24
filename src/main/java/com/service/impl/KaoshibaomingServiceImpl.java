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


import com.dao.KaoshibaomingDao;
import com.entity.KaoshibaomingEntity;
import com.service.KaoshibaomingService;
import com.entity.vo.KaoshibaomingVO;
import com.entity.view.KaoshibaomingView;

@Service("kaoshibaomingService")
public class KaoshibaomingServiceImpl extends ServiceImpl<KaoshibaomingDao, KaoshibaomingEntity> implements KaoshibaomingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshibaomingEntity> page = this.selectPage(
                new Query<KaoshibaomingEntity>(params).getPage(),
                new EntityWrapper<KaoshibaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshibaomingEntity> wrapper) {
		  Page<KaoshibaomingView> page =new Query<KaoshibaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshibaomingVO> selectListVO(Wrapper<KaoshibaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshibaomingVO selectVO(Wrapper<KaoshibaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshibaomingView> selectListView(Wrapper<KaoshibaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshibaomingView selectView(Wrapper<KaoshibaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
