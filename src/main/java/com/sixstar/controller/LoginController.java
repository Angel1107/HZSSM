package com.sixstar.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sixstar.entity.User;
import com.sixstar.service.UserService;

/**
 * 
* @ClassName: LoginController 
* @Description: 处理登录功能的控制器
* @author Sixstar-Jame 
* @date 2017年3月9日 下午9:15:18 
*
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public String index(){
		System.out.println("进入了控制器的后台");
		return "/index";
	}
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(HttpServletRequest request){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User();
		user.setPassword(password);
		user.setUserName(userName);
		boolean result = userService.login(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName",userName);		
		 if(result){
			 mv.setViewName("/success");
		 }else{
			 mv.setViewName("/fail");
		 }
		 return mv;
	}
}
