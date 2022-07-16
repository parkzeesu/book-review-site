package main;

public class Genre {
	int g_code;
    String g_name;
    
    public Genre(String g_name) {
		super();
		this.g_name = g_name;
	}
    
	public Genre(int g_code, String g_name) {
		super();
		this.g_code = g_code;
		this.g_name = g_name;
	}

	public int getG_code() {
		return g_code;
	}

	public String getG_name() {
		return g_name;
	}
}
