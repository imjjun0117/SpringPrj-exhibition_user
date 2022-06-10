package kr.co.sist.user.myInfo.service;

import kr.co.sist.user.account.vo.MemberVO;

public interface UserIdFindSerivce {
	MemberVO findId(MemberVO mVO);
	
	MemberVO findPassword(MemberVO mVO); 
	
	void updatePassword(MemberVO mVO);
}
