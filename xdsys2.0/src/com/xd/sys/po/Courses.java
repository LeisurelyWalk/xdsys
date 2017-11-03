package com.xd.sys.po;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

public class Courses {
    private Integer id;

    private String coursename;

    private Integer credit;

    private String teacher;

    private String address;

    private String students;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students == null ? null : students.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
    
    public Map<String, String> getStudentNameAndGoals(String students) {
        Map<String, String> res=new HashMap<String,String>();
        String [] stus=students.split(";");
        for (String string : stus) {
			String [] goal=string.split(":");
			if(goal.length<2)
				continue;
			res.put(goal[0], goal[1]);
		}
        return  res;
    }
}