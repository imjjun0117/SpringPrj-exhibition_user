package kr.co.sist.user.myInfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.service.MyInfoServiceImpl;

@Controller
@SessionAttributes("loginUser")
public class MyInfoController {
	
	@Autowired(required = false)
	private MyInfoServiceImpl serviceImpl;
	
	
	//내정보로 들어가는 get
	@RequestMapping(value="/my_account_pass.do",method = RequestMethod.GET)
	public String startMyinfo(HttpSession session) {
		//System.out.println(session.getAttribute("id"));
		if(session.getAttribute("id")==null) {
			return"redirect:login.do";
		}else {
			return "user/myaccount/my_account_pass";
		}//end else
	}//startMyInfo
	//내정보 비밀번호 체크
		@RequestMapping(value="/checkMyPass.do",method = RequestMethod.POST)
		public String passChk(MemberVO mVO,Model model,HttpSession session) {
			mVO.setUserId((String)session.getAttribute("id"));
			int cnt = serviceImpl.pwCheck(mVO);
			//System.out.println(cnt+" /  -------------------------"+mVO+"/");
			if(cnt == 1) {
				return "user/myaccount/my-account_rez";
			}else {
				model.addAttribute("check",1);
				model.addAttribute("message","비밀번호를확인해주세요");
				return "redirect:/user/myaccount/my-account_pass";
			}//end else
			
		}
//	//내정보 메인화면
//	@RequestMapping(value="/user/myaccount/my-account_rez.do",method=RequestMethod.GET)
//	public void myInfoMain() {
//		
//	}
}//class
