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
	
		@RequestMapping(value ="/idfind.do",method =RequestMethod.GET)
		public String getIdFind()throws Exception{
			return "user/login/idfind";
		}//getIdFind
		@RequestMapping(value ="/idfindChk.do",method =RequestMethod.POST)
		public String FindId(MemberVO mVO, Model model)throws Exception{
			String userId=idfindService.findId(mVO);
			String page="";
			
			if(userId=="" || userId==null) {
				model.addAttribute("check",1);
				page = "user/login/idfind";
			}else {
				model.addAttribute("id",userId);
				page="user/login/idfinded";
			}
			return page;
		}//FindId
		
		@RequestMapping(value ="/passfind.do",method =RequestMethod.GET)
		public String GetpassFind(){
			return "user/login/passfind";
		}//getIdFind
		
		@RequestMapping(value ="/passfind.do",method =RequestMethod.POST)
		public String PostpassFind(MemberVO mVO,Model model){
			int cnt=0;
			cnt=idfindService.findPassword(mVO);
			String page="";
			
			if(cnt!=1) {
				model.addAttribute("check",0);
				page="user/login/passfind";
			}else {
				model.addAttribute("updateid",mVO.getUserId());
				page="user/login/updatePass";
			}
			return page;
		}//getIdFind
		
		//updatePassword
		@RequestMapping(value="/updatePass.do",method=RequestMethod.POST)
		public String updatePasswordAction (MemberVO mVO, Model model) {
			
			int cnt = idfindService.updatePassword(mVO);
			String page = "user/login/passclear";
			
			System.out.println(cnt);
			if(cnt!=1) {
				model.addAttribute("msg", 1);
				page="user/login/updatePass";
			}
			return page;
		}
		
		
}
