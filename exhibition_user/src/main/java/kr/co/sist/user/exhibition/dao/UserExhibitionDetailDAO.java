package kr.co.sist.user.exhibition.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.exhibition.vo.UserExhibitionHallVO;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;
import kr.co.sist.user.mybatis.MyBatisFramework;

@Component
public class UserExhibitionDetailDAO {

		public List<UserExhibitionVO> selectExhibition(int ex_num)throws PersistenceException{
			List<UserExhibitionVO> list=null;
			
			SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
			list=ss.selectList("kr.co.sist.user.dao.exdetail.selectExhibition",ex_num);
			if(ss!=null) {ss.close();}
			
			return  list;
		}
		
//		public List<UserBoardVO> selectRelBoard(int cat_num)throws PersistenceException{
//			List<UserBoardVO> list=null;
//			
//			SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
//			list=ss.selectList("kr.co.sist.user.dao.exdetail.selectRelBoard");
//			
//			if(ss!=null) {ss.close();}
//			
//			return list;
//		}
		
		public List<UserExhibitionHallVO> mapSelect(int ex_hall_num)throws PersistenceException {
			List<UserExhibitionHallVO> list=null;
			
			SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
			list=ss.selectList("kr.co.sist.user.dao.exdetail.mapSelect",ex_hall_num);
			
			if(ss!=null) {ss.close();}
			return list;
		}
}
