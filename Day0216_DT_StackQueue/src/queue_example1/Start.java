package queue_example1;
import java.util.Scanner;

public class Start {
	
	public static void main(String[] args) {
		exam1();
	}
	
	/*
	 *[스택 사용 명령어]
	 *put 10  
	 *get : 비어있는 상태에서 get을 했을 때 문제점 해결 필요
	 *clear
	 *exit 
	 *-> 모든 명령어 처리 후 큐의 상태정보를 출력할 것(printAll)
	 */
	public static void exam1() {
		Scanner scan = new Scanner(System.in);

		System.out.println("----------------------------------------");
		System.out.println("명령어 기반 배열로 구현된 개선된 원형 queue 테스트");
		System.out.println("----------------------------------------");		
		System.out.print("저장 공간 크기를 설정해주세요. >> ");
		int max = scan.nextInt();
		MyQueue list = new MyQueue(max);
		System.out.println("실제로 저장할 수 있는 수는 "+(max-1)+"입니다.");
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine(); // 문장 하나를 받아들임
			String[] strArr = str.split(" ");

			if (strArr[0].equals("put")) {
				int value = Integer.parseInt(strArr[1]);
				if (!list.put(value))
					System.out.println("더이상 저장할 수 없습니다.");
			}
			else if (strArr[0].equals("get")) {
				Object data = list.get();
				if (data == null )
					System.out.println("저장된 데이터가 없습니다.");
				else 
					System.out.println((int)data);
			}			
			else if (strArr[0].equals("clear")) {
				list.clear();
			}
			else if (strArr[0].equals("exit")) {
				break;
			}
			list.printAll();
			System.out.println();
		}
		System.out.println("----------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------------------------------------");
		scan.close();
	}
}
