package kr.co.sist.user.account.controller;

import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.user.account.service.UserJoinService;
import kr.co.sist.user.account.vo.MemberVO;
@Controller
public class UserJoinController {
	private static final Logger Logger = LoggerFactory.getLogger(UserJoinController.class);
	
	@Autowired(required = false)
	private UserJoinService ujService;
	

	@RequestMapping(value="/user/login/terms.do",method=RequestMethod.GET)
	public void JoinRequire() {
		
	}
	//회원가입들어갈때
	@RequestMapping(value ="/user/login/register.do",method =RequestMethod.GET)
	public void getJoin()throws Exception{
		Logger.info("get Join");
	}
	//회원가입할때
	@RequestMapping(value ="/user/login/register.do",method = RequestMethod.POST)
	public String postJoin(MemberVO mVO)throws PersistenceException{
		
		ujService.joinUser(mVO);
		
		return "user/login/registerSucess";
		
		
	}
	
	
	
}
