package sku.vo;

public class Board {
	private int bno;
	private String writer;
	private String subject;
	private String content;
	
	public Board() {}

	public Board(int bno, String writer, String subject, String content) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
