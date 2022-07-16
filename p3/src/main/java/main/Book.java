package main;

public class Book {
	String b_code;
	String b_name;
	String author;
	String publisher;
	int g_code; 
	String publication_date;
	String img;
	String b_summary;
	
	public Book(String b_code) {
		super();
		this.b_code = b_code;
	}
	
	public Book(String b_code, String b_name, String author, String publisher, String publication_date, String img, String b_summary) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.author = author;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.img = img;
		this.b_summary = b_summary;
	}
	
	public Book(String b_code, String b_name, String author, String publisher, int g_code, String publication_date,
			String img, String b_summary) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.author = author;
		this.publisher = publisher;
		this.g_code = g_code;
		this.publication_date = publication_date;
		this.img = img;
		this.b_summary = b_summary;
	}

	public String getB_code() {
		return b_code;
	}

	public String getB_name() {
		return b_name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getG_code() {
		return g_code;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public String getImg() {
		return img;
	}

	public String getB_summary() {
		return b_summary;
	}

	
}
