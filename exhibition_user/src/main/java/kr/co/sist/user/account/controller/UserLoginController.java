package kr.co.sist.user.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.account.service.UserLoginService;
import kr.co.sist.user.account.service.UserLoginServiceImpl;
import kr.co.sist.user.account.vo.MemberVO;


@Controller
@SessionAttributes("loginUser")
public class UserLoginController {
	/*
	 * @Autowired(required = false) private UserLoginService userLoginService;
	 */	
	@Autowired(required = false)
	private UserLoginServiceImpl userLoginService;
	
	
	
	@RequestMapping(value="/user/login/login.do", method= {RequestMethod.POST,RequestMethod.GET} )
	public String loginAction( MemberVO mVO,Model model) {
		MemberVO loginUser=userLoginService.Login(mVO);
		
		if(loginUser==null) {
		model.addAttribute("check",1);
		model.addAttribute("message","아이디비밀번호가일치하지않습니다!");
		System.out.println("----------------�떎�뙣-----------------"+loginUser);
		return "user/login/login";
		}else {
			model.addAttribute("loginUser",loginUser.getUserId());
			System.out.println("------------------�꽦怨�----------------"+loginUser);
			return "redirect:/user/index.do";
		}
	}
	
	
	
}
