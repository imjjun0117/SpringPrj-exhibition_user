package kr.co.sist.user.exhibition.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.exhibition.dao.UserExhibitionDetailDAO;
import kr.co.sist.user.exhibition.vo.UserExhibitionHallVO;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;

@Component
public class UserExhibitionDetailService {

		@Autowired(required = false)
		private UserExhibitionDetailDAO uedDAO;
		
		public List<UserExhibitionVO> exhibitionView(int ex_num) {
			List<UserExhibitionVO> list=null;
			
			try {
				list=uedDAO.selectExhibition(ex_num);
				
			} catch (PersistenceException pe) {
				pe.printStackTrace();
			}
			return list;
		}
//		public List<UserBoardVO> relBoard(int cat_num) {
//			List<UserBoardVO> list=null;
//			
//			try {
//				list=uedDAO.selectRelBoard(cat_num);
//			} catch (PersistenceException pe) {
//				pe.printStackTrace();
//			}
//			return list;
//		}
		
		public List<UserExhibitionHallVO> mapView(int ex_hall_num) {
			List<UserExhibitionHallVO> list=null;
			
			try {
				list=uedDAO.mapSelect(ex_hall_num);
			} catch (PersistenceException pe) {
				pe.printStackTrace();
			}
			return list;
		}
}
