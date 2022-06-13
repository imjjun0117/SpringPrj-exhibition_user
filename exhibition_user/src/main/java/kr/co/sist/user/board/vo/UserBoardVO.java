package kr.co.sist.user.board.vo;

import org.springframework.web.multipart.MultipartFile;

public class UserBoardVO {
	private String title, userid, input_date, cat_name, reply_input_date,img_file,
	reply_userid, description, reply_description, reply_id, isdeleted,field,keyword;
	private int bd_id, cat_num, recommend, board_views,  rownum, totalCnt,pageScale,currentPage,pageCnt,startNum,endNum , cnt, fieldNum;
	public int getFieldNum() {
		return fieldNum;
	}
	public void setFieldNum(int fieldNum) {
		this.fieldNum = fieldNum;
	}
	private MultipartFile img_s3;//s3용 파일
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
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public int getBoard_views() {
		return board_views;
	}
	public void setBoard_views(int board_views) {
		this.board_views = board_views;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public MultipartFile getImg_s3() {
		return img_s3;
	}
	public void setImg_s3(MultipartFile img_s3) {
		this.img_s3 = img_s3;
	}
	@Override
	public String toString() {
		return "UserBoardVO [title=" + title + ", userid=" + userid + ", input_date=" + input_date + ", cat_name="
				+ cat_name + ", reply_input_date=" + reply_input_date + ", img_file=" + img_file + ", reply_userid="
				+ reply_userid + ", description=" + description + ", reply_description=" + reply_description
				+ ", reply_id=" + reply_id + ", isdeleted=" + isdeleted + ", field=" + field + ", keyword=" + keyword
				+ ", bd_id=" + bd_id + ", cat_num=" + cat_num + ", recommend=" + recommend + ", board_views="
				+ board_views + ", rownum=" + rownum + ", totalCnt=" + totalCnt + ", pageScale=" + pageScale
				+ ", currentPage=" + currentPage + ", pageCnt=" + pageCnt + ", startNum=" + startNum + ", endNum="
				+ endNum + ", cnt=" + cnt + ", fieldNum=" + fieldNum + ", img_s3=" + img_s3 + "]";
	}
	
}