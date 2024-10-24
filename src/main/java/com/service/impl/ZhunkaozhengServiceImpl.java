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


import com.dao.ZhunkaozhengDao;
import com.entity.ZhunkaozhengEntity;
import com.service.ZhunkaozhengService;
import com.entity.vo.ZhunkaozhengVO;
import com.entity.view.ZhunkaozhengView;

@Service("zhunkaozhengService")
public class ZhunkaozhengServiceImpl extends ServiceImpl<ZhunkaozhengDao, ZhunkaozhengEntity> implements ZhunkaozhengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhunkaozhengEntity> page = this.selectPage(
                new Query<ZhunkaozhengEntity>(params).getPage(),
                new EntityWrapper<ZhunkaozhengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhunkaozhengEntity> wrapper) {
		  Page<ZhunkaozhengView> page =new Query<ZhunkaozhengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhunkaozhengVO> selectListVO(Wrapper<ZhunkaozhengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhunkaozhengVO selectVO(Wrapper<ZhunkaozhengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhunkaozhengView> selectListView(Wrapper<ZhunkaozhengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhunkaozhengView selectView(Wrapper<ZhunkaozhengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
