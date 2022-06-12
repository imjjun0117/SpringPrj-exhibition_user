package kr.co.sist.user.board.vo;

import java.sql.Date;

public class ReplyVO {
	private int reply_id,bd_id;
	private String reply_description,reply_userid;
	private Date reply_input_date;
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getBd_id() {
		return bd_id;
	}
	public void setBd_id(int bd_id) {
		this.bd_id = bd_id;
	}
	public String getReply_description() {
		return reply_description;
	}
	public void setReply_description(String reply_description) {
		this.reply_description = reply_description;
	}
	public String getReply_userid() {
		return reply_userid;
	}
	public void setReply_userid(String reply_userid) {
		this.reply_userid = reply_userid;
	}
	public Date getReply_input_date() {
		return reply_input_date;
	}
	public void setReply_input_date(Date reply_input_date) {
		this.reply_input_date = reply_input_date;
	}
	@Override
	public String toString() {
		return "ReplyVO [reply_id=" + reply_id + ", bd_id=" + bd_id + ", reply_description=" + reply_description
				+ ", reply_userid=" + reply_userid + ", reply_input_date=" + reply_input_date + "]";
	}
	
}
