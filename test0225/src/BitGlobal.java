


import java.util.Scanner;

public class BitGlobal {
	
	static Scanner sc = new Scanner(System.in);

	
	public static void logo() {
		System.out.println("*************************************************");
		System.out.println(" 2021.02.25");
		System.out.println(" 지예은 ");
		System.out.println("*************************************************\n");
		pause();
	}
	public static void pause() {
		System.out.print("Enter를 입력하세요.");
		sc.nextLine();		
	}
	public static void  ending() {
		System.out.println("*************************************************");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("*************************************************");
	}
	
	public static void main_Menu() {
		System.out.println("*************************************************");
		System.out.println(" [0] 프로그램 종료");
		System.out.println(" [1] 회원 등록");
		System.out.println(" [2] 회원 전체 출력");
		System.out.println(" [3] 음료수 등록");
		System.out.println(" [4] 음료수 전체 츨력");
		System.out.println(" [5] 등급테이블 전체 출력");
		System.out.println(" [6] 구매테이블 출력");
		System.out.println(" [7] 음료수 구매");
		System.out.println(" [8] 회원 구매 정보 검색");
		System.out.println(" [9] 가장 많이 판매된 음료수 정보 출력");
		System.out.println("*************************************************");
	}
	
	public static int InputNumber(String msg) {
		System.out.print(msg + " : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static String InputString(String msg) {
		System.out.print(msg + " : ");
		return sc.nextLine();
	}
	
	public static char InputChar(String msg) {
		System.out.print(msg + " : ");
		return sc.nextLine().charAt(0);
	}

}
