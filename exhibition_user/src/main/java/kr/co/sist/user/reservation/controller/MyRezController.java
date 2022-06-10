package kr.co.sist.user.reservation.controller;
//package kr.co.sist.user.controller;
//
//import static org.springframework.web.bind.annotation.RequestMethod.GET;
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import kr.co.sist.user.service.MyRezService;
//import kr.co.sist.user.vo.MyReservationVO;;
//
//@Controller
//public class MyRezController {
//	@Autowired(required = false)
//	private MyRezService mrs;
//	
//	@RequestMapping(value="/user/myRez.do", method=POST)
//	public String searchRez(Model model, HttpSession session) { 
//	
//		model.addAttribute(mrs.searchRez(session.getId()));
//		  
//		return "user/myRez";
//	  }//searchBoard
//	
//	@ResponseBody
//	@RequestMapping(value="/user/myRezDetail.do", method=GET)
//	public String myRezDetail(Model model,@RequestParam(defaultValue = "0") int rez_num, HttpSession session ) {
//		
//		if(rez_num != 0) {
//		MyReservationVO mrVO=new MyReservationVO();
//		mrVO.setRez_num(rez_num);
//		mrVO.setUserid(session.getId());
//		model.addAttribute("rezDetailData",mrs.searchRezDetail(mrVO));
//		}//end if
//		
//		return "user/myRezDetail";
//	}//myRezDetail
//	
//	/**
//	 * �삁�빟 痍⑥냼
//	 * @param model
//	 * @param rez_num
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping(value="/user/myRezCancle.do", method=POST)
//	public String myRezCancle(Model model,@RequestParam(defaultValue = "0") int rez_num, HttpSession session) {
//	
//		if(rez_num != 0) {
//			MyReservationVO mrVO=new MyReservationVO();
//			mrVO.setRez_num(rez_num);
//			mrVO.setUserid(session.getId());
//			model.addAttribute("rezCancleResult",mrs.rezCancle(mrVO));
//			}//end if
//		
//		return "user/myRezCancle";
//	}//myRezCancle
//	
//	
//}//class
