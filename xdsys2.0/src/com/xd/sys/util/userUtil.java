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
	
	
	public Map<String, String> getStudentsAndGoals(String stu) {
		Map<String, String> res=new HashMap<String,String>();
		String[] students=stu.split(";");
		for (String string : students) {
			String[] temp=string.split(":");
			res.put(temp[0], temp[1]);
		}
		return res;
		 
	}
	
	public String toStringStudentsAndGoals(Map<String, String> stu) {
		String res="";
		for(String str:stu.keySet()) {
		    String value = stu.get(str);
		    res+=str;
		    res+=":"+value+";";
		}
		if(res.length()<1) {
			return res;
		}
		res=res.substring(0, res.length()-1);
		return res;
		 
	}

}
