package kr.co.sist.user.exhibition.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.exhibition.vo.UserExhibitionHallVO;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Component
public class UserexhibitionDAO {

	public List<UserExhibitionVO> selectAllExList(UserExhibitionVO ueVO)throws PersistenceException{
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectAllExList",ueVO);
		
		if(ss!=null ) {ss.close();}
		return list;
	}
	
	public List<UserExhibitionHallVO> selectLocalExList()throws PersistenceException{
		List<UserExhibitionHallVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectLocalExList");
		
		if(ss!=null ) {ss.close();}
		return list;
	}
	public int selectTotalCount( int ex_hall_num ) {
		int totalCnt=0;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		totalCnt=ss.selectOne("kr.co.sist.user.dao.userexlist.selectEx", ex_hall_num);
		if( ss !=null ) { ss.close(); }
		return totalCnt;
	}//selectTotalCount
	
}
