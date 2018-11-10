package com.imooc.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imooc.pojo.Bgm;
import com.imooc.pojo.Users;
import com.imooc.pojo.UsersReport;
import com.imooc.pojo.Videos;
import com.imooc.utils.PagedResult;

public interface VideoService {
	
	/**
	 * @Description: 保存视频
	 */
	public String saveVideo(Videos video);
	
	/**
	 * @Description: 修改视频的封面
	 */
	public void updateVideo(String videoId, String coverpath);
	
	/**
	 * @Description: 分页查询视频列表
	 */
	public PagedResult getAllVideos(Integer page, Integer pageSize);

}
