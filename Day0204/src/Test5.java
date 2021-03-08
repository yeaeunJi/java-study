import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		HashSet<Member> list = new HashSet<Member>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			display();

			String name = "";
			String id = "";
			int input = sc.nextInt();
			
			switch(input) {
				case 1 :
					System.out.println("가입할 회원의 성함을 입력해주세요.");
					name = sc.next();
					
					System.out.println("가입할 회원의 id를 입력해주세요.");
					 id = sc.next();
					
					Member mem = new Member(id, name);
					
					if (list.add(mem)) {
						System.out.println("가입이 완료되었습니다.");
					}else {
						System.out.println("이미 가입한 회원입니다. 다시한번 확인해주세요.");
					}
					break;
			
				case 2 :
					System.out.println("탈퇴할 회원명을 입력해주세요");
					name = sc.next();
					System.out.println("탈퇴할 아이디를 입력해주세요");
					 id = sc.next();
					 
					 Member rmMem = new Member(id, name);
					 rmMem = searchMember(rmMem, list);
					 
					 if (rmMem != null)  {
						 	list.remove(rmMem);
							System.out.println("해당 회원의 탈퇴가 완료되었습니다.");
						}else {
							System.out.println("존재하지 않는 회원입니다. 다시한번 확인해주세요.");
						}
						break;
					
				case 3 :
					for(Iterator<Member> iter = list.iterator(); iter.hasNext();) {
						Member one = iter.next();
						System.out.println("id :  "+one.getId() +",  name : "+ one.getName());
					}
					break;
				
				case 4 :
					System.out.println("종료합니다.");
					System.exit(0);
			}
		}
	}
	
	public static void display() {
		System.out.println("===========================");
		System.out.println("\t 회원 관리 프로그램 \t");
		System.out.println("===========================");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 탈퇴");
		System.out.println("3. 회원 출력");
		System.out.println("4. 종료");
		System.out.println("===========================");
	}
	
	public static Member searchMember(Member mem, HashSet<Member> list) {
		for(Iterator<Member> iter = list.iterator(); iter.hasNext();) {
			Member one = iter.next();
			if (one.equals(mem) == 1) {
				return one;
			}
		}
		return null;
	}
	
}
