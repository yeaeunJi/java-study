import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test6 {
	public static void main(String[] args) {
		TreeSet<Member2> list = new TreeSet<Member2>();
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

				Member2 mem = new Member2(id, name);
				Member2 findMem = searchMember2(mem, list);

				if (findMem == null ) {
					if (list.add(mem)) 
						System.out.println("가입이 완료되었습니다.");
				}else {
					System.out.println("이미 존재하는 id 또는 회원입니다. 다시한번 확인해주세요.");
				}
				break;

			case 2 :
				System.out.println("탈퇴할 id를 입력해주세요");
				id = sc.next();
				Member2 rmMem = new Member2(id, "");
				rmMem = searchMember2(rmMem, list);

				if (rmMem != null)  {
					list.remove(rmMem);
					System.out.println("해당 회원의 탈퇴가 완료되었습니다.");
				}else {
					System.out.println("존재하지 않는 회원입니다. 다시한번 확인해주세요.");
				}
				break;

			case 3 :
				for(Iterator<Member2> iter = list.iterator(); iter.hasNext();) {
					Member2 one = iter.next();
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

	public static Member2 searchMember2(Member2 mem, TreeSet<Member2> list) {
		for(Iterator<Member2> iter = list.iterator(); iter.hasNext();) {
			Member2 one = iter.next();
			if (one.equals(mem)) {
				return one;
			}
		}
		return null;
	}

}
