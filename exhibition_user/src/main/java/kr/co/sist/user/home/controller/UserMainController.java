package kr.co.sist.user.home.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.home.service.UserMainService;

@Controller
public class UserMainController {
	
	@Autowired(required = false)
	private UserMainService us;
	
	@RequestMapping(value="/index.do", method = GET)
	public String userMain(Model model) {
		model.addAttribute("exView",us.mainExView());
		model.addAttribute("locView",us.locView());
		model.addAttribute("listView",us.listView());
		model.addAttribute("exGraph",us.exGraph());
		model.addAttribute("sumGraph",us.sumGraph());
		  
		return "user/index";
	}
}
