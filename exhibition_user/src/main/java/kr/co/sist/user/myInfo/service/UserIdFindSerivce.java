package kr.co.sist.user.myInfo.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.dao.IdPassFindDAO;
@Service("idPassFindService")
public class UserIdFindSerivce{
	
	@Autowired(required = false)
	IdPassFindDAO idFindDAO;
	
	public MemberVO findId(MemberVO mVO) {
		return idFindDAO.findId(mVO);
		
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
			cnt = idFindDAO.updatePassword(mVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		return cnt;
	}
	
}
