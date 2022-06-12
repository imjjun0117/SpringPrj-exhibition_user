package kr.co.sist.user.board.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.user.board.dao.UserBoardDAO;
import kr.co.sist.user.board.domain.UserBoardDomain;
import kr.co.sist.user.board.vo.ReplyVO;
import kr.co.sist.user.board.vo.UserBoardVO;
import kr.co.sist.user.s3.FileManagement;

@Component
public class UserBoardService {
	
	@Autowired(required = false)
	private UserBoardDAO ubDAO;
	@Autowired(required = false)
	private FileManagement fm;
	/**
	 * 移댄뀒怨좊━�뿉 �뵲�씪 �쟾泥� 寃뚯떆湲� 由ъ뒪�듃 異쒕젰
	 * @param ubVO 寃��깋(�븘�씠�뵒, �젣紐�)
	 * @return
	 */
	public List<UserBoardDomain> searchBoard(UserBoardVO ubVO){
		List<UserBoardDomain> list=null;
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
	public int searchTotalCount(int cat_num) {
		int cnt=0;
		
		try {
			cnt=ubDAO.selectTotalCount( cat_num );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return cnt;
	}//searchTotalCount
	
	/**
	 * �븳 �럹�씠吏��떦 蹂댁뿬以� 寃뚯떆湲� �닔
	 * @return 10媛�
	 */
	public int pageScale() {
		return 10;
	}//pageScale
	

	/**
	 * �쟾泥� 寃뚯떆湲��쓣 10媛쒖뵫 �굹�댋�쓣 �븣 �븘�슂�븳 �럹�씠吏� �닔
	 * @param totalCnt �쟾泥� 寃뚯떆湲� �닔
	 * @param pageScale 10媛�
	 * @return �븘�슂�븳 �럹�씠吏� �닔
	 */
	public int pageCnt(int cat_num) {
		int pageCnt=0;
		pageCnt=(int)Math.ceil((double)searchTotalCount(cat_num)/pageScale());
		return pageCnt;
	}//end pageCnt
	
	
	/**
	 * �럹�씠吏� 泥� 寃뚯떆湲� 踰덊샇 �뼸湲�
	 * @param currentPage �쁽�옱 �럹�씠吏� 踰덊샇
	 * @param pageScale 10媛�
	 * @return 
	 */
	public int startNum(int currentNum) {
		int startNum=1;
		if(currentNum!=0) {
			startNum = currentNum*pageScale()-pageScale()+1;
		}
		return startNum;
	}//startNum
	
	
	/**
	 * �럹�씠吏� 留덉�留� 寃뚯떆湲� 踰덊샇 �뼸湲�
	 * @param startNum �럹�씠吏� 泥ル쾲吏� 寃뚯떆湲� 踰덊샇
	 * @param pageScale 10媛�
	 * @return 留덉�留� 寃뚯떆湲� 踰덊샇
	 */
	public int endNum(int currentNum) {
		int endNum=0;
		endNum=startNum(currentNum)+pageScale()-1;
		return endNum;
	}//endNum
	
	
	public int endPage(int cat_num) {
		int endPage = searchTotalCount(cat_num) / pageScale();
		if(searchTotalCount(cat_num) % pageScale()!=0) {
			endPage +=1;
		}
		return endPage;
	}
	
	
	/**
	 * 게시글 추가
	 * @param ubVO
	 */
	public int addBoard(UserBoardVO ubVO) {
		int cnt = 0;
		try {
			cnt = ubDAO.insertBoard( ubVO );
			fm.FileUploader(ubVO.getImg_s3());
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	
		return cnt;
	}//addBoard
	
	/**
	 * 게시글 수정
	 * @param ubVO
	 * @return �꽦怨� �뿬遺�
	 */
	public String modifyBoard(UserBoardVO ubVO) {
		int cnt = 0;
		try {
			if(ubVO.getImg_s3() != null) {
				fm.FileUploader(ubVO.getImg_s3());
				ubVO.setImg_file(ubVO.getImg_file().substring(ubVO.getImg_file().lastIndexOf("\\")+1));
			}//end if
			cnt = ubDAO.updateBoard( ubVO );
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return String.valueOf(cnt);
	}//addBoard
	
	/**
	 * 게시글 삭제
	 * @param bd_id
	 * @return
	 */
	public UserBoardDomain boardDetail(int bd_id) {
		UserBoardDomain ubDomain=new UserBoardDomain();
		
		try {
			ubDomain=ubDAO.selectBoardDetail( bd_id );
			String filePath = ubDomain.getImg_file();
			if(filePath != null && !"".equals(filePath)) {
				ubDomain.setImg_file(fm.getFileUrl(ubDomain.getImg_file()));
			}
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return ubDomain;
	}//boardDetail
	
	/**
	 * 카테고리 목록 가져오기
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
	 * view 수
	 * @param bd_id
	 */
	public int modifyView(UserBoardVO uVO) {
		int cnt =0;
		try {
			uVO.setBoard_views(uVO.getBoard_views()+1);
			cnt=ubDAO.updateView(uVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		return cnt;
	}//modifyView
	
	/**
	 *  댓글 select
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
	public String addCom (ReplyVO rVO) {
		int success=0;
		
		try {
			success=ubDAO.insertCom(rVO);
		}catch (PersistenceException pe) {
			pe.printStackTrace();
		}//end catch	
		
		return String.valueOf(success);
	}//addCom
	
	public String findMgr(String userid) {
		String mgr = "";
		try {
			mgr = ubDAO.selectManager(userid);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		return mgr;
	}
	
}//class
