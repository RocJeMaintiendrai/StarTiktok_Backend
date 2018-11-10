package com.imooc.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imooc.pojo.Bgm;
import com.imooc.pojo.Users;
import com.imooc.pojo.UsersReport;

public interface BgmService {
	
	/**
	 * @Description: 查询背景音乐列表
	 */
	public List<Bgm> queryBgmList();
	/**
	 * @Description: 查询背景音乐列表
	 */
	public Bgm queryBgmById(String bgmId);

}
