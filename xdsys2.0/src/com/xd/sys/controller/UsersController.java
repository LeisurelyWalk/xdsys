package com.xd.sys.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.xd.sys.po.User;
import com.xd.sys.service.UsersService;


@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public String editItems(Model model)throws Exception {
		
		//调用service根据商品id查询商品信息
		
		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
	
		return "login";


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
	@ResponseBody
	//@RequestParam里边指定request传入参数名称和形参进行绑定。
	//通过required属性指定参数是否必须要传入
	//通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public Map<String, Object> submit(HttpServletRequest request,Model model,@RequestParam(value="numid",required=false) String numid,@RequestParam(value="password",required=false) String password)throws Exception {
		
		//调用service根据商品id查询商品信息

		//通过形参中的model将model数据传到页面
		//相当于modelAndView.addObject方法
		User user=usersService.findUserByNumid(numid);
		Map<String, Object>result= new HashMap<String,Object>();

		
		if(user!=null) {
			String myPassword=user.getPassword();
			
			if(myPassword==null) {
				result.put("msg", "success");
			}
			else if(myPassword.equals(password)){
				result.put("msg", "success");
			}
			else {
				result.put("msg", "failure");
			}
			
		}
		else {
			result.put("msg", "noNumid");
		}
		String string=(String) result.get("msg");
		return result;
	}
}
