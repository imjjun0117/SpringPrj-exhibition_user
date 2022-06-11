package kr.co.sist.user.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.user.account.service.UserJoinService;
import kr.co.sist.user.account.vo.MemberVO;
@Controller
public class UserJoinController {
	
	@Autowired(required = false)
	UserJoinService ujService;
	
//	//아이디체크
//	 @ResponseBody
//	 @RequestMapping(value="/login/idCheck.do",method = RequestMethod.POST) public
//	 int idCheck(@RequestParam("userId")String userId){ int
//	 cnt=ujService.idCheck(userId); 
//	 System.out.println(ujService.idCheck(userId));
//	 return cnt; 
//	 }
	 
	//약관동의
	@RequestMapping(value="/terms.do",method=RequestMethod.GET)
	public String JoinRequire() {
		return "user/login/terms";
	}
	//회원가입 get
	@RequestMapping(value ="/register.do",method =RequestMethod.GET)
	public String getJoin(){
		return "user/login/register";
	}
	//회원가입 Post
	@RequestMapping(value ="/registerChk.do",method = RequestMethod.POST)
	public String postJoin(MemberVO mVO,Model model ){
		int cnt=0;
		cnt=ujService.joinUser(mVO);
		if(cnt==1) {
			return "user/login/registerSucess";
		}else {
			model.addAttribute("message",1);
			return "user/login/register";
		}
		
		
	}
	
	
	
}
