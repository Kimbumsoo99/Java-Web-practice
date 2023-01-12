package ex0111_Exam_sol;

import java.util.Random;

public class ShoppingMainApp {

	public static void main(String[] args) {
		System.out.println("--- SHOP OPEN ---");
		Random nansu = new Random();
		ShoppingMall mall = new ShoppingMall();
		for(int i = 0;i<10;i++) {
			//난수로 발생 - (int)(Math.random() * 경우의 수) + 초기값
			int age = nansu.nextInt(55) + 1;
			System.out.println("age = " + age);
			try {
				mall.enter(age);
			} catch (AgeCheckException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
		}
		
		System.out.println("--- SHOP CLOSE ---");
		System.out.println("예외 발생한 손님 : " + AgeCheckException.count + "명");
	}
}
