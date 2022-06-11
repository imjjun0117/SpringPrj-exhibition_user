package kr.co.sist.user.myInfo.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.dao.IdPassFindDAO;
import kr.co.sist.user.myInfo.dao.MyInfoDAO;
import kr.co.sist.user.myInfo.vo.MyReservationDomain;

@Service
public class MyInfoServiceImpl {
	
	@Autowired(required = false)
	MyInfoDAO myInfoDAO;
	
	public int pwCheck(MemberVO mVO){
		int cnt = 0;
		try {
			 cnt= myInfoDAO.pwCheck(mVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return cnt;
	}
	public List<MyReservationDomain> searchMyReservation(String userid){
		List<MyReservationDomain> list = null;
		try {
			list = myInfoDAO.selectMyReservation(userid);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		return list;
	}//searchMyReservation
	
	public MyReservationDomain searchMyRezDetail(int rez_num) {
		MyReservationDomain md = null;
		try {
			md=myInfoDAO.selectMyRezDetail(rez_num);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		return md;
	}//searchMyRezDetail
	
	public String cancelRez(int rez_num) {
		int cnt=0;
		JSONObject jsonObj = new JSONObject();
		try {
			cnt=myInfoDAO.updateMyRezDetail(rez_num);
			jsonObj.put("cnt",cnt);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		return jsonObj.toJSONString();
	}//calcelRez
		
	public List<MemberVO> searchMember(String userId){
		List<MemberVO> list=null;
		try {
			list = myInfoDAO.memberList(userId);
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int updateMember(MemberVO mvo) {
		int cnt=0;
		try {
			cnt= myInfoDAO.updateMember(mvo);
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
}
