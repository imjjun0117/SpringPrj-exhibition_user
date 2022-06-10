package kr.co.sist.user.exhibition.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.exhibition.dao.UserexhibitionDAO;
import kr.co.sist.user.exhibition.vo.UserExhibitionHallVO;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;

@Component
public class UserExhibitionService {

	@Autowired(required = false)
	private UserexhibitionDAO ueDAO;
	
	public List<UserExhibitionVO> exListView(UserExhibitionVO ueVO) {
		List<UserExhibitionVO> list=null;
		
		try {
			list=ueDAO.selectAllExList(ueVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	public List<UserExhibitionVO> exListAllView() {
		List<UserExhibitionVO> list=null;
		try {
			list=ueDAO.exListAllView();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	public List<UserExhibitionHallVO> searchLocEx(){
		List<UserExhibitionHallVO> list=null;
		
		try {
			list=ueDAO.selectLocalExList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
}
