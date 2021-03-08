import java.util.Scanner;

public class Start {
	
	
	public static void main(String[] args) {
		exam1();
	}
	
	/*
	 *[스택 사용 명령어]
	 *push 10  
	 *pop
	 *gettop
	 *clear	 
	 *exit 
	 *-> 모든 명령어 처리 후 스택의 상태정보를 출력할 것(printAll)
	 */
	public static void exam1() {
		Scanner scan = new Scanner(System.in);

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("명령어 기반 배열로 구현된 스택 테스트");
		System.out.println("----------------------------------------------------------------------------------");
		
		System.out.print("저장 공간 크기를 설정해주세요. >> ");
		int max = scan.nextInt();
		MyStack list = new MyStack(max);
		
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine(); // 문장 하나를 받아들임
			String[] strArr = str.split(" ");

			if (strArr[0].equals("push")) {
				int value = Integer.parseInt(strArr[1]);
				if (!list.push(value)){
					System.out.println("더이상 저장할 수 없습니다.");
				}
			}
			else if (strArr[0].equals("pop")) {
				try {
					System.out.println((int)list.pop());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else if (strArr[0].equals("gettop")) {
				try {
					System.out.println((int)list.getTop());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else if (strArr[0].equals("clear")) {
				list.clear();
			}
			else if (strArr[0].equals("exit")) {
				break;
			}
			System.out.print("현재 저장된 스택 데이터 : ");
			list.printAll();
			System.out.println();
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------------------------------------------------------------------------------");

		scan.close();
	}
}
