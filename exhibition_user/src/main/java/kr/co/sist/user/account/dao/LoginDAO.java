package kr.co.sist.user.account.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Repository
public class LoginDAO {
public MemberVO Login(MemberVO mVO) {
	SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
	
	System.out.println("----MyBatis 占싸깍옙占쏙옙 占쏙옙占�-----");
	return ss.selectOne("kr.co.sist.user.login",mVO);
	
	
}
}
