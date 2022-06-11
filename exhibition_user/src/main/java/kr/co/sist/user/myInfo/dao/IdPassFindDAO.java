package kr.co.sist.user.myInfo.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Repository
public class IdPassFindDAO {
	
	public MemberVO findId(MemberVO mVO) {
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		return ss.selectOne("kr.co.sist.user.findId",mVO);
	}
	
	public int findPassword(MemberVO mVO) throws PersistenceException {
		int cnt=0;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		cnt=ss.selectOne("kr.co.sist.user.findPassword",mVO);
		if(ss!=null) {ss.close();}
		return cnt;
	}
	public int updatePassword(MemberVO mVO) throws PersistenceException{
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		int cnt = ss.update("kr.co.sist.user.updatePassword",mVO);
		ss.commit();
		if(ss!=null) {ss.close();}		
		return cnt;
	}
}
