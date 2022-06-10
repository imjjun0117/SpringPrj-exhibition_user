package kr.co.sist.user.account.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.dao.LoginDAO;
import kr.co.sist.user.account.vo.MemberVO;

@Service("userLoginService")
public class UserLoginService{
	@Autowired(required = false)
	private LoginDAO loginDAO;
	
	public int Login(MemberVO mVO) {
		int cnt=0;
		try {
			cnt = loginDAO.Login(mVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}
		
	
}
