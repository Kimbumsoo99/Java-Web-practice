package ex0111.equlas;

class EqualsExam2{
	String stringObject;
	
	public EqualsExam2(String s){
		stringObject = s;
	}
	/* 오버라이즈 하는 경우 이렇게 사용하면 문자열 비교 가능
	 *
	public boolean equals (Object obj) {
		EqualsExam2 ee=(EqualsExam2) obj;
		
		if(stringObject.equals(ee.stringObject)) {
			return true;
		}
		else
			return false;
	}*/
	public static void main(String args[]){		
		System.out.println("\nEqualsExam ee1 = new EqualsExam(\"Object.equals()\");" );
		System.out.println("\nEqualsExam ee2 = new EqualsExam(\"Object.equals()\");" );
				
		EqualsExam2 ee1 = new EqualsExam2("Object.equals()");
		EqualsExam2 ee2 = new EqualsExam2("Object.equals()");
		
		if(ee1.equals(ee2)){		//주소비교 f
			System.out.println("ee1.equals(ee2) = true");
		}else{
			System.out.println("ee1.equals(ee2) = false");
		}
		
		if(ee1 == ee2){	//주소비교 f
			System.out.println("(ee1 == ee2) = true");
		}else{
			System.out.println("(ee1 == ee2) = false");
		}
		
		System.out.println("\nString s1 = \"new String Object1\";");
		System.out.println("\nString s2 = \"new String Object1\";");
		
		String s1 = "new String Object1";
		String s2 = "new String Object1";
		
		if(s1.equals(s2)){	//문자열비교 t
			System.out.println("s1.equals(s2) = true");
		}else{
			System.out.println("s1.equals(s2) = false");
		}
		
		if(s1==s2){	//주소비교 t
			System.out.println("(s1==s2) = true");
		}else{
			System.out.println("(s1==s2) = false");
		}

		System.out.println("\nString s3 = new String(\"new String Object2\");");
		System.out.println("\nString s4 = new String(\"new String Object2\");");
 
 		String s3 = new String("new String Object2");
		String s4 = new String("new String Object2");
		
		if(s3.equals(s4)){	//문자비교 t
			System.out.println("s3.equals(s4) = true");
		}else{
			System.out.println("s3.equals(s4) = false");
		}
		
		if(s3==s4){	//주소비교 f
			System.out.println("(s3==s4) = true");
		}else{
			System.out.println("(s3==s4) = false");
		}

		System.out.println("\nString s5 = new String(\"new String Object3\");");
		System.out.println("\nString s6 = \"new String Object3\";");
		System.out.println("\nString s7 = \"new String Object3\";");
 
		String s5 = new String("new String Object3");
		String s6 = "new String Object3";
		String s7 = "new String Object3";
		
		if(s5.equals(s6)){	//문자비교 t
			System.out.println("s5.equals(s6) = true");
		}else{
			System.out.println("s5.equals(s6) = false");
		}
		
		if(s5==s6){	//주소비교 f >> 얘 false네요
			System.out.println("(s5==s6) = true");
		}else{
			System.out.println("(s5==s6) = false");
		}

			
		if(s6.equals(s7)){	//문자비교 t
			System.out.println("s6.equals(s7) = true");
		}else{
			System.out.println("s6.equals(s7) = false");
		}
		
		if(s6==s7){	//주소비교 t
			System.out.println("(s6==s7) = true");
		}else{
			System.out.println("(s6==s7) = false");
		}
	}
}
