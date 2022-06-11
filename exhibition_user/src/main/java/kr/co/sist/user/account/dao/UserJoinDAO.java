package kr.co.sist.user.account.dao;


import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;
@Repository
public class UserJoinDAO {
	//ȸ������
	public int joinUser(MemberVO mVO) throws PersistenceException{
		int cnt=0;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		cnt =ss.insert("kr.co.sist.user.memberInsert",mVO);
		System.out.println("dao: "+cnt);
		ss.commit();
		if(ss!=null) {ss.close();}
		return cnt;
	}
	
	public int idCheck(String userId) throws PersistenceException{
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		int check=ss.selectOne("kr.co.sist.user.idCheck",userId);
		System.out.println("idCheck dao : "+userId);
		if(ss!=null) {ss.close();}
		return check;
	}
}