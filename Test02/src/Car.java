
public abstract class Car {
	private int passanger ; // 승객수
	private int amount; // 지불 금액
	private int transPrice; // 환승시 금액
	private int originPrice; // 일반 요금
	private String type ; // 종류

	public Car( int originPrice, int transPrice, String type) {
		this.originPrice = originPrice;
		this.transPrice = transPrice;
		this.type = type;
	}

	public void useCar(Student s) {
		int val = getPrice(s);

		if (s.getMoney() <  val) {
			System.out.println("** 잔액이 부족합니다.");
			System.out.println("필요한 금액 : "+val);
			System.out.println("현재 잔액 : "+s.getMoney());
			System.exit(0);
		} 
		else {
			s.useTransfer(type, val); // 승객이 요금 지불
			passanger += 1;
			amount += val;
		}
	}

	public abstract int getPrice(Student s) ; // 가격 계산 방식


	public int getPassanger() {
		return passanger;
	}

	public void setPassanger(int passanger) {
		this.passanger = passanger;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(int transPrice) {
		this.transPrice = transPrice;
	}

	public int getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(int originPrice) {
		this.originPrice = originPrice;
	}
}
