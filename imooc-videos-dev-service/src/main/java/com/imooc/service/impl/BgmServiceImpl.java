package com.imooc.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.mapper.BgmMapper;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.Bgm;
import com.imooc.pojo.Users;
import com.imooc.service.BgmService;
import com.imooc.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class BgmServiceImpl implements BgmService {
	
	@Autowired
	private BgmMapper bgmMapper;
	
	@Autowired
	private Sid sid;

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Bgm> queryBgmList() {
		return bgmMapper.selectAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Bgm queryBgmById(String bgmId) {
		return bgmMapper.selectByPrimaryKey(bgmId);
	}

}
