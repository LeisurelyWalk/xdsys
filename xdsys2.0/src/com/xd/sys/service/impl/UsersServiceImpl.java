package com.xd.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xd.sys.service.CoursesService;
import com.xd.sys.service.UsersService;
import com.xd.sys.mapper.*;
import com.xd.sys.po.*;
import com.xd.sys.util.userUtil;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private CoursesMapper coursesMapper;
	
	userUtil userutil=new userUtil();

	@Override
	public User findUserByNumid(String id) throws Exception {
	User user=userMapper.findUserByNumid(id);
	return user;
	}

	@Override
	public void updateCourseByNumid(User user) throws Exception {
		userMapper.updateByPrimaryKey(user);
	}


}
