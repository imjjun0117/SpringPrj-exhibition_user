package kr.co.sist.user.account.controller;

import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.user.account.service.UserJoinService;
import kr.co.sist.user.account.vo.MemberVO;
@Controller
public class UserJoinController {
	private static final Logger Logger = LoggerFactory.getLogger(UserJoinController.class);
	
	@Autowired(required = false)
	UserJoinService ujService;
	
	//아이디체크
	@RequestMapping(value="/user/login/idcheck.do")
	public String idCheck(@RequestParam(value="userId",defaultValue = " ",required = false)String userId,Model model) {
		model.addAttribute("userId",userId);
		System.out.println("uerId" +userId);
		return "user/login/idcheck";
	}
	
	//약관동의
	@RequestMapping(value="/user/login/terms.do",method=RequestMethod.GET)
	public void JoinRequire() {
		
	}
	//회원가입 get
	@RequestMapping(value ="/user/login/register.do",method =RequestMethod.GET)
	public void getJoin()throws Exception{
		Logger.info("get Join");
	}
	//회원가입 Post
	@RequestMapping(value ="/user/login/register.do",method = RequestMethod.POST)
	public String postJoin(MemberVO mVO)throws PersistenceException{
		
		ujService.joinUser(mVO);
		
		return "user/login/registerSucess";
		
		
	}
	
	
	
}
