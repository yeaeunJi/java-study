package sample1;

public class App {
	
	// ****************************************************************************************************************
	 // 싱글톤 패턴 코드
	// ****************************************************************************************************************
	private App() { // 생성자 은닉하여 여러개의 객체가 생성되는 것을 막음
		init();
	}
	
	private static App singleton = new App(); // 자신의 static 객체 생성. static은 클래스가 메모리에 로드될 때 딱 한번 생성됨
	
	// 내부적으로 생성된 자신의 객체를 외부에 노출시켜주는 메서드
	 public static App getInstance() {
		 return singleton;
	 }
	// ****************************************************************************************************************
	 
	private Bank bank = Bank.getInstance(); 
	 
	// 초기화 영역
	public void init() {
		BitGlobal.logo(); 
	}
	
	// 반복적 실행 - 엔진
	public void run() {
		
		while(true) {
			bank.printAll();
			switch (BitGlobal.menuPrint()) {
				case '0' : 
					return; // while문 종료
				case '1' : 
					bank.makeAccount();
					break;
				case '2' : 
					bank.selectAccount();
					break;
				case '3' :
					bank.inputMoney();
					break;
				case '4' : 
					bank.outputMoney();
					break;
				case '5' :
					bank.deleteAccount();
					break;
				default :
					System.out.println("유효하지 않는 메뉴입니다. ");
					return;
			}
			BitGlobal.pause();
		}
	}
	
	// 종료처리 영역
	public void exit() {
		BitGlobal.ending();
	}
} // end class
