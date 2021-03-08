
public class Subway extends Car {
	private String path;

	
	public Subway(String path, int originPrice, int transPrice, String type) {
		super(originPrice, transPrice, type);
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	@Override
	public int getPrice(Student s) {
		if (s.getUsedBusCount() !=0) { // 이전에 버스를 사용한 경험이 있는 학생 중
			if(s.getSubTransCount() == 0 ) { // 지하철 환승 한번도 안한 학생
				return 300;
			}else { // 이전에 버스를 탄 경험도 있고 지하철 환승 경험도 있는 경우
				System.out.println("지하철 환승 가능 횟수를 초과하였습니다. 일반 요금을 지불하십시오.");
				return 1500;
			}
		}
		else { // 이전에 버스를 사용한 경험이 없는 학생 중
			return 1500;
		}
	}
	
	@Override
	public String toString() {
		return path+" 전철의 수입은 "+this.getAmount()+"이고, 오늘 이용객 수는 총 "+this.getPassanger()+"입니다.";
	}
}
