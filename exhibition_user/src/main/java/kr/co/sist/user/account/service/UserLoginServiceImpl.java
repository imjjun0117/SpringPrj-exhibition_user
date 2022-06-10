package kr.co.sist.user.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.dao.LoginDAO;
import kr.co.sist.user.account.vo.MemberVO;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService{
	@Autowired(required = false)
	private LoginDAO loginDAO;
	
	@Override
	public MemberVO Login(MemberVO mVO) {
		
		return loginDAO.Login(mVO);
	}
		
	
}
