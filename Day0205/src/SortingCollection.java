import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Grade implements Comparable<Grade>{
	int number;
	String grade;

	public Grade(int number, String grade) {
		this.number = number;
		this.grade = grade;
	}

	public String toString() {
		return this.number+" - "+this.grade;
	}

	public int compareTo(Grade g) {
			return number - g.number; // id로 정렬시
//			return grade.compareTo( g.grade);
	} 
}

public class SortingCollection {

	public static void main(String[] args) {
		Grade[] array = {
				new Grade(2021003, "A+"),
				new Grade(2021005, "C+"),
				new Grade(2021001, "B+"),
				new Grade(2021002, "D"),
		};

		List<Grade> list = Arrays.asList(array);
		Collections.sort(list); // 정렬 시 Grade 클래스의 compareTo() 메소드를 사용
		System.out.println(list);
		// number 기준 정렬 시 출력 값 : [2021001 - B+, 2021002 - D, 2021003 - A+, 2021005 - C+]
		// grade 기준 정렬 시 출력 값 :  [2021003 - A+, 2021001 - B+, 2021005 - C+, 2021002 - D]
	}
}
