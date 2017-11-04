package com.xd.sys.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Enumeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.And;
import com.xd.sys.po.Courses;
import com.xd.sys.po.User;
import com.xd.sys.service.CoursesService;
import com.xd.sys.service.UsersService;
import com.xd.sys.util.userUtil;


@Controller

@RequestMapping("/users")
public class UsersController {

	private String curNumid=null;
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private CoursesService coursesService;
	
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String userLogin(HttpServletRequest request,Model model,@ModelAttribute("msg") String msg, HttpSession session,@RequestParam(value="name",required=false) String numid,@RequestParam(value="password",required=false) String password, RedirectAttributes attributes )throws Exception {
		
		//调用service根据商品id查询商品信息
		
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		if(numid==null || numid.equals("")) {
			return "login";
		}
		
		String userid=request.getParameter("name");
		User user=usersService.findUserByNumid(numid);
		session.setAttribute("numid", numid);
		session.setAttribute("password", password);
		if(user!=null) {
			String myPassword=user.getPassword();
			
			if(myPassword==null) {
				attributes.addFlashAttribute("msg", "failure");
				model.addAttribute("msg", "failure");
				return "login";
			}
			else if(myPassword.equals(password)){
				attributes.addFlashAttribute("msg", "success");
				attributes.addFlashAttribute("numid", numid);
				return "redirect:submit";

			}
			else {
				attributes.addFlashAttribute("msg", "failure");
				model.addAttribute("msg", "failure");
				return "login";
			}
			
		}
		else {
			attributes.addFlashAttribute("msg", "noNumid");
			model.addAttribute("msg", "noNumid");
			return "login";

		}
		
	}
	
	@RequestMapping(value="/student",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String displayStudent(Model model,@RequestParam(value="numid",required=false) String numid)throws Exception {
		
		//调用service根据商品id查询商品信息
		
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		User user=usersService.findUserByNumid(numid);
		model.addAttribute("user", user);
		return "student/student";
	}
	
	@RequestMapping(value="/submit",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String submit(HttpServletRequest request,Model model,@ModelAttribute("msg") String msg,HttpSession session)throws Exception {
		
		//调用service根据商品id查询商品信息

		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法

		
		String numid=(String) session.getAttribute("numid");
		User user=usersService.findUserByNumid(numid);
//
//		Enumeration<String> e = session.getAttributeNames();
//		  while (e.hasMoreElements()) {
//		   String s = e.nextElement();
//		   System.out.println(s + " == " + session.getAttribute(s));
//		  }
//		  
		model.addAttribute("user", user);
		if(msg.equals("success") || numid !=null) {
			return "student/student";
		}
		return "login";
	}
	@RequestMapping(value="/course",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String course(HttpServletRequest request,Model model,HttpSession session)throws Exception {
		
		//调用service根据商品id查询商品信息
		String numid=(String) session.getAttribute("numid");
		User tpUser=usersService.findUserByNumid(numid);
		Courses courses=new Courses();
		Map<String, String> res=courses.getStudentNameAndGoals(tpUser.getCousrse());
		List<Courses> arrCourses=new ArrayList<Courses>();
		for (String str : res.keySet()) {
			Integer temp=Integer.parseInt(str);
			Courses courtp=coursesService.selectById(temp);
			courtp.setStudents(res.get(str));
			arrCourses.add(courtp);
		}
		model.addAttribute("arrCourses", arrCourses);
		model.addAttribute("user", tpUser);
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
//		String[] strings= {"1111","1112","1113","2222","5551","5555","5556","5557","5558","5559","6666","6667","6668","6669","7777","7778","8888"};
//	for (String string : strings) {
//		User tpUser=usersService.findUserByNumid(string);
//		List<Courses> tpCourses=coursesService.selectByCourse(tpUser.getUsername());
//		
//		userUtil userutil=new userUtil();
//		Map<Integer, String>res=new HashMap<Integer,String>();
//		
//		for (Courses course : tpCourses) {
//			String students=course.getStudents();
//			int courseId=course.getId();
//			Map<String, String>teMap=userutil.getStudentsAndGoals(students);
//			res.put(courseId, teMap.get(tpUser.getUsername()));
//			
//		}
//		if(res.size()<1)
//		{
//			continue;
//		}
//		String str="";
//		
//		for (Integer key : res.keySet()) {
//
//		    String value = res.get(key);
//		    str+=key.toString();
//		    str+=":"+value+";";
//		}
//		str=str.substring(0, str.length()-1);
//		tpUser.setCousrse(str);
//		
//		usersService.updateCourseByNumid(tpUser);
//	}
//		return "success";
		return "student/course";
	}
	
}
