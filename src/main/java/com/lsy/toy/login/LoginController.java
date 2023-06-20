package com.lsy.toy.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsy.toy.user.dto.UserVO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception {
		System.out.println("login()");
		
		model.addAttribute("userVO", new UserVO());
		return "login/login";
	}
	
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		System.out.println("signupForm()");
		
		model.addAttribute("userVO", new UserVO());
		return "login/signupForm";
	}
}