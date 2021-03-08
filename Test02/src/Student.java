
public class Student {
	private String name;
	private String grade;
	private int money;
	private int usedBusCount ;
	private int  usedSubwayCount;
	private int busTransCount;
	private int subTransCount;

	public Student(String name, String grade, int money) {
		this.name = name;
		this.grade = grade;
		this.money = money;
		this.usedBusCount = 0;
		this.usedSubwayCount = 0;
	}

	@Override
	public String toString() {
		return "이름 : "+this.name+" / grade : "+this.grade +" / 잔액 : "+this.money;
	}

	// 교통수단 이용시 돈을 지불하고, 학생 정보 출력
	public void useTransfer(String transfer, int val) {
		this.money -= val;
		boolean showCheckMsg = 	(this.subTransCount != 1 || this.busTransCount != 3) ? true : false;

		if (transfer.equals("Bus")) {
			if (val == 300)	busTransCount += 1;
			this.usedBusCount += 1;
		}
		else {
			if (val == 300) subTransCount +=1 ;
			this.usedSubwayCount += 1;
		} // end if

		System.out.println(transfer+"으로 "+((val == 300)?"환승":"일반탑승")+" 합니다." +" - 운행 요금 : "+val);

		if (showCheckMsg)
			System.out.println("남은 환승 가능한 횟수 :  버스 ==> "+(3-this.busTransCount)+
					", 지하철 ==> "+(1-this.subTransCount));
		System.out.println(this);
	}

	public int getBusTransCount() {
		return busTransCount;
	}

	public void setBusTransCount(int busTransCount) {
		this.busTransCount = busTransCount;
	}

	public int getSubTransCount() {
		return subTransCount;
	}

	public void setSubTransCount(int subTransCount) {
		this.subTransCount = subTransCount;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}

	public int getUsedBusCount() {
		return usedBusCount;
	}

	public void setUsedBusCount(int usedBusCount) {
		this.usedBusCount = usedBusCount;
	}

	public int getUsedSubwayCount() {
		return usedSubwayCount;
	}

	public void setUsedSubwayCount(int usedSubwayCount) {
		this.usedSubwayCount = usedSubwayCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}


