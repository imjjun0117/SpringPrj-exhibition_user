package kr.co.sist.user.board.domain;

public class UserBoardDomain {
	private String title, userid, input_date, cat_name, reply_input_date,img_file, reply_userid, description, reply_description;
	private int bd_id, cat_num, recommend, board_views, reply_id, rnum, cnt,pageScale,currentPage,pageCnt,startNum,endNum ;
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	private char isdeleted;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getReply_input_date() {
		return reply_input_date;
	}
	public void setReply_input_date(String reply_input_date) {
		this.reply_input_date = reply_input_date;
	}
	public String getImg_file() {
		return img_file;
	}
	public void setImg_file(String img_file) {
		this.img_file = img_file;
	}
	public String getReply_userid() {
		return reply_userid;
	}
	public void setReply_userid(String reply_userid) {
		this.reply_userid = reply_userid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReply_description() {
		return reply_description;
	}
	public void setReply_description(String reply_description) {
		this.reply_description = reply_description;
	}
	public int getBd_id() {
		return bd_id;
	}
	public void setBd_id(int bd_id) {
		this.bd_id = bd_id;
	}
	public int getCat_num() {
		return cat_num;
	}
	public void setCat_num(int cat_num) {
		this.cat_num = cat_num;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getboard_views() {
		return board_views;
	}
	public void setboard_views(int board_views) {
		this.board_views = board_views;
	}
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getPageScale() {
		return pageScale;
	}
	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public char getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(char isdeleted) {
		this.isdeleted = isdeleted;
	}
	@Override
	public String toString() {
		return "UserBoardDomain [title=" + title + ", userid=" + userid + ", input_date=" + input_date + ", cat_name="
				+ cat_name + ", reply_input_date=" + reply_input_date + ", img_file=" + img_file + ", reply_userid="
				+ reply_userid + ", description=" + description + ", reply_description=" + reply_description
				+ ", bd_id=" + bd_id + ", cat_num=" + cat_num + ", recommend=" + recommend + ", board_views="
				+ board_views + ", reply_id=" + reply_id + ", rnum=" + rnum + ", cnt=" + cnt + ", pageScale="
				+ pageScale + ", currentPage=" + currentPage + ", pageCnt=" + pageCnt + ", startNum=" + startNum
				+ ", endNum=" + endNum + ", isdeleted=" + isdeleted + "]";
	}
	public int getBoard_views() {
		return board_views;
	}
	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}
	
	
	
	

	
}