package com.xd.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xd.sys.mapper.CoursesMapper;
import com.xd.sys.mapper.UserMapper;
import com.xd.sys.po.Courses;
import com.xd.sys.service.CoursesService;

public class CoursesServiceImpl implements CoursesService{

	@Autowired
	private CoursesMapper coursesMapper;
	
	@Override
	public List<Courses> selectByCourse(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Courses> listCourses=coursesMapper.selectByCourse(name);
		return listCourses;
	}

	@Override
	public Courses selectById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return coursesMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Courses> getAllCourses() throws Exception {
		// TODO Auto-generated method stub
		return coursesMapper.getAllCourses();
	}

}
