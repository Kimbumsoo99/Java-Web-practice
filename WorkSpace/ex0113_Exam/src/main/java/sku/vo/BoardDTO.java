package sku.vo;
/**
 * 글번호 ,제목, 내용 속성 관리하는 객체
 * */
public class BoardDTO {
	private int gno;
	private String subject;
	private String content;
	
	public BoardDTO(int gno, String subject, String content) {
		super();
		this.gno = gno;
		this.subject = subject;
		this.content = content;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
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
