package ex0112.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExam {
	List<Student> list = new ArrayList<>(5);

	public static void main(String[] args) {
		ListExam exam = new ListExam();
		exam.addList();
		exam.printList();
		System.out.println("\n1. 조건검색하기 ...");
		Student st = exam.searchBySno(20180895);
		if (st != null)
			System.out.println(st);

		else
			System.out.println("찾는 정보가 없습니다.");
		System.out.println("---------------------------");
		st = exam.searchBySno(10);
		if (st != null)
			System.out.println(st);
		else
			System.out.println("찾는 정보가 없습니다.");
		System.out.println("\n2. 삭제하기 ...");
		if (exam.delete(20180895))
			System.out.println("삭제되었습니다.");
		else
			System.out.println("삭제되지 않았습니다.");
		exam.printList();

		System.out.println("\n3. 수정하기 ...");
		if (exam.update(new Student(20181234, "가나다")))
			System.out.println("수정되었습니다.");
		else
			System.out.println("수정되지 않았습니다.");
		exam.printList();
	}

	/**
	 * 학생 추가하는 메소드
	 */
	public void addList() {
		list.add(new Student());
		list.add(new Student(20180895, "김범수", "서울"));
		list.add(new Student(20180896, "김성범", "안양"));
		list.add(new Student(20180897, "김은수", "명학"));
		list.add(new Student(20181234, "안지윤", "서울"));
	}

	/**
	 * 모든 학생의 정보를 출력하는 메소드
	 */
	public void printList() {
		System.out.println("--- 학생의 정보 (" + list.size() + ")명 ---");
		/*
		 * for (int i = 0; i < list.size(); i++) { Student st = list.get(i);
		 * System.out.println(st); }
		 */
		System.out.println("---------------------");
		for (Student s : list) {
			System.out.println(s);
		}
	}

	/**
	 * 인수로 전달된 학번에 해당하는 학생의 정보를 찾기
	 */
	public Student searchBySno(int sno) {
		for (Student st : list) {
			if (st.getSno() == sno) {
				// 찾은 경우
				return st;
			}
		}
		// 못찾은 경우
		return null;
	}

	/**
	 * 인수로 전달된 학번에 해당하는 학생의 정보 삭제
	 * 
	 * @return : true이면 삭제성공, false이면 삭제실패
	 */
	public boolean delete(int sno) {
		Student st = this.searchBySno(sno);
		return list.remove(st);
	}

	/**
	 * 학번에 해당하는 학생의 이름을 수정
	 * 
	 */
	public boolean update(Student student) { // 수정하려는 학번, 변경하려는 이름값
		Student savedSt = this.searchBySno(student.getSno());
		if (savedSt == null)
			return false;
		// 이름 수정
		savedSt.setName(student.getName());
		return true;
	}

}
