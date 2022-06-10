package kr.co.sist.user.exhibition.vo;

public class UserExhibitionVO {
	private String ex_name, exhibition_poster, ex_info, ex_intro, add_Img, exhibit_date, dead_line, input_date, ex_status;
	private int ex_hall_num, ex_num, total_count, adult, teen, child, cat_num,sum,watch_count;

	public UserExhibitionVO() {

	}

	public UserExhibitionVO(String ex_name, String exhibition_poster, String ex_info, String ex_intro, String add_Img,
			String exhibit_date, String dead_line, String input_date, String ex_status, int ex_hall_num, int ex_num,
			int total_count, int adult, int teen, int child,int cat_num,int sum,int watch_count) {
		super();
		this.ex_hall_num = ex_hall_num;
		this.ex_name = ex_name;
		this.exhibition_poster = exhibition_poster;
		this.ex_info = ex_info;
		this.ex_intro = ex_intro;
		this.add_Img = add_Img;
		this.exhibit_date = exhibit_date;
		this.dead_line = dead_line;
		this.input_date = input_date;
		this.ex_status = ex_status;
		this.ex_num = ex_num;
		this.total_count = total_count;
		this.adult = adult;
		this.teen = teen;
		this.child = child;
		this.cat_num=cat_num;
		this.sum=sum;
		this.watch_count=watch_count;
		
	}

	public int getWatch_count() {
		return watch_count;
	}

	public void setWatch_count(int watch_count) {
		this.watch_count = watch_count;
	}

	public int getCat_num() {
		return cat_num;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void setCat_num(int cat_num) {
		this.cat_num = cat_num;
	}

	public String getEx_name() {
		return ex_name;
	}

	public int getEx_hall_num() {
		return ex_hall_num;
	}

	public void setEx_hall_num(int ex_hall_num) {
		this.ex_hall_num = ex_hall_num;
	}

	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}

	public String getExhibition_poster() {
		return exhibition_poster;
	}

	public void setExhibition_poster(String exhibition_poster) {
		this.exhibition_poster = exhibition_poster;
	}

	public String getEx_info() {
		return ex_info;
	}

	public void setEx_info(String ex_info) {
		this.ex_info = ex_info;
	}

	public String getEx_intro() {
		return ex_intro;
	}

	public void setEx_intro(String ex_intro) {
		this.ex_intro = ex_intro;
	}

	public String getAdd_Img() {
		return add_Img;
	}

	public void setAdd_Img(String add_Img) {
		this.add_Img = add_Img;
	}

	public String getExhibit_date() {
		return exhibit_date;
	}

	public void setExhibit_date(String exhibit_date) {
		this.exhibit_date = exhibit_date;
	}

	public String getDead_line() {
		return dead_line;
	}

	public void setDead_line(String dead_line) {
		this.dead_line = dead_line;
	}

	public String getInput_date() {
		return input_date;
	}

	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}

	public String getEx_status() {
		return ex_status;
	}

	public void setEx_status(String ex_status) {
		this.ex_status = ex_status;
	}

	public int getEx_num() {
		return ex_num;
	}

	public void setEx_num(int ex_num) {
		this.ex_num = ex_num;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the adult
	 */
	public int getAdult() {
		return adult;
	}

	/**
	 * @param adult the adult to set
	 */
	public void setAdult(int adult) {
		this.adult = adult;
	}

	/**
	 * @return the teen
	 */
	public int getTeen() {
		return teen;
	}

	/**
	 * @param teen the teen to set
	 */
	public void setTeen(int teen) {
		this.teen = teen;
	}

	/**
	 * @return the child
	 */
	public int getChild() {
		return child;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(int child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "UserExhibitionVO [ex_name=" + ex_name + ", exhibition_poster=" + exhibition_poster + ", ex_info="
				+ ex_info + ", ex_intro=" + ex_intro + ", add_Img=" + add_Img + ", exhibit_date=" + exhibit_date
				+ ", dead_line=" + dead_line + ", input_date=" + input_date + ", ex_status=" + ex_status
				+ ", ex_hall_num=" + ex_hall_num + ", ex_num=" + ex_num + ", total_count=" + total_count + ", adult="
				+ adult + ", teen=" + teen + ", child=" + child + ", cat_num=" + cat_num + "]";
	}


	
}
