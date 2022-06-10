package kr.co.sist.user.exhibition.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.exhibition.service.UserExhibitionService;
import kr.co.sist.user.exhibition.vo.UserExhibitionVO;

@Controller
public class UserExhibitionController {
	
	@Autowired(required = false)
	private UserExhibitionService us;
	
	//전시 리스트
	@RequestMapping(value="/user/list.do",method = GET)
	public String exListView(Model model, UserExhibitionVO ueVO) {
			model.addAttribute("exListView",us.exListView(ueVO));
		return "user/exhibition/list";
	}
	
	//������ �˻�
	@RequestMapping(value="/user/loc.do",method = GET)
	public String searchLocEx(Model model) {
		
		model.addAttribute("searchLocEx",us.searchLocEx());
		
		return "user/exhibition/loc";
	}
	
}
