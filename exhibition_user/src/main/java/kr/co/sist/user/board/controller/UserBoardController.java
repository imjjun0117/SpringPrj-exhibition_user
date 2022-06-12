package kr.co.sist.user.board.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.user.board.domain.UserBoardDomain;
import kr.co.sist.user.board.service.UserBoardService;
import kr.co.sist.user.board.vo.ReplyVO;
import kr.co.sist.user.board.vo.UserBoardVO;

@Controller
public class UserBoardController {
	
	@Autowired(required = false)
	private UserBoardService ubs;
	
	@RequestMapping(value={"/catBoard.do", "/board.do"}, method=GET)
	public String searchBoard(Model model, UserBoardVO ubVO, HttpServletRequest request, HttpSession session) { 
		
		int cat_num= request.getParameter("cat_num")==null?0:Integer.parseInt(request.getParameter("cat_num"));
		int currentNum = request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));
		String userid = (String)session.getAttribute("id");
		if(userid != null && !"".equals(userid)) {
			session.setAttribute("mgr",ubs.findMgr(userid));
		}
		ubVO.setStartNum(ubs.startNum(currentNum));
		ubVO.setEndNum(ubs.endNum(currentNum));
		model.addAttribute("catList",ubs.category());
		model.addAttribute("totalCnt", ubs.searchTotalCount(cat_num));
		model.addAttribute("pageScale", ubs.pageScale() );
		model.addAttribute("pageCnt", ubs.pageCnt(cat_num) );
		model.addAttribute("startNum", ubs.startNum(currentNum)); 
		model.addAttribute("endNum", ubs.endNum(currentNum)); 
		model.addAttribute("endPage", ubs.endPage(cat_num) );
		model.addAttribute("boardList",ubs.searchBoard(ubVO));
		return "user/board/board";
	  }//searchBoard
	
	
	/**
	 * 게시글 추가 폼 불러오기
	 * @return
	 */
	@RequestMapping(value="/boardForm.do", method=GET)
	public String addBoardForm(Model model) {
		model.addAttribute("catList", ubs.category());
		
		return "user/board/boardWrite";
	}//addBoardForm
	
	
	/**
	 * 게시글 추가
	 * @param ubVO
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addBoard.do", method=POST)
	public String addBoard(UserBoardVO ubVO, HttpSession session) {
		String msg = "세션이 만료되었습니다.";
		int cnt = 0;
		ubVO.setImg_file(ubVO.getImg_file().substring(ubVO.getImg_file().lastIndexOf("\\")+1));
		cnt=ubs.addBoard(ubVO);
		if(cnt > 0) {
			msg = String.valueOf(cnt);
		}//end if
		
		
		return msg;
	}//deleteBoard
	
	
	
	/**
	 * 게시글 상세
	 * @param model
	 * @param bd_id
	 * @return
	 */
	@RequestMapping(value="/boardDetail.do", method=GET)
	public String boardDetail(HttpSession session, Model model,UserBoardVO uVO) {
		int bd_id = uVO.getBd_id();
		UserBoardDomain ubDomain = null;
		
		if(bd_id != 0) {
			
			ubDomain = ubs.boardDetail(bd_id);
			ubs.modifyView(uVO);
			model.addAttribute("detailData", ubDomain);
			model.addAttribute("comList",ubs.comment(bd_id));
		}//end if
		
		return "user/board/boardDetail";
	}//boardDetail

	
	/**
	 * 게시글 수정
	 * @param model
	 * @param session
	 * @param ubVO
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/modifyBoard.do", method=POST)
	public String modifyBoard(HttpSession session,UserBoardVO ubVO) {
		//System.out.println("------------------------------"+ubVO);
		String sessionId = (String)session.getAttribute("id");
		String msg = "세션이 만료되었습니다.";
		//System.out.println(ubVO.getUserid());
//		System.out.println("-------------------------"+ubVO.getBd_id());
//		System.out.println("-------------------------"+session.getAttribute("id")+" / "+sessionId);
		
		if((!"".equals(sessionId)&&sessionId!=null) || "admin".equals(sessionId) ) {
			msg = ubs.modifyBoard(ubVO); 
		}//end if
		 		
		return msg;
	}//modifyBoard
	
	
	/**
	 * 댓글 삭제
	 * @param model �궘�젣 �셿猷�
	 * @param cm_id �궘�젣�븷 �뙎湲�
	 * @param session �뙎湲� �벖 �궗�슜�옄�� �쁽�옱 �젒�냽 以� �궗�슜�옄媛� 媛숈쓣 寃쎌슦
	 * @return
	 */
	@RequestMapping(value="/deleteComm.do", method={POST,GET})
	public String removeCom(Model model,@RequestParam(defaultValue = "0") int reply_id, HttpServletRequest request) {
		
		reply_id=Integer.parseInt(request.getParameter("reply_id")) ;
		ubs.removeCom(reply_id);
		
		model.addAttribute("value",request.getParameter("bd_id"));
		
		return "redirect:boardDetail.do";
	}//removeCom
	
	@RequestMapping(value="/insertComm.do", method= POST)
	@ResponseBody
	public String addCom(ReplyVO rVO,HttpSession session) {
		String msg = "세션이 만료되었습니다.";
		if(session.getAttribute("id")!=null && !"".equals(session.getAttribute("id"))) {
			msg = ubs.addCom(rVO);
		}//end if
		return msg;
	}//addCom
	
	
	
	
	
	
}//class
