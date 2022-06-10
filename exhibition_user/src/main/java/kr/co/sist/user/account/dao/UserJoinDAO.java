package kr.co.sist.user.account.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;
@Repository
public class UserJoinDAO {
	
	public void joinUser(MemberVO mVO) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		ss.insert("kr.co.sist.user.memberInsert",mVO);
		ss.commit();
	}
	public MemberVO idCheck(String userId) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		MemberVO member=ss.selectOne("kr.co.sist.user.idCheck",userId);
		
		return member;
	}
}
