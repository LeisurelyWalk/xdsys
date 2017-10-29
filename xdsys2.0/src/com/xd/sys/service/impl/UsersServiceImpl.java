package com.xd.sys.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xd.sys.po.User;
import com.xd.sys.service.UsersService;
import com.xd.sys.mapper.*;
import com.xd.sys.po.*;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByNumid(String id) throws Exception {
	User user=userMapper.findUserByNumid(id);
	return user;
	}

}
