package kr.co.sist.user.account.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Repository
public class LoginDAO {
	
public String login(String userId) throws PersistenceException{
	SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
	String password = ss.selectOne("kr.co.sist.user.login",userId);
	if(ss != null) {ss.close();}//end if
    return password;
	}
}
