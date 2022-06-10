package kr.co.sist.user.reservation.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.user.exhibition.vo.UserExhibitionVO;
import kr.co.sist.user.reservation.service.UserReservationService;
import kr.co.sist.user.reservation.vo.ReservationDomain;
import kr.co.sist.user.reservation.vo.UserReservationVO;

@Controller
public class UserReservationController {

	@Autowired(required = false)
	private UserReservationService urs;
	
	@RequestMapping(value="/user/reservation.do", method= {GET, POST})
	public String reservation(ReservationDomain domain, Model model) {
	
		model.addAttribute("exInfo", urs.exList(domain.getEx_num()));
		model.addAttribute("exName", urs.selectExName());
		return "user/reservations/reservation";
	}//Reservation
	
	@RequestMapping(value = "/user/rezProcess.do", method = POST)
	public String rezProcess(UserReservationVO rvo) {
		int cnt = urs.makeRez(rvo);
		String page = "user/reservations/reservation_clear";
		if(cnt==0) {
			page="redirect:user/reservation.do";
		}
		
		return page;
	}
	

}//class
