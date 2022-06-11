package kr.co.sist.user.myInfo.vo;

import java.sql.Date;

public class MyReservationDomain {

private String rez_status,userid,ex_name, ex_hall_name;
private int ex_num,rez_num , rez_count, rez_price, rez_total, start_page, end_page;
private Date rez_date,visit_date;
	
	public String getRez_status() {
		return rez_status;
	}
	public void setRez_status(String rez_status) {
		this.rez_status = rez_status;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	public String getEx_hall_name() {
		return ex_hall_name;
	}
	public void setEx_hall_name(String ex_hall_name) {
		this.ex_hall_name = ex_hall_name;
	}
	public int getEx_num() {
		return ex_num;
	}
	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}
	public int getRez_num() {
		return rez_num;
	}
	public void setRez_num(int rez_num) {
		this.rez_num = rez_num;
	}
	public int getRez_count() {
		return rez_count;
	}
	public void setRez_count(int rez_count) {
		this.rez_count = rez_count;
	}
	public int getRez_price() {
		return rez_price;
	}
	public void setRez_price(int rez_price) {
		this.rez_price = rez_price;
	}
	public int getRez_total() {
		return rez_total;
	}
	public void setRez_total(int rez_total) {
		this.rez_total = rez_total;
	}
	public int getStart_page() {
		return start_page;
	}
	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}
	public int getEnd_page() {
		return end_page;
	}
	public void setEnd_page(int end_page) {
		this.end_page = end_page;
	}
	public Date getRez_date() {
		return rez_date;
	}
	public void setRez_date(Date rez_date) {
		this.rez_date = rez_date;
	}
	public Date getVisit_date() {
		return visit_date;
	}
	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}
	
	@Override
	public String toString() {
		return "MyReservationDomain [rez_status=" + rez_status + ", userid=" + userid + ", ex_name=" + ex_name
				+ ", ex_hall_name=" + ex_hall_name + ", ex_num=" + ex_num + ", rez_num=" + rez_num + ", rez_count="
				+ rez_count + ", rez_price=" + rez_price + ", rez_total=" + rez_total + ", start_page=" + start_page
				+ ", end_page=" + end_page + ", rez_date=" + rez_date + ", visit_date=" + visit_date + "]";
	}
}
