package kr.co.sist.user.myInfo.service;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.user.account.vo.MemberVO;

public interface MyInfoSerivce {
	public String pwCheck(String userId)throws PersistenceException;
}
