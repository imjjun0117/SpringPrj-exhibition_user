package kr.co.sist.user.board.service;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.board.dao.UserBoardDAO;
import kr.co.sist.user.board.vo.UserBoardVO;

@Component
public class UserBoardService {
	
	@Autowired(required = false)
	private UserBoardDAO ubDAO;
	
	/**
	 * 移댄뀒怨좊━�뿉 �뵲�씪 �쟾泥� 寃뚯떆湲� 由ъ뒪�듃 異쒕젰
	 * @param ubVO 寃��깋(�븘�씠�뵒, �젣紐�)
	 * @return
	 */
	public List<UserBoardVO> searchBoard(UserBoardVO ubVO){
		List<UserBoardVO> list=null;
		try {
			list=ubDAO.selectBoard(ubVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return list;
	}//allBoard
	
	
	/** 
	 * �럹�씠吏� 泥섎━瑜� �쐞�븳 �쟾泥� 寃뚯떆湲� 媛��닔 �뼸湲�
	 * @param cat_num 移댄뀒怨좊━ 踰덊샇
	 * @return �쟾泥� 寃뚯떆湲� �닔
	 */
	public void searchTotalCount(int cat_num) {
		int cnt=0;
		
		try {
			cnt=ubDAO.selectTotalCount( cat_num );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		UserBoardVO ubVO=new UserBoardVO();
		ubVO.setTotalCnt(cnt);
	}//searchTotalCount
	
	/**
	 * �븳 �럹�씠吏��떦 蹂댁뿬以� 寃뚯떆湲� �닔
	 * @return 10媛�
	 */
	public void pageScale() {
		UserBoardVO ubVO=new UserBoardVO();
		ubVO.setPageScale(10);
	}//pageScale
	

	/**
	 * �쟾泥� 寃뚯떆湲��쓣 10媛쒖뵫 �굹�댋�쓣 �븣 �븘�슂�븳 �럹�씠吏� �닔
	 * @param totalCnt �쟾泥� 寃뚯떆湲� �닔
	 * @param pageScale 10媛�
	 * @return �븘�슂�븳 �럹�씠吏� �닔
	 */
	public void pageCnt(UserBoardVO ubVO) {
		int pageCnt=0;
		pageCnt=(int)Math.ceil((double)ubVO.getTotalCnt()/ubVO.getPageScale());
		ubVO.setPageCnt(pageCnt);
	}//end pageCnt
	
	
	/**
	 * �럹�씠吏� 泥� 寃뚯떆湲� 踰덊샇 �뼸湲�
	 * @param currentPage �쁽�옱 �럹�씠吏� 踰덊샇
	 * @param pageScale 10媛�
	 * @return 
	 */
	public void startNum(UserBoardVO ubVO) {
		int startNum=1;
		
		startNum=ubVO.getCurrentPage()*ubVO.getPageScale()-ubVO.getPageScale()+1;
		ubVO.setStartNum(startNum);
	}//startNum
	
	
	/**
	 * �럹�씠吏� 留덉�留� 寃뚯떆湲� 踰덊샇 �뼸湲�
	 * @param startNum �럹�씠吏� 泥ル쾲吏� 寃뚯떆湲� 踰덊샇
	 * @param pageScale 10媛�
	 * @return 留덉�留� 寃뚯떆湲� 踰덊샇
	 */
	public void endNum(UserBoardVO ubVO) {
		int endNum=0;
		endNum=ubVO.getStartNum()+ubVO.getPageScale()-1;
		ubVO.setEndNum(endNum);
	}//endNum
	
	/**
	 * 寃뚯떆湲� �궘�젣
	 * @param bd_id
	 * @return �궘�젣 �꽦怨� �뿬遺�
	 */
	public int removeBoard(int bd_id) {
		int success=0;
		
		try {
			success=ubDAO.deleteBoard( bd_id );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//removeBoard
	
	/**
	 * 寃뚯떆湲� 異붽�
	 * @param ubVO
	 */
	public void addBoard(UserBoardVO ubVO) {
		
		try {
			ubDAO.insertBoard( ubVO );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
	}//addBoard
	
	/**
	 * 寃뚯떆湲� �닔�젙
	 * @param ubVO
	 * @return �꽦怨� �뿬遺�
	 */
	public int modifyBoard(UserBoardVO ubVO) {
		int success=0;
		
		try {
			success=ubDAO.updateBoard( ubVO );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//addBoard
	
	/**
	 * 寃뚯떆湲� �긽�꽭
	 * @param bd_id
	 * @return
	 */
	public UserBoardVO boardDetail(int bd_id) {
		UserBoardVO ubVO=new UserBoardVO();
		
		try {
			ubVO=ubDAO.selectBoardDetail( bd_id );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return ubVO;
	}//boardDetail
	
	/**
	 * 移댄뀒怨좊━ 蹂댁뿬二쇨린
	 * @return
	 */
	public List<UserBoardVO> category() {
		List<UserBoardVO> list=null;
		try {
			list=ubDAO.selectCat();
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return list;
	}//category
	
	/**
	 * 酉� �닔 �닔�젙
	 * @param bd_id
	 */
	public void modifyView(int bd_id) {
		try {
			ubDAO.updateView(bd_id);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
	}//modifyView
	
	/**
	 * �뙎湲� 蹂댁뿬二쇨린
	 * @param bd_id
	 * @return
	 */
	public List<UserBoardVO> comment (int bd_id) {
		List<UserBoardVO> list= null;
		
		try {
			list=ubDAO.selectCom(bd_id);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return list;
	}//comment
	
	/**
	 * �뙎湲� �궘�젣
	 * @param cm_id
	 * @return
	 */
	public int removeCom (int cm_id) {
		int success=0;
		
		try {
			success=ubDAO.deleteCom(cm_id);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//removeCom
	
	/**
	 * �뙎湲� 異붽�
	 * @param ubVO
	 * @return
	 */
	public int addCom (UserBoardVO ubVO) {
		int success=0;
		
		try {
			success=ubDAO.insertCom(ubVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return success;
	}//addCom
	
}//class
