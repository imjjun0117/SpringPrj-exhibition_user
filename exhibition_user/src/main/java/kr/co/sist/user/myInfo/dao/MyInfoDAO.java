package kr.co.sist.user.myInfo.dao;


import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Component
public class MyInfoDAO {
	//������ȭ�鿡�� ��й�ȣȮ��
	public int pwCheck(MemberVO mVO)throws PersistenceException{
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		int cnt= ss.selectOne("kr.co.sist.user.checkPass",mVO);
		
		if(ss!= null) {ss.close();}//end if
		
		return cnt;
	}
}
