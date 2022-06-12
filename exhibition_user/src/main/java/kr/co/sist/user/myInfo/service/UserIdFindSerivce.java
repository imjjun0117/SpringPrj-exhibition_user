package kr.co.sist.user.myInfo.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.dao.IdPassFindDAO;
@Service("idPassFindService")
public class UserIdFindSerivce{
	
	@Autowired(required = false)
	private IdPassFindDAO idFindDAO;
	
	BCryptPasswordEncoder encoder;
	
	public String findId(MemberVO mVO) {
		String userId = "";
		try {
			userId = idFindDAO.findId(mVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return userId;
	}
	public int findPassword(MemberVO mVO) {
		int cnt=0;
		try {
		cnt= idFindDAO.findPassword(mVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}
	public int updatePassword(MemberVO mVO) {
		int cnt=0;
		try{
			encoder = new BCryptPasswordEncoder();
			mVO.setPassword(encoder.encode(mVO.getPassword()));
			cnt = idFindDAO.updatePassword(mVO);
			System.out.println(cnt);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}
	
}
