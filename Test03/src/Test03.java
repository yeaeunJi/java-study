import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) {
		TreeSet<Member> list = new TreeSet<Member>();
		Scanner sc = new Scanner(System.in);

		while(true) {
			display();

			String name = "";
			String phone = "";
			int input = sc.nextInt();

			switch(input) {
			case 1 :
				System.out.println("등록할 사람의 이름을 입력해주세요.");
				name = sc.next();

				System.out.println("등록할 사람의 전화번호를 입력해주세요.");
				phone = sc.next();

				Member mem = new Member(phone, name);
				Member findMem = searchMember(mem, list);

				if (findMem == null ) {
					if (list.add(mem)) 
						System.out.println("등록이 완료되었습니다.");
				}else {
					System.out.println("중복된 사람이 존재합니다. 다시한번 확인해주세요.");
				}
				break;
			
			case 2 :
				System.out.println("조회할 사람의 이름을 입력해주세요");
				name = sc.next();
				Member rmMem = new Member("",name);
				System.out.println("reMem" + rmMem);
				rmMem = searchMember(rmMem, list);

				if (rmMem != null)  {
					System.out.println(rmMem.toString());
				}else {
					System.out.println("존재하지 않습니다. 다시한번 확인해주세요.");
				}
				break;
			case 3 :
				System.out.println("삭제할 사람의 이름를 입력해주세요");
				name = sc.next();
				rmMem = new Member("",name);
				rmMem = searchMember(rmMem, list);

				if (rmMem != null)  {
					list.remove(rmMem);
					System.out.println("삭제가 완료되었습니다.");
				}else {
					System.out.println("존재하지 않습니다. 다시한번 확인해주세요.");
				}
				break;

			case 4:
				for(Iterator<Member> iter = list.iterator(); iter.hasNext();) {
					Member one = iter.next();
					System.out.println( "name : "+ one.getName()+"/ 번호 :"+one.getPhone());
				}
				break;

			case 5 :
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}

	public static void display() {
		System.out.println("===========================");
		System.out.println("\t 주소록 관리 프로그램 \t");
		System.out.println("===========================");
		System.out.println("1. 입력");
		System.out.println("2. 검색");
		System.out.println("3. 삭제");
		System.out.println("4. 조회");
		System.out.println("5. 종료");
		System.out.println("===========================");
	}

	public static Member searchMember(Member mem, TreeSet<Member> list) {
		for(Iterator<Member> iter = list.iterator(); iter.hasNext();) {
			Member one = iter.next();
			if (one.equals(mem)) {
				return one;
			}
		}
		return null;
	}

}
