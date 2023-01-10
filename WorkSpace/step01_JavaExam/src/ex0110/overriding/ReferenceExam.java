package ex0110.overriding;
class ObjectExam{
	String str;
	public ObjectExam(){   
		
	}
	public ObjectExam(String str) {
		this.str=str;
	}

	@Override
	public String toString() {
		return super.toString()+" = " + str;
	}
}


class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="장희정"; 
			String s02="Java";
			String s03=new String("월요일");
			
			ObjectExam oe1=new ObjectExam("재미있다.");
			ObjectExam oe2=new ObjectExam("안녕");
			System.out.println(c);//
			System.out.println(s01);//
			System.out.println(s02);//
			System.out.println(s03);//
			
			System.out.println(oe1);//
			System.out.println(oe2);//
			
	}
}
