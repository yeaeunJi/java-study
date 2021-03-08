import java.util.HashMap;
import java.util.Scanner;

public class HashMapSearch {

	public static void main(String[] args) {
		String[] name = {"홍길동", "남길", "우성"};
		String[] phone = {"12345", "6789", "012"};
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i<name.length; i++) {
			map.put(name[i],phone[i]);
		}
		
		System.out.print("조회하고 싶은 회원명을 입력하세요 : ");
		Scanner cs = new Scanner(System.in);
		
		String key = cs.next();
		
		if(map.containsKey(key)) {
			System.out.println(key+"회원의 전화번호는 "+map.get(key)+"입니다.");
		}else {
			System.out.println("회원 목록에 존재하지 않습니다.");
		}
	}

}
