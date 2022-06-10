package kr.co.sist.user.reservation.dao;
//package kr.co.sist.user.dao;
//
//import java.util.List;
//
//import org.apache.ibatis.exceptions.PersistenceException;
//import org.apache.ibatis.session.SqlSession;
//
//import kr.co.sist.user.mybatis.MyBatisFramework;
//import kr.co.sist.user.vo.MyReservationVO;
//import kr.co.sist.user.vo.UserBoardVO;
//
//public class MyReservationDAO {
//	
//	/**
//	 * �궡 �삁�빟 由ъ뒪�듃
//	 * @param ubVO
//	 * @return
//	 * @throws PersistenceException
//	 */
//	public List<MyReservationVO> selectAllRez(String userid) throws PersistenceException{
//		List<MyReservationVO> list=null;
//		
//		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
//		list=ss.selectList("kr.co.sist.user.myRez.selectRez");
//		if(ss != null) {
//			ss.close();
//		}//end if
//		
//		return list;
//	}//selectAllRez
//	
//	/**
//	 * �삁�빟 �긽�꽭
//	 * @param mrVO
//	 * @return
//	 * @throws PersistenceException
//	 */
//	public MyReservationVO selectRezDtail(MyReservationVO mrVO) throws PersistenceException{
//		
//		
//		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
//		mrVO=ss.selectOne("kr.co.sist.user.myRez.selectRezDetail");
//		if(ss != null) {
//			ss.close();
//		}//end if
//		
//		return mrVO;
//	}//selectAllRez
//	
//	/**
//	 * �삁�빟 痍⑥냼
//	 * @param mrVO
//	 * @return
//	 * @throws PersistenceException
//	 */
//	public int updateRez(MyReservationVO mrVO) throws PersistenceException{
//		int success=0;
//		
//		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
//		success=ss.selectOne("kr.co.sist.user.myRez.updateRez");
//		if(ss != null) {
//			ss.close();
//		}//end if
//		
//		return success;
//	}//updateRez
//	
//
//}//class