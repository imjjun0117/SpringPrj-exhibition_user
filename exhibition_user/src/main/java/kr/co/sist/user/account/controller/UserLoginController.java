package kr.co.sist.user.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.account.service.UserLoginService;
import kr.co.sist.user.account.vo.MemberVO;


@Controller
@SessionAttributes("loginUser")
public class UserLoginController {
	@Autowired(required = false)
	private UserLoginService userLoginService;
	
	@RequestMapping(value="/login.do", method= {RequestMethod.POST,RequestMethod.GET} )
	public String login() {
		return "user/login/login";
	}
	
	@RequestMapping(value="/loginChk.do", method=RequestMethod.POST )
	public String loginAction( MemberVO mVO,Model model, HttpSession session) {
		int loginChk=userLoginService.Login(mVO);
		
		if(loginChk==0) {
			model.addAttribute("check",1);
		return "user/login/login";
		}else {
			session.setAttribute("id", mVO.getUserId());
			return "redirect: index.do";
		}
	}
	@RequestMapping(value="/logout.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect: index.do";
	}
	
	
	
	
}
