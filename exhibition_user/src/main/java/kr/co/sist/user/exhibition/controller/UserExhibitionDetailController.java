package kr.co.sist.user.exhibition.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.user.exhibition.service.UserExhibitionDetailService;

@Controller
public class UserExhibitionDetailController {
	@Autowired(required = false)
	private UserExhibitionDetailService ueds;
	
	@RequestMapping(value="/exhibition_detail.do", method = GET)
	public String exhibitionView(Model model,int ex_num, int ex_hall_num) {
		
		model.addAttribute("exhibitionView",ueds.exhibitionView(ex_num));
		model.addAttribute("mapView",ueds.mapView(ex_hall_num));
		
		return "user/exhibition/exhibition_detail";
	}
//	//�Խ���
//	@RequestMapping(value="/board.do", method =  {GET, POST})
//	public String relBoardView(Model model,int cat_num) {
//	
//		model.addAttribute("relBoardView",ueds.relBoard(cat_num));
//		
//		return "user/board";
//	}
}
