package weight;

import java.util.Scanner;

public class EncapsulationExam {
	private int weight=30;
	private String passwd="1234";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EncapsulationExam wProgram = new EncapsulationExam();
		int menu;
		while (true) {
			System.out.println("===몸무게 측정 프로그램===");
			System.out.println("1. 몸무게 검색     2. 몸무게변경    3. 비밀번호 변경      4.종료\r\n" + "		");

			menu = sc.nextInt();

			if (menu == 1) {
				System.out.println("1번 모드입니다.비밀번호를 입력하세요");
				String passwd = sc.next();
				wProgram.getWeight(passwd);

			} else if (menu == 2) {
				System.out.println("2번 모드입니다.\n변경하고싶은 몸무게를 입력하세요.");
				int changeWeight = sc.nextInt();
				System.out.println("다음으로 비밀번호를 입력하세요");
				String passwd = sc.next();
				wProgram.setWeight(changeWeight, passwd);
			} else if (menu == 3) {
				System.out.println("3번 모드입니다.\n비밀번호를 입력하세요.");
				String preKey = sc.next();
				System.out.println("다음으로 변경할 비밀번호를 입력하세요");
				String curKey = sc.next();
				wProgram.setPasswd(preKey, curKey);
			} else if (menu == 4) {
				System.out.println("프로그램 종료");
				if (sc != null)
					sc.close();
				System.exit(1);
			}
		}
	}

	private void getWeight(String passwd) {
		EncapsulationExam e = new EncapsulationExam();
		//System.out.println(passwd);
		boolean check = e.isPasswd(passwd);
		//System.out.println(check);
		if (check == true) {
			System.out.println("현재 몸무게는 " + this.weight);
		} else {
			System.out.println("비밀번호불일치");
		}
	}

	private void setWeight(int afterWeight, String passwd) {
		EncapsulationExam e = new EncapsulationExam();
		boolean check = e.isPasswd(passwd);
		if (check == true) {
			this.weight = afterWeight;
		} else {
			System.out.println("비밀번호불일치");
		}
	}

	private void setPasswd(String prePasswd, String curPasswd) {
		EncapsulationExam e = new EncapsulationExam();
		boolean check = e.isPasswd(prePasswd);
		if (check == true) {
			this.passwd = curPasswd;
		} else {
			System.out.println("비밀번호불일치");
		}
	}

	private boolean isPasswd(String password) {
		if (this.passwd.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
