package kr.co.sist.user.account.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Repository
public class LoginDAO {
public MemberVO Login(MemberVO mVO) {
	SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
	
	System.out.println("----MyBatis �α��� ���-----");
	return ss.selectOne("kr.co.sist.user.login",mVO);
	
	
}
}
