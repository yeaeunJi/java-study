package sample1;
import java.util.Iterator;

public class Bank {
	// ****************************************************************************************************************
	// 싱글톤 패턴 코드
	// ****************************************************************************************************************
	private static Bank singleton = new Bank();

	private Bank() {
		arr = new BitArray(inputMax());
	}

	public static Bank getInstance() {
		return singleton;
	}
	// ****************************************************************************************************************

	private BitArray arr; // 회원 정보
	private BitArray acciolist = new BitArray(100);

	// 메서드
	public int inputMax() {
		return BitGlobal.inputNumber("저장 개수를 입력하세요.");
	}

	// 기능 메서드
	public void printAll() {
		//1. 저장 개수 출력
		System.out.printf("[저장개수]  %d개\n", arr.getSize() );

		//2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회 
		for(int i =0; i<arr.getSize(); i++){
			Account account = (Account)arr.getData(i); // Down Casting 문법 적용 ==> 객체가 Member가 아닐 때 문제가 발생할 수 있므로 instanceof로 확인 후 다운 캐스팅 필요
			account.println();
		}
	}

	private boolean isAccNumberCheck(int number) {
		return numberToIdx(number) == -1?true:false;
	}

	// 거래리스트 저장 함수
	private void insertAccountIO(int number, int input, int ouput, int balance) {
		try {
			AccountIO io = new AccountIO(number, input, ouput, balance);
			acciolist.insert(io);
		} catch (Exception e) {
			System.out.println("[거래내역저장에러]"+e.getMessage());
		}

	}

	public void makeAccount() {
		try {
			int number = BitGlobal.inputNumber("계좌번호");
			String name = BitGlobal.inputString("이름");
			int money = BitGlobal.inputNumber("입금액");
			if (isAccNumberCheck(number) == false)  throw new Exception("중복된 계좌번호입니다.");

			Account account = new Account(number, name, money);
			arr.insert(account); 

			insertAccountIO(number, money, 0, money);

		} catch (Exception e) {
			System.out.println("[계좌 생성 실패]" + e.getMessage());
		}
	}

	private int numberToIdx(int idx) {
		for(int i=0; i<arr.getSize(); i++) {
			Account account = (Account)arr.getData(i);
			if(account.getAccid() == idx) return i;
		} 
		return  -1;
	}

	public void selectAccount() {
		int number =  BitGlobal.inputNumber("계좌번호");
		int idx = numberToIdx(number);
		if (idx != -1 ) {
			Account account = (Account)arr.getData(idx);
			account.println();
			System.out.println("\n[거래리스트]");
			printAccountIO(number);
		}
		else 	System.out.println("조회된 결과가 없습니다.");
	}

	private int getAccountIOCount(int accid) {
		//1. 저장 개수 출력
		int sum = 0;

		//2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회 
		for(int i =0; i<acciolist.getSize(); i++){
			AccountIO accio = (AccountIO)acciolist.getData(i); // Down Casting 문법 적용 ==> 객체가 Member가 아닐 때 문제가 발생할 수 있므로 instanceof로 확인 후 다운 캐스팅 필요
			if (accio.getAccid() == accid)
				sum++;
		}
		return sum;
	}

	private void printAccountIO(int accid) {
		//1. 저장 개수 출력
		System.out.printf("[저장개수]  %d개\n", getAccountIOCount(accid) );

		//2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회 
		for(int i =0; i<acciolist.getSize(); i++){
			AccountIO accio = (AccountIO)acciolist.getData(i); // Down Casting 문법 적용 ==> 객체가 Member가 아닐 때 문제가 발생할 수 있므로 instanceof로 확인 후 다운 캐스팅 필요
			if (accio.getAccid() == accid)
				accio.print();
		}
	}

	public void inputMoney(){
		try {
			int accid =  BitGlobal.inputNumber("계좌번호");
			int  balance = BitGlobal.inputNumber("입급할 금액 입력");
			int idx = numberToIdx(accid);

			if (idx == -1) new Exception("없는 계좌번호입니다.");
			Account account = (Account)arr.getData(idx);
			account.inputMoney(balance);
			insertAccountIO(accid, balance, 0, account.getBalance());
			System.out.println("입금되었습니다.");
		}
		catch (Exception e) {
			System.out.println("[입금오류] "+e.getMessage());
		}
	}

	public void outputMoney(){
		try {
			int accid =  BitGlobal.inputNumber("계좌번호");
			int  balance = BitGlobal.inputNumber("출금할 금액 입력");
			int idx = numberToIdx(accid);

			if (idx == -1) new Exception("없는 계좌번호입니다.");
			Account account = (Account)arr.getData(idx);
			account.outputMoney(balance);
			insertAccountIO(accid, 0, balance, account.getBalance());
			System.out.println("출금되었습니다.");
		}
		catch (Exception e) {
			System.out.println("[출금오류] "+e.getMessage());
		}
	}

	public void deleteAccount() {
		try {
			int number =  BitGlobal.inputNumber("계좌번호");
			int idx = numberToIdx(number);
			if(idx == -1)
				throw new Exception("없는 계좌번호 입니다.");

			arr.delete(idx);
			System.out.println("삭제되었습니다.");
		}
		catch (Exception e) {
			System.out.println("[삭제오류] "+e.getMessage());
		}
	}

}
