package ex0111.interfaceEx.exam;

/**
 * 자료실 형태의 게시물 관리
 */
public class UploadBoard extends Board {
	private String fileName;

	public UploadBoard() {
	}

	public UploadBoard(int no, String writer, String subject, String content) {
		super(no, writer, subject, content);
		// TODO Auto-generated constructor stub
	}

	public UploadBoard(int no, String writer, String subject, String content, String fileName) {
		this(no, writer, subject, content);
		this.fileName = fileName;
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("fileName=");
		builder.append(fileName);
		builder.append(" ");
		return builder.toString();
	}
	
	
}
