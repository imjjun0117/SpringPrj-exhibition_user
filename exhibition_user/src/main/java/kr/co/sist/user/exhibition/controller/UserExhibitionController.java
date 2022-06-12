package kr.co.sist.user.exhibition.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value="/list.do",method = GET)
	public String exListView(Model model, UserExhibitionVO ueVO, HttpServletRequest request) {

		int ex_hall_num= request.getParameter("ex_hall_num")==null?0:Integer.parseInt(request.getParameter("ex_hall_num"));
		int currentNum = request.getParameter("pageNum")==null?1:Integer.parseInt(request.getParameter("pageNum"));

		
		ueVO.setStartNum(us.startNum(currentNum));
			ueVO.setEndNum(us.endNum(currentNum));
			model.addAttribute("totalCnt", us.searchTotalCount(ex_hall_num));
			model.addAttribute("endPage", us.endPage(ex_hall_num) ); 
			model.addAttribute("pageCnt", us.pageCnt(ex_hall_num) );
			model.addAttribute("pageScale", us.pageScale() );
			model.addAttribute("startNum", us.startNum(currentNum)); 
			model.addAttribute("endNum", us.endNum(currentNum)); 
			model.addAttribute("exListView",us.exListView(ueVO));
		return "user/exhibition/list";
	}
	
	//������ �˻�
	@RequestMapping(value="/loc.do",method = GET)
	public String searchLocEx(Model model) {
		
		model.addAttribute("searchLocEx",us.searchLocEx());
		
		return "user/exhibition/loc";
	}
	
}
