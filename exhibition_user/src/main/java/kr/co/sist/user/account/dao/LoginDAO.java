package kr.co.sist.user.account.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Repository
public class LoginDAO {
	
public int Login(MemberVO mVO) throws PersistenceException{
	SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
	int cnt = ss.selectOne("kr.co.sist.user.login",mVO);
	if(ss != null) {ss.close();}//end if
    return cnt;
	}
}
