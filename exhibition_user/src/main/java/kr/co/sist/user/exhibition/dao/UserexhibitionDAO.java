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
	public List<UserExhibitionVO> exListAllView()throws PersistenceException{
		List<UserExhibitionVO> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.dao.userexlist.selectAllExList");
		
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
}
