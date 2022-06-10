package kr.co.sist.user.myInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.dao.IdPassFindDAO;
@Service("idPassFindService")
public class UserIdFindSerivceImpl implements UserIdFindSerivce{
	
	@Autowired(required = false)
	IdPassFindDAO idFindDAO;
	
	@Override
	public MemberVO findId(MemberVO mVO) {
		return idFindDAO.findId(mVO);
	}
	@Override
	public MemberVO findPassword(MemberVO mVO) {
		return idFindDAO.findPassword(mVO);
	}
	
}
