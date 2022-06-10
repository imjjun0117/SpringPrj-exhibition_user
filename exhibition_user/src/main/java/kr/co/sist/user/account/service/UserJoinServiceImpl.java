package kr.co.sist.user.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.dao.UserJoinDAO;
import kr.co.sist.user.account.vo.MemberVO;

@Service("userJoinService")
public class UserJoinServiceImpl implements UserJoinService {

	@Autowired(required = false)
	private UserJoinDAO ujDAO;
	
	@Override
	public void joinUser(MemberVO mVO) {
		
		ujDAO.joinUser(mVO);
	}
	//@Override
//	public String idCheck(String userId) {
//		System.out.println(userId);
//		String id=ujDAO.idCheck(userId);
//		System.out.println("service id"+id);
//		return id;
//	}
	
}
