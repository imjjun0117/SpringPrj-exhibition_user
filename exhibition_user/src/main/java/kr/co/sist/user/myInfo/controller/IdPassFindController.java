package kr.co.sist.user.myInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.account.vo.MemberVO;
import kr.co.sist.user.myInfo.service.UserIdFindSerivce;
@Controller
@SessionAttributes("IdPassFind")
public class IdPassFindController {
	@Autowired(required = false)
	private UserIdFindSerivce idfindService;
	
	//아이디찾기 폼으로 들어갈때
		@RequestMapping(value ="/user/login/idfind.do",method =RequestMethod.GET)
		public void getIdFind()throws Exception{
			
		}//getIdFind
	//아이디찾기 실행
		@RequestMapping(value ="/user/login/idfind.do",method =RequestMethod.POST)
		public String FindId(MemberVO mVO,Model model)throws Exception{
			MemberVO member=idfindService.findId(mVO);
			if(member==null) {
				model.addAttribute("check",1);
				
			}else {
				model.addAttribute("check",0);
				model.addAttribute("id",member.getUserId());
			}
			return "user/login/idfind";
		}//FindId
		
		//비밀번호찾기화면으로 이동
		@RequestMapping(value ="/user/login/passfind.do",method =RequestMethod.GET)
		public void GetpassFind()throws Exception{
			
		}//getIdFind
		
		//비밀번호찾기
		@RequestMapping(value ="/user/login/passfind.do",method =RequestMethod.POST)
		public String PostpassFind(MemberVO mVO,Model model)throws Exception{
			MemberVO member=idfindService.findPassword(mVO);
			if(member==null) {
				model.addAttribute("check",1);
			}else {
				model.addAttribute("check",0);
				model.addAttribute("updateid",member.getUserId());
			}
			return "user/login/passfind";
		}//getIdFind
		//비밀번호 바꾸기 실행
		@RequestMapping(value="/user/login/passclear.do",method=RequestMethod.POST)
		public String updatePasswordAction
		(@RequestParam(value="updateid",defaultValue =" ",required = false )String userId,MemberVO mVO) {
			
			mVO.setUserId(userId);
			System.out.println(mVO);
			idfindService.updatePassword(mVO);
			return "user/login/passclear";
		}
		/*
		 * //비밀번호 바꾸기 성공하면 나오는 페이지
		 * 
		 * @RequestMapping(value="/user/passclear.do",method) public String
		 * checkPassword(HttpSession session,Model model) { //MemberVO
		 * memberUser=(MemberVO)session.getAttribute("memberUser");
		 * 
		 * return "user/passclear"; }
		 */
		
}
