package kr.co.sist.user.reservation.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.user.exhibition.vo.UserExhibitionHallVO;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;
import kr.co.sist.user.mybatis.MyBatisFramework;
import kr.co.sist.user.reservation.vo.ReservationDomain;
import kr.co.sist.user.reservation.vo.UserReservationVO;

@Component
public class UserReservationDAO {
	
	
	//전시 리스트 조회
	public List<ReservationDomain> exInfo(int ex_num) throws PersistenceException{
		List<ReservationDomain> list = null;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.reservation.UserReservationMapper.exInfo", ex_num);

		if(ss != null) {
			ss.close();
		}//end if
		
		return list;
	}
	//위치 정보
	public List<UserExhibitionVO> selectExName() throws PersistenceException{
		List<UserExhibitionVO> list = null;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		list=ss.selectList("kr.co.sist.user.reservation.UserReservationMapper.selectExName");
		
		if(ss != null) {
			ss.close();
		}//end if
		
		return list;
	}
	
	public int insertRez(UserReservationVO rvo) throws PersistenceException{
		int cnt=0;
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		cnt = ss.insert("kr.co.sist.user.reservation.UserReservationMapper.insertRez", rvo);
		
		ss.commit();
		if(ss!=null) {
			ss.close();
		}
		
		return cnt;
	}	

}//class
