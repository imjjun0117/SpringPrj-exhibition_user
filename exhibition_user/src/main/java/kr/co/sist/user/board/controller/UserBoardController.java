package kr.co.sist.user.board.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.lang.Object.*;
import java.net.http.HttpRequest;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.board.domain.UserBoardDomain;
import kr.co.sist.user.board.service.UserBoardService;
import kr.co.sist.user.board.vo.UserBoardVO;

@Controller
public class UserBoardController {
	
	@Autowired(required = false)
	private UserBoardService ubs;
	
	@RequestMapping(value={"/catBoard.do", "/board.do"}, method=GET)
	public String searchBoard(Model model, UserBoardVO ubVO, HttpServletRequest request, HttpSession session) { 
		
		int cat_num= request.getParameter("cat_num")==null?0:Integer.parseInt(request.getParameter("cat_num"));
		int currentNum = request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));
		
		if(ubVO.getCat_num() != 0) {
			ubVO.setCat_num(1);
		}//end if
		
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
	 * 게시글 삭제
	 * @param model 
	 * @param session 
	 * @param bd_id
	 * @return
	 */
	@RequestMapping(value="/deleteBoard.do", method=POST)
	public String deleteBoard(Model model,HttpSession session, @RequestParam(defaultValue = "0") int bd_id) {
		
		UserBoardVO ubVO=new UserBoardVO();
		int success=0;
		if(bd_id != 0 && session.getAttribute("id") == ubVO.getUserid()) {
			model.addAttribute("removeResult",ubs.removeBoard(bd_id));
		}//end if
		
		return "user/board/deleteBoard";
	}//deleteBoard
	
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
	@RequestMapping(value="/addBoard.do", method=POST)
	public String addBoard(UserBoardVO ubVO, HttpSession session, 
			HttpServletRequest request, HttpServletResponse response) {
		
      //<form enctype="multipart/form-data">라면 FileUpload Component를 사용하여 값을 받는다.
	  //1. 업로드 될 파일의 경로 얻기
//	  File saveDirectory=new File("E:/project2/ImageFile");
//	
//	  //2.업로드 될 파일의 크기 설정
//	  int fileSize=1024*1024*10; //10MByte
//	
//	  DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
//	  //3. 파일 업로드 컴포넌트 생성
//	  MultipartRequest mr=new MultipartRequest(request, saveDirectory.getPath(),fileSize,"UTF-8", policy);
//	
//	  String title=mr.getParameter("title");
//	  String desc=(mr.getParameter("ta"));
//	  String catNum=mr.getParameter("Exhibition");
//	  String id =String.valueOf(session.getAttribute("id"));
//	  String fileSystemName=mr.getFilesystemName("img");
//	 
//	  if(fileSystemName == null){
//		  fileSystemName="null";
//	  }
//	  ubVO.setTitle(title);
//	  ubVO.setDescription(desc);
//	  ubVO.setCat_num(catNum);
//	  ubVO.setUserid(String.valueOf(session.getAttribute("id")) );
//	  ubVO.setImg_file(fileSystemName);
	  
//	  	ImageResize.resizeImage(saveDirectory.getPath()+"/"+fileSystemName, 80, 60);
		
		ubs.addBoard(ubVO);
		
		return "redirect:board.do";
	}//deleteBoard
	
	
	
	/**
	 * 게시글 상세
	 * @param model
	 * @param bd_id
	 * @return
	 */
	@RequestMapping(value="/boardDetail.do", method=GET)
	public String boardDetail(HttpSession session, Model model,@RequestParam(defaultValue = "0") int bd_id, HttpServletRequest request) {
		
		bd_id = Integer.parseInt(request.getParameter("value")) ;
		UserBoardVO ubVO = null;
		UserBoardDomain ubDomain = null;
		
		if(bd_id != 0) {
			ubDomain = ubs.boardDetail(bd_id);
			ubVO = new UserBoardVO();
			
			ubs.modifyView(bd_id);
			ubVO.setBoard_views(ubDomain.getboard_views());
			
			model.addAttribute("detailData", ubDomain);
			model.addAttribute("comList",ubs.comment(bd_id));
		}//end if
		
		return "user/board/boardDetail";
	}//boardDetail

	
	/**
	 * 게시글 수정
	 * @param model �꽦怨듭뿬遺�
	 * @param ubVO 
	 * @param session �옉�꽦�옄�� �닔�젙�븯�젮�뒗 �옄 �븘�씠�뵒 ��議�
	 * @return
	 */
	@RequestMapping(value="/modifyBoard.do", method=GET)
	public String modifyBoard(Model model, UserBoardVO ubVO, HttpSession session, HttpServletRequest request) {
		request.getParameter("bd_id");
		System.out.println(ubVO.getUserid());
		System.out.println(session.getAttribute("id"));
		if(ubVO.getUserid() == String.valueOf(session.getAttribute("id")).trim()) {
			model.addAttribute("flag",ubs.modifyBoard(ubVO));
		}//end if
		
		return "user/board/modifyBoard";
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
	
	@RequestMapping(value="/insertComm.do", method= {POST,GET})
	public String addCom(Model model,UserBoardVO ubVO, HttpSession session, HttpServletRequest request) {
			ubVO.setReply_userid(String.valueOf(session.getAttribute("id")) );
		    ubVO.setReply_description(ubVO.getReply_description());
			ubVO.setBd_id(ubVO.getBd_id());
			ubs.addCom(ubVO);
			model.addAttribute("value", ubVO.getBd_id() );
		return "redirect:boardDetail.do";
	}//addCom
	
	
	
	
	
	
}//class
