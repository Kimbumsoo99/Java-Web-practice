package array;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {5,7,1,2,4,3,8,9,6,10};
		System.out.println("정렬전");		
		for(int i =0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		Sort so = new Sort();
		int choiceArr[] = so.choice(arr);
		

		System.out.println("선택 정렬 후");

		for(int i =0;i<choiceArr.length;i++) {
			System.out.print(choiceArr[i]+" ");
		}
		System.out.println();

//		Sort bu = new Sort();
//		int bubbleArr[] = so.bubble(arr);
		
//		System.out.println("버블 정렬 후");

//		for(int i =0;i<bubbleArr.length;i++) {
//			System.out.print(bubbleArr[i]+" ");
//		}
//		System.out.println();
		
//
//		Sort in = new Sort();
//		int insertArr[] = so.insert(arr);
		

//		System.out.println("삽입 정렬 후");

//		for(int i =0;i<insertArr.length;i++) {
//			System.out.print(insertArr[i]+" ");
//		}
//		System.out.println();
	}
	
	public int[] choice(int[] a) {
		int tempValue, tempJ = 0;
		for (int i = 0; i < a.length; i++) { 
			int min = Integer.MAX_VALUE;  
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {  
					min = a[j];
					tempJ = j;
				}
			}
			tempValue = a[i];
			a[i] = a[tempJ];
			a[tempJ] = tempValue;
		}
		return a;
	}
	
	public int[] bubble(int[] a) {
		int tempValue;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) { 
				if (a[j] > a[j + 1]) { 
					tempValue = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tempValue;
				}
			}
		}
		return a;
	}
	
	public int[] insert(int[] a) {
		int tempValue, target;
		for (int i = 1; i < a.length; i++) {
			tempValue = a[i]; 
			target = i - 1; 
			while (target >= 0 && a[target] > tempValue) { 
				a[target + 1] = a[target]; 
				target--; 
			}
			a[target + 1] = tempValue; 
		}
		return a;
	}
}