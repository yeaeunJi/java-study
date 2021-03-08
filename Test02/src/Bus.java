
public class Bus  extends Car{
	private int number ;

	public Bus(int number, int originPrice, int transPrice, String type ) {
		super(originPrice, transPrice, type );
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public int getPrice(Student s) {
		if (s.getUsedSubwayCount() !=0) { // 이전에 지하철을 사용한 경험이 있는 학생 중
			if(s.getBusTransCount() < 3 ) { // 버스 환승 3번 이하로 한 학생
				return 300;
			}else { // 버스 사용 4회 이상
				System.out.println("최대 버스 환승 가능 횟수를 초과하였습니다. 일반 요금을 지불하십시오.");
				return 1300;
			} // end inner if
		}
		else { // 이전에 지하철을 사용한 경험이 없는 학생 중
			if(s.getUsedBusCount() ==0) { // 모든 교통수단 처음
				return 1300;
			}else if  ( s.getBusTransCount()  == 3 ){ //버스  환승 경험이 있는 학생
				System.out.println("최대 버스 환승 가능 횟수를 초과하였습니다. 일반 요금을 지불하십시오.");
				return 1300;		
			}else {
				return 300;
			} // end inner if
		} // end if
	}

	@Override
	public String toString() {
		return number+"번 버스의 수입은 "+this.getAmount()+"이고, 오늘 이용객 수는 총 "+this.getPassanger()+"입니다.";
	}
}
