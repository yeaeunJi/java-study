import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySorting {

	public static void main(String[] args) {
		int number = 10;
		System.out.println("찾으려는 값 : "+number);

		List<Integer> list = new ArrayList<Integer>();
		for(int i =0; i<50; i++) {
			list.add(i);
		}
		
		int index = Collections.binarySearch(list, number);
		System.out.println("탐색 후 반환 값 : "+list.get(index)+"\n"+Arrays.toString(list.toArray()));
	
//		number = 99;
//		index = Collections.binarySearch(list, number);
//		System.out.println("없는 숫자 탐색 후 반환 값 : "+index+", 인덱스 위치 값 : "+list.get(index)); // 인덱스 값 음성
		
		// 오름차순 정렬되어 있지 않은 경우 
		
		List<Integer> lists = new ArrayList<Integer>();
		for(int i =14; i>10; i--) {
			lists.add(i);
		} 
		for(int i =20; i>0; i--) {
			lists.add(i);
		} 
		
		index = Collections.binarySearch(list, number);
		System.out.println("탐색 후 반환 값 : "+lists.get(index)+"\n"+Arrays.toString(lists.toArray()));
		
		// 오름차순 정렬
		Collections.sort(lists);
		index = Collections.binarySearch(list, number);
		System.out.println("탐색 후 반환 값 : "+lists.get(index)+"\n"+Arrays.toString(lists.toArray()));

//		찾으려는 값 : 10
//		탐색 후 반환 값 : 10
//		[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49]
//		탐색 후 반환 값 : 14
//		[14, 13, 12, 11, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
//		탐색 후 반환 값 : 11
//		[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 16, 17, 18, 19, 20]


		
	}

}
