package kr.co.sist.user.reservation.service;
//package kr.co.sist.user.service;
//
//import java.util.List;
//
//import org.apache.ibatis.exceptions.PersistenceException;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import kr.co.sist.user.dao.MyReservationDAO;
//import kr.co.sist.user.vo.MyReservationVO;
//
//public class MyRezService {
//	
//	@Autowired(required = false)
//	private MyReservationDAO mrDAO;
//	
//
//	/**
//	 * �궡 �삁�빟 由ъ뒪�듃 異쒕젰
//	 * @param userid
//	 * @return
//	 */
//	public List<MyReservationVO> searchRez(String userid){
//		List<MyReservationVO> list=null;
//		
//		try {
//			list=mrDAO.selectAllRez(userid);
//		}catch(PersistenceException pe) {
//			pe.printStackTrace();
//		}//end catch
//		
//		return list;
//	}//allBoard
//	
//	/**
//	 * �삁�빟 �긽�꽭 蹂댁뿬二쇨린
//	 * @param mrVO
//	 * @return
//	 */
//	public MyReservationVO searchRezDetail(MyReservationVO mrVO){
//		
//		try {
//			mrVO=mrDAO.selectRezDtail(mrVO);
//		}catch(PersistenceException pe) {
//			pe.printStackTrace();
//		}//end catch
//		
//		return mrVO;
//	}//searchRezDetail
//	
//	/**
//	 * �삁�빟 痍⑥냼
//	 * @param mrVO
//	 * @return
//	 */
//	public int rezCancle(MyReservationVO mrVO){
//		int success=0;
//		
//		try {
//			success=mrDAO.updateRez(mrVO);
//		}catch(PersistenceException pe) {
//			pe.printStackTrace();
//		}//end catch
//		
//		return success;
//	}//rezCancle
//}//class
