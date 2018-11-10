package com.imooc.service.impl;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mapper.BgmMapper;
import com.imooc.mapper.UsersMapper;
import com.imooc.mapper.VideosMapper;
import com.imooc.mapper.VideosMapperCustom;
import com.imooc.pojo.Bgm;
import com.imooc.pojo.Users;
import com.imooc.pojo.Videos;
import com.imooc.pojo.vo.VideosVO;
import com.imooc.service.BgmService;
import com.imooc.service.UserService;
import com.imooc.service.VideoService;
import com.imooc.utils.PagedResult;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	private VideosMapper videosMapper;
	
	@Autowired
	private VideosMapperCustom videosMapperCustom;
	
	@Autowired
	private Sid sid;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public String saveVideo(Videos video) {
		
		String id = sid.nextShort();
		video.setId(id);
		videosMapper.insertSelective(video);
		return id;
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateVideo(String videoId, String coverPath) {
		
		Videos video= new Videos();
		video.setId(videoId);
		video.setCoverPath(coverPath);
		videosMapper.updateByPrimaryKeySelective(video);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PagedResult getAllVideos(Integer page, Integer pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<VideosVO> list = videosMapperCustom.queryAllVideos();
		
		PageInfo<VideosVO> pageList = new PageInfo<>(list);
		
		PagedResult pagedResult = new PagedResult();
		pagedResult.setPage(page);
		pagedResult.setTotal(pageList.getPages());
		pagedResult.setRows(list);
		pagedResult.setRecords(pageList.getTotal());
		
		return pagedResult;
		
	}
	
}
