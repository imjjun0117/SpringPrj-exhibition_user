package kr.co.sist.user.account.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.dao.LoginDAO;
import kr.co.sist.user.account.vo.MemberVO;

@Service("userLoginService")
public class UserLoginService{
	@Autowired(required = false)
	private LoginDAO loginDAO;
	BCryptPasswordEncoder encoder;
	
	public int login(MemberVO mvo) {
		int cnt=0;
		String password="";
		try {
			encoder = new BCryptPasswordEncoder();
			password = loginDAO.login(mvo.getUserId());
			if(encoder.matches(mvo.getPassword(), password)) cnt =1;
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}
		
	
}
