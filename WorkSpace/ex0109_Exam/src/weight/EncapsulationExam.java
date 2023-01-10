package weight;

import java.util.Scanner;

public class EncapsulationExam {
	private int weight = 30;
	private String passwd = "1234";
	private Scanner sc;
	
	public EncapsulationExam() {
		this.sc=new Scanner(System.in);
		printProgram();
	}
	
	public void printProgram() {
		int menu;
		while (true) {
			System.out.println("===몸무게 측정 프로그램===");
			System.out.println("1. 몸무게 검색     2. 몸무게변경    3. 비밀번호 변경      4.종료\r\n" + "		");
			
			menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("1번 모드입니다.비밀번호를 입력하세요");
				String passwd = sc.next();
				getWeight(passwd);

			} else if (menu == 2) {
				System.out.println("2번 모드입니다.\n변경하고싶은 몸무게를 입력하세요.");
				int changeWeight = sc.nextInt();
				System.out.println("다음으로 비밀번호를 입력하세요");
				String passwd = sc.next();
				setWeight(changeWeight, passwd);
				
			} else if (menu == 3) {
				System.out.println("3번 모드입니다.\n비밀번호를 입력하세요.");
				String preKey = sc.next();
				System.out.println("다음으로 변경할 비밀번호를 입력하세요");
				String curKey = sc.next();
				setPasswd(preKey, curKey);
				
			} else if (menu == 4) {
				System.out.println("프로그램 종료");
				if (sc != null)
					sc.close();
				System.exit(1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EncapsulationExam();
		
	}

	private void getWeight(String passwd) {
		if (isPasswd(passwd)) {
			System.out.println("현재 몸무게는 " + this.weight);
		} else {
			System.out.println("비밀번호불일치");
		}
	}

	private void setWeight(int afterWeight, String passwd) {
		if (isPasswd(passwd)) {
			this.weight = afterWeight;
		} else {
			System.out.println("비밀번호불일치");
		}
	}

	private void setPasswd(String prePasswd, String curPasswd) {
		if (isPasswd(prePasswd)) {
			passwd = curPasswd;
			System.out.println("비밀번호 변경");
		} else {
			System.out.println("비밀번호불일치");
		}
	}

	private boolean isPasswd(String password) {
		if (passwd.equals(password)) {
			
			return true;
		} else {
			return false;
		}
	}
}
