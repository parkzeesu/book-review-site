package login;

public class User {

	String n_id;
	String n_pw;
	String n_name;
	String n_tel;
	
	public User(String n_id, String n_pw, String n_name, String n_tel) {
		super();
		this.n_id = n_id;
		this.n_pw = n_pw;
		this.n_name = n_name;
		this.n_tel = n_tel;
	}

	public String getN_id() {
		return n_id;
	}

	public String getN_pw() {
		return n_pw;
	}

	public String getN_name() {
		return n_name;
	}

	public String getN_tel() {
		return n_tel;
	}
	

	
}
