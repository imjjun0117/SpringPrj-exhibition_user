package kr.co.sist.user.reservation.vo;

import org.springframework.web.bind.annotation.RequestParam;

public class ReservationDomain {
	private int ex_num;
	private String ex_name,ex_info,exhibition_poster, ex_loc, address1;
	public int getEx_num() {
		return ex_num;
	}
	public void setEx_num(@RequestParam(defaultValue = "1") int ex_num) {
		this.ex_num = ex_num;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	public String getEx_info() {
		return ex_info;
	}
	public void setEx_info(String ex_info) {
		this.ex_info = ex_info;
	}
	public String getExhibition_poster() {
		return exhibition_poster;
	}
	public void setExhibition_poster(String exhibition_poster) {
		this.exhibition_poster = exhibition_poster;
	}
	public String getEx_loc() {
		return ex_loc;
	}
	public void setEx_loc(String ex_loc) {
		this.ex_loc = ex_loc;
	}
	
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@Override
	public String toString() {
		return "ReservationDamain [ex_num=" + ex_num + ", ex_name=" + ex_name + ", ex_info=" + ex_info
				+ ", exhibition_poster=" + exhibition_poster + ", ex_loc=" + ex_loc + "]";
	}
	
	
	
}
