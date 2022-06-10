package kr.co.sist.user.reservation.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class UserReservationVO {
	private String  userid, visit_date;
	private int rez_count, ex_num;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
	}
	public int getRez_count() {
		return rez_count;
	}
	public void setRez_count(int rez_count) {
		this.rez_count = rez_count;
	}
	public int getEx_num() {
		return ex_num;
	}
	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}
	@Override
	public String toString() {
		return "UserReservationVO [userid=" + userid + ", visit_date=" + visit_date + ", rez_count=" + rez_count
				+ ", ex_num=" + ex_num + "]";
	}
	
	
}
