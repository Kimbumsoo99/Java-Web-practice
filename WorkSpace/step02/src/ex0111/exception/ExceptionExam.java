package ex0111.exception;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("--- 프로그램 시작하기 ---");
	
		try {
		String info = args[0];
		//System.out.println("info = "+info);
		
		int convertNo = Integer.parseInt(info);
		//System.out.println("convertNo = "+convertNo);
		
		int result = 100/convertNo;
		System.out.println("나눈 결과 : "+result);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("인수를 전달해주세요 e = "+ e);
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력하세요. = " + e.getMessage());
		}catch(Exception e) {
			System.out.println("예외가 발생했어요");
		}finally{
			System.out.println("짜잔 무조건 나오지롱");
		}
		System.out.println("--- 프로그램 종료 ---");
	}

}
