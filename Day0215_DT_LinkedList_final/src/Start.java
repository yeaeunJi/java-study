import java.util.Scanner;

public class Start {
	public static void exam1() {
		MyList list = new MyList();
		for(int i=10; i<=50; i = i+10) {
			list.back_insert(i); // 박싱 Object (참조형타입) = int(기본형타입)
		}
		list.selectAll();

		// 검색 확인
		Node cur = list.select(10);
		if(cur!=null)
			System.out.println("검색 결과 : " + (int)cur.data);
		else 
			System.out.println("없음");

	}
	public static void exam2() {
		MyList list = new MyList();
		for(int i=10; i<=50; i = i+10) {
			list.back_insert(i); // 박싱 Object (참조형타입) = int(기본형타입)
		}

		list.selectAll();

		// 삭제 확인
		for( int i =0; i < 7; i++) {
			list.back_delete();
			list.selectAll();
		}
	}
	// 명령어 기반
	/*
	 *  f_insert 10
	 *  b_insert 10
	 *  select 20
	 *  f_delete
	 *  b_delete
	 *  r_insert 20 30 ==> 20을 갖는 노드를 찾아서 그 뒤에 30을 연결
	 *  r_delete 20 ==> 20을 갖는 노드를 찾아서 그 다음 노드 삭제
	 *  exit
	 * */
	public static void exam3() {
		Scanner scan = new Scanner(System.in);
		MyList list = new MyList();

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("명령어 기반 단일 연결리스트 테스트");
		System.out.println("----------------------------------------------------------------------------------");

		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine(); // 문장 하나를 받아들임
			String[] strArr = str.split(" ");

			if (strArr[0].equals("f_insert")) {
				int value = Integer.parseInt(strArr[1]);
				list.front_insert(value);
			}
			else if (strArr[0].equals("b_insert")) {
				int value = Integer.parseInt(strArr[1]);
				list.back_insert(value);
			}
			else if (strArr[0].equals("select")) {
				int value = Integer.parseInt(strArr[1]);
				Node cur = list.select(value);
				if(cur != null) System.out.println("검색 결과 : "+(int)cur.data);
				else System.out.println("검색 결과 없음");
			}else if (strArr[0].equals("f_delete")) {
				list.front_delete();
			}else if (strArr[0].equals("b_delete")) {
				list.back_delete();
			}else if (strArr[0].equals("r_insert")) {
				int key = Integer.parseInt(strArr[1]);
				int value = Integer.parseInt(strArr[2]);

				Node cur = list.select(key);
				if(cur != null) {
//					System.out.println("검색 결과 : "+(int)cur.data);
					list.random_insert(cur, value);
					list.selectAll();
				}
				else System.out.println("검색 결과 없음");
				
			}else if (strArr[0].equals("r_delete")) {
				int key = Integer.parseInt(strArr[1]);

				Node cur = list.select(key);
				if(cur != null) {
//					System.out.println("검색 결과 : "+(int)cur.data);
					list.random_delete(cur);
					list.selectAll();
				}
				else System.out.println("검색 결과 없음");
				
			}else if (strArr[0].equals("exit")) {
					break;
			}
			list.selectAll();
			System.out.println();
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------------------------------------------------------------------------------");

		scan.close();
	}

	public static void main(String[] args) {
		exam3();
	} // end main
}
