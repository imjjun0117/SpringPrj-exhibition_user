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
		List<UserExhibitionVO> list = null;

		try {
			list = ueDAO.selectAllExList(ueVO);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}


	public List<UserExhibitionHallVO> searchLocEx() {
		List<UserExhibitionHallVO> list = null;

		try {
			list = ueDAO.selectLocalExList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}

	/**
	 * 전체레코드의 수
	 * 
	 * @return
	 */
	public int searchTotalCount(int ex_hall_num) {
		int cnt = 0;

		try {
			cnt = ueDAO.selectTotalCount(ex_hall_num);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		return cnt;
	}

	/**
	 * 한화면에 보여줄 페이지의 수
	 * 
	 * @return
	 */
	public int pageScale() {
		int pageCnt = 2;

		return pageCnt;
	}

	/**
	 * 모든 게시물을 보여주기 위한 페이지 수(총페이지수)
	 * 
	 * @param totalCnt
	 * @param pageScale
	 * @return
	 */
	public int pageCnt(int ex_hall_num) {
		int pageCnt = 0;
		pageCnt = (int) Math.ceil((double) searchTotalCount(ex_hall_num) / pageScale());
//		pageCnt=totalCnt/pageScale;
//		if(totalCnt%pageScale!=0) {
//			pageCnt++;
//			
//		}
		return pageCnt;
	}

	/**
	 * 시작번호 구하기
	 * 
	 * @param currentPage-현재 페이지 번호
	 * @param pageScale      - 한 화면에 보여줄 페이지 수
	 * @return
	 */
	public int startNum(int currentNum) {
		int startNum = 1;
		if (currentNum != 0) {
			startNum = currentNum * pageScale() - pageScale() + 1;
		}
		return startNum;
	}

	/**
	 * 끝번호 구하기
	 * 
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endPage(int ex_hall_num) {
		int endPage = searchTotalCount(ex_hall_num) / pageScale();
		if (searchTotalCount(ex_hall_num) % pageScale() != 0) {
			endPage += 1;

		}
			return endPage;

	}
	
	public int endNum(int currentNum) {
		int endNum=0;
		endNum=startNum(currentNum)+pageScale()-1;
		return endNum;
	}//endNum
}