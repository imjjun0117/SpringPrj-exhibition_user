package kr.co.sist.user.reservation.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.exhibition.vo.UserExhibitionVO;
import kr.co.sist.user.reservation.dao.UserReservationDAO;
import kr.co.sist.user.reservation.vo.ReservationDomain;
import kr.co.sist.user.reservation.vo.UserReservationVO;

@Service
public class UserReservationService {
	@Autowired(required = false)
	private UserReservationDAO urDAO;

	
	public List<ReservationDomain> exList(int ex_num) {
		List<ReservationDomain> list = null;
		
		try {
			list=urDAO.exInfo(ex_num);
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public List<UserExhibitionVO> selectExName(){
		List<UserExhibitionVO> list = null;
		try {
			list=urDAO.selectExName();
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int makeRez(UserReservationVO rvo) {
		int cnt=0;
		try {
			cnt=urDAO.insertRez(rvo);
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}