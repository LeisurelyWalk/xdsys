package com.xd.sys.service;

import java.util.List;

import com.xd.sys.po.Courses;

public interface CoursesService {
	
	public List<Courses> selectByCourse(String name) throws Exception;
	
	public Courses selectById(Integer id) throws Exception;
	
	public List<Courses> getAllCourses() throws Exception;
	
	public int insert(Courses record) throws Exception;

}
