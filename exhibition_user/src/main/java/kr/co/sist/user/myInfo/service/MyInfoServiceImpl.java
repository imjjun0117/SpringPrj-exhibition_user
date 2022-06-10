package kr.co.sist.user.myInfo.service;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.dao.IdPassFindDAO;
import kr.co.sist.user.myInfo.dao.MyInfoDAO;

@Service
public class MyInfoServiceImpl implements MyInfoSerivce {
	
	@Autowired(required = false)
	MyInfoDAO myInfoDAO;
	
	@Override
	public String pwCheck(String userId)throws PersistenceException{
		String password= myInfoDAO.pwCheck(userId);
		System.out.println("¼­ºñ½º: "+password);
		return password;
	}
	
	
		
}
