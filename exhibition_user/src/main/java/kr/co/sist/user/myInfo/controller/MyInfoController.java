package kr.co.sist.user.myInfo.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.service.MyInfoSerivce;
import kr.co.sist.user.myInfo.service.MyInfoServiceImpl;

@Controller
@SessionAttributes("loginUser")
public class MyInfoController {
	
	@Autowired(required = false)
	private MyInfoServiceImpl serviceImp;
	
	//내정보로 들어가는 get
	@RequestMapping(value="/user/myaccount/my_account_pass.do",method = RequestMethod.GET)
	public void startMyinfo() {
		
	}
	//내정보 비밀번호 체크
		@RequestMapping(value="/user/myaccount/my_account_pass.do",method = RequestMethod.POST)
		public String passChk(MemberVO mVO,Model model,HttpSession session) {
			String loginUser=(String)session.getAttribute("loginUser");
			 System.out.println("-------세션값-------"+loginUser);
				
			String password=serviceImp.pwCheck(loginUser);
			System.out.println("------------controller password---"+password);
			String getPass=mVO.getPassword();
			System.out.println("---------입력값------"+getPass);
			if(password.equals(getPass)) {
				model.addAttribute("loginUser",loginUser);
				return "redirect:/user/myaccount/my-account_rez.do";
			}else {
				model.addAttribute("check",1);
				model.addAttribute("message","비밀번호를확인해주세요");
				return "user/myaccount/my-account_pass";
			}
			
		}
	//내정보 메인화면
	@RequestMapping(value="/user/myaccount/my-account_rez.do",method=RequestMethod.GET)
	public void myInfoMain() {
		
	}
}
