package kr.co.sist.user.myInfo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.service.MyInfoServiceImpl;

@Controller
@SessionAttributes("loginUser")
public class MyInfoController {
	
	@Autowired(required = false)
	private MyInfoServiceImpl serviceImpl;
	
	
	//내정보로 들어가는 get
		@RequestMapping(value="/my_account_pass.do",method = RequestMethod.GET)
		public String startMyinfo(HttpSession session) {
			//System.out.println(session.getAttribute("id"));
			if(session.getAttribute("id")==null) {
				return"redirect:login.do";
			}else {
				return "user/myaccount/my_account_pass";
			}//end else
		}//startMyInfo
		
		//내정보 비밀번호 체크
			@RequestMapping(value="/checkMyPass.do",method = RequestMethod.POST)
			public String passChk(MemberVO mVO,Model model,HttpSession session) {
				String userid =(String)session.getAttribute("id"); 
				mVO.setUserId(userid);
				int cnt = serviceImpl.pwCheck(mVO);
				//System.out.println(cnt+" /  -------------------------"+mVO+"/");
				if(cnt == 1) {
					model.addAttribute("myRezList",serviceImpl.searchMyReservation(userid));
					return "user/myaccount/my-account_rez";
				}else {
					model.addAttribute("check",1);
					model.addAttribute("message","비밀번호를확인해주세요");
					return "redirect:/user/myaccount/my_account_pass";
				}//end else
				
			}
			
			@RequestMapping(value="/myRezDetail.do")
			public String myRezDetailInfo(@RequestParam(defaultValue = "-1")int rez_num,Model model) {
				
				model.addAttribute("myRezDetail",serviceImpl.searchMyRezDetail(rez_num));
				return "user/myaccount/my-account_rez_child";
			}//myRezDetailInfo
		
			@ResponseBody
			@RequestMapping(value="/cancelRez.do",method=RequestMethod.POST)
			public String cancelRez(int rez_num) {
				return serviceImpl.cancelRez(rez_num);
			}//myRezDetail
			
		//내정보 수정 페이지
		@RequestMapping(value="/my_account_modify.do", method=RequestMethod.GET)
		public String accountModifyFrm(HttpSession session, Model model) {
			String userId = (String)session.getAttribute("id");
			List<MemberVO> list = serviceImpl.searchMember(userId);
			
			model.addAttribute("memberList", list);
			
			return "user/myaccount/my_account_modify";
		}
		
		@RequestMapping(value="/my_account_modify_process.do", method=RequestMethod.POST)
		public String accountModify(MemberVO member , Model model) {
			int cnt = serviceImpl.updateMember(member);
			String page= "user/myaccount/my_account_success";
			if(cnt!=0) {
				model.addAttribute("msg", 1);
				page = "user/myaccount/my_account_modify";
			}
			
			return page;
		}
		
}//class
