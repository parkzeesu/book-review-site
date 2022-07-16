package main;

public class Review {
	int r_num;
	String n_id;
	String b_code;
	String content;
	String r_date ;
	
	public Review(String n_id, String b_code, String content, String r_date) {
		super();
		this.n_id = n_id;
		this.b_code = b_code;
		this.content = content;
		this.r_date = r_date;
	}
	
	public Review(int r_num, String n_id, String b_code, String content, String r_date) {
		super();
		this.r_num = r_num;
		this.n_id = n_id;
		this.b_code = b_code;
		this.content = content;
		this.r_date = r_date;
	}

	public int getR_num() {
		return r_num;
	}

	public String getN_id() {
		return n_id;
	}

	public String getB_code() {
		return b_code;
	}

	public String getContent() {
		return content;
	}

	public String getR_date() {
		return r_date;
	}
}
