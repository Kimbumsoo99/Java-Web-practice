package ex0111.interfaceEx.exam;
/**
 * 질의 응답에 관련된 Board
 * */

public class QABoard extends Board {
	private boolean replyState;
	public QABoard() {}
	
	
	public QABoard(int no, String writer, String subject, String content) {
		super(no, writer, subject, content);
		// TODO Auto-generated constructor stub
	}


	public QABoard(int no, String writer, String subject, String content,boolean replyState) {
		this(no, writer, subject, content);
		this.replyState = replyState;
	}


	public boolean isReplyState() {
		return replyState;
	}


	public void setReplyState(boolean replyState) {
		this.replyState = replyState;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", replyState=");
		builder.append(replyState);
		builder.append(" ");
		return builder.toString();
	}
	
	
	
}
