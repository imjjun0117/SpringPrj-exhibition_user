package kr.co.sist.user.account.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.dao.UserJoinDAO;
import kr.co.sist.user.account.vo.MemberVO;

@Service("userJoinService")
public class UserJoinService {

	@Autowired(required = false)
	private UserJoinDAO ujDAO;
	
	public int joinUser(MemberVO mVO) {
		int cnt=0;
		try {
		cnt=ujDAO.joinUser(mVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}
//	public String idCheck(String userId) {
//		System.out.println(userId);
//		String id=ujDAO.idCheck(userId);
//		System.out.println("service id"+id);
//		return id;
//	}
	
}
