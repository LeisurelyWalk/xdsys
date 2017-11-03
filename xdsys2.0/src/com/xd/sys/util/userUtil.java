package com.xd.sys.util;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xd.sys.service.CoursesService;
import com.xd.sys.service.UsersService;
import com.xd.sys.po.Courses;


public class userUtil {
	
	@Autowired
	private CoursesService coursesService;
	
	
	public Map<String, String> getStudentsAndGoals(String stu) {
		Map<String, String> res=new HashMap<String,String>();
		String[] students=stu.split(";");
		for (String string : students) {
			String[] temp=string.split(":");
			res.put(temp[0], temp[1]);
		}
		return res;
		 
	}

}
