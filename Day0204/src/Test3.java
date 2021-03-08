import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test3 {
	public static  void main(String[] args) {
		// 1. 이름을 5개 입력받아 ArrayList에 삽입 후, 이름을 검색한 결과를 출력
//		Scanner sc = new Scanner(System.in);	
		
//		 System.out.println("찾고 싶은 사람의 이름을 입력해주세요.");
//		 String searchName = sc.next();
//		 
//		 if (lists.contains(searchName)) {
//			 System.out.println(searchName+"님은 현재 리스트에 포함되어 있습니다.");
//		 }else {
//			 System.out.println(searchName+"님은 현재 리스트에 포함되어 있지 않습니다.");
//		 }
			 
		// 2. 임의의 정수 5개를 저장한 Vector 컬렉션에서 Iterator를 이용하여 제일 큰 수와 전체의 합을 구하시오
//			Vector vec = new Vector();
//			int member = 5;
//			
//			for(int i=0; i<member ; i++) {
//				String  a ="철수"+(i+1);
//				vec.add(a);
//			}
//			
//			int size = 0;					
//			Iterator a = vec.iterator();
//			
//			while(a.hasNext()) {
//				String name = ""+a.next();
//				System.out.println("name : "+name);
//				size++;				
//			}
//			
//			System.out.println("인원수 : "+size);
	List<String> list1 = new ArrayList<String>();
	
	list1.add("홍길동");
	list1.add("김길동");
	list1.add("최길동");
	
	for(int i=0;i<list1.size();i++) {
		 System.out.println(list1.get(i));
	}
	list1.set(0, "남길동");
	
	for(int i=0;i<list1.size();i++) {
		 System.out.println(list1.get(i));
	}
	List<String> list = new LinkedList<String>();
	
	list.add("홍길동");
	list.add("김길동");
	list.add("최길동");

	 list.set(0, "남길동"); // 기존 0번째 자리에 대신 삽입
	 String s = list.get(0);
	 int size = list.size();
	 
	 for(int i=0;i<list.size();i++) {
//		 System.out.println(list.get(i));
	 }
	} // end main
}
