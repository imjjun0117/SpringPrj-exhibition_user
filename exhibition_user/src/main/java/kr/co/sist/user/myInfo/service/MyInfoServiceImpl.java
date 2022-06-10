package kr.co.sist.user.myInfo.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.dao.IdPassFindDAO;
import kr.co.sist.user.myInfo.dao.MyInfoDAO;

@Service
public class MyInfoServiceImpl {
	
	@Autowired(required = false)
	MyInfoDAO myInfoDAO;
	
	public int pwCheck(MemberVO mVO){
		int cnt = 0;
		try {
			 cnt= myInfoDAO.pwCheck(mVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return cnt;
	}
	
	
		
}
