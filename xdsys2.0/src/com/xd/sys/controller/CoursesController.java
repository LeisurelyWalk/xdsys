package com.xd.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.xd.sys.mapper.CoursesMapper;
import com.xd.sys.po.Courses;
import com.xd.sys.po.User;
import com.xd.sys.service.CoursesService;
import com.xd.sys.service.UsersService;

@Controller

@RequestMapping("/course")
public class CoursesController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private CoursesService coursesService;
	
	
	@RequestMapping(value="/submitCourses",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String submitCourses(HttpServletRequest request,Model model, HttpSession session,@RequestParam(value="arrId",required=false) JSONArray arrId )throws Exception {
		
		List<Object> listId=arrId.toList();
		
		return "success";
	}
	
	@RequestMapping(value="/allCourses",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String allCourses(HttpServletRequest request,Model model, HttpSession session )throws Exception {
		
//		List<Object> listId=arrId.toList();
		String numid=(String) session.getAttribute("numid");
		User tpUser=usersService.findUserByNumid(numid);
		List<Courses> listCourses=coursesService.getAllCourses();
		model.addAttribute("user", tpUser);
		model.addAttribute("arrCourses", listCourses);
		return "student/allcourse";
	}
	
	
}
