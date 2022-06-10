package kr.co.sist.user.home.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.exhibition.vo.UserExhibitionHallVO;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;
import kr.co.sist.user.home.dao.UserMainDAO;

@Component
public class UserMainService {

	@Autowired(required = false)
	private UserMainDAO umDAO;
	
	public List<UserExhibitionVO> mainExView() {
		List<UserExhibitionVO> list=null;
		
		try {
			list=umDAO.selectExRepresent();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	public List<UserExhibitionHallVO> locView(){
		List<UserExhibitionHallVO> list=null;
		
		try {
			list=umDAO.selectExLocAll();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	public List<UserExhibitionVO> listView(){
		List<UserExhibitionVO> list=null;
		
		try {
			list=umDAO.viewExList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	
	public List<UserExhibitionVO> exGraph(){
		List<UserExhibitionVO> list=null;
		
		try {
			list=umDAO.viewGraph();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
	public List<UserExhibitionVO> sumGraph(){
		List<UserExhibitionVO> list=null;
		
		try {
			list=umDAO.sumGraph();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}
}
