package array;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("로또 번호 뽑기");
		int check = -1;
		Lotto lot = new Lotto();
		int[] lotto = {0,0,0,0,0,0};
		while(check==-1) {
			lotto = lot.lottoNumber();
			
			lotto = lot.bubble(lotto);
			
			check = lot.over(lotto);

			if(check==1) {
				lot.printNum(lotto);
			}
		}

	}
	
	public int[] lottoNumber() {
		int[] lotto= {0,0,0,0,0,0};
		for(int i =0;i<6;i++) {
			lotto[i]=randNum();
		}
		return lotto;
	}
	
	public int randNum() {
		return (int)(Math.random()*45+1);
	}
	
	public int[] bubble(int[] a) {
		int tempValue;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) { 
				if (a[j] < a[j + 1]) { 
					tempValue = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tempValue;
				}
			}
		}
		return a;
	}
	public int over(int[] lotto) {
		for(int i=0;i<5;i++) {
			if(lotto[i]==lotto[i+1]) {
				return -1;
			}
		}
		return 1;
	}
	public void printNum(int[] lotto) {
		for(int i=0;i<6;i++) {
			System.out.print(lotto[i]+" ");
		}
		System.out.println();
		
	}
}
