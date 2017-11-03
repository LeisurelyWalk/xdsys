package com.xd.sys.service;

import java.util.List;

import com.xd.sys.po.User;

public interface UsersService {
	

	public User findUserByNumid(String numid) throws Exception;
	
	public void updateCourseByNumid(User user) throws Exception;
	

}
