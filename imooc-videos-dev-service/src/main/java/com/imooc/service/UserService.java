package com.imooc.service;
import org.springframework.stereotype.Service;

import com.imooc.pojo.Users;
import com.imooc.pojo.UsersReport;

public interface UserService {
	
	/**
	 * @Description: 判断用户名是否存在
	 */
	public boolean queryUsernameIsExist(String username);
	/**
	 * @Description: 保存用户(用户注册)
	 */
	public void saveUser(Users user);
	/**
	 * @Description: 用户登录，根据用户名和密码查询用户
	 */
	public Users queryUserForLogin(String username, String password);
	/**
	 * @Description: 用户修改信息
	 */
	public void updateUserInfo(Users user);
	/**
	 * @Description: 查询用户信息
	 */
	public Users queryUserInfo(String userId);
	

}
