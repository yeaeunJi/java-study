package sample1;
import java.util.Scanner;

public class BitGlobal {
	static Scanner scan = new Scanner(System.in);
	
	public static void logo() {
		System.out.println("**********************************************************************");
		System.out.println(" Java 전문가 과정");
		System.out.println(" 2021.02.09");
		System.out.println(" 배열 자료 구조를 활용한 계좌 관리 프로그램");
		System.out.println(" 지예은");
		System.out.println("**********************************************************************");
		pause();
	}
	
	public static void ending() { 
		System.out.println("**********************************************************************");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("**********************************************************************");
	}
	
	// 메뉴
	public static char  menuPrint() {
		System.out.println("**********************************************************************");
		System.out.println(" [0] 프로그램 종료");
		System.out.println(" [1] 계좌생성");
		System.out.println(" [2] 계좌검색");
		System.out.println(" [3] 입금");
		System.out.println(" [4] 출금");
		System.out.println(" [5] 계좌삭제 ");
		System.out.println(" [6] 전체 계좌 조회");
		System.out.println("**********************************************************************");
		System.out.print("  >> ");
		return scan.nextLine().charAt(0);
	}
	
	// Pause 멈추는 기능
	public static void pause() {
		System.out.println("엔터키를 누르세요...");
		scan.nextLine();
	}
	
	// 입력 기능 함수
	public static int inputNumber(String msg) {
		System.out.print(msg + " : ");
		return Integer.parseInt(scan.nextLine());
	}
	
	public static String inputString(String msg) {
		System.out.print(msg + " : ");
		return scan.nextLine();
	}
	
	public static char inputChar(String msg) {
		System.out.print(msg + " : ");
		return scan.nextLine().charAt(0);
	}
	
}
