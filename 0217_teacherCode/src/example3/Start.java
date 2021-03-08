package example3;

public class Start {
	
	public static int search(char[] str, char key) {
		int mid;
		
		//구간의 초기 설정
		int left = 0;
		int right = str.length-1;
		int count = 1;
		while(right >= left ) {
			mid = (right + left) /2; //구간의 중간값을 획득한다.
			
			if( key == str[mid])	//찾았다면!
				return mid;
			else if( key < str[mid])  //왼쪽에 찾고자 하는 값이 있다.
				right = mid-1;
			else if( key > str[mid]) //오른쪽에 찾고자 하는 값이 있다.
				left = mid+1;	
			
			System.out.println("찾는 횟수 : " + count++);
		}
		return -1; //못찾은 경우
	}
	
	public static void main(String[]  args) {
		String str = "abcdefghij";
		
		int idx = search(str.toCharArray(), 'd');
		if( idx == -1)
			System.out.println("없다");
		else
			System.out.printf("찾은 결과 str[%d] = %c\n", idx, str.charAt(idx));
	}
}












