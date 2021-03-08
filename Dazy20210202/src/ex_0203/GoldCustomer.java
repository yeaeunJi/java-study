package ex_0203;

public class GoldCustomer extends Customer implements Buy {
	
	public GoldCustomer(String id, String name, String grade) {
		super(id, name, grade);
		this.setAddRatio(1.5);
	}

	public void buying( int cost) {		
		System.out.println(this.getName()+"님께서 "+cost + "원 제품을 구매하셨습니다. ");
		this.getBonusPoint(cost);
	}
	
	public void getBonusPoint(int cost) {		
		double add = cost*this.getAddRatio();
		System.out.println("추가 적립 포인트 : "+add);
		add += this.getBonus();
		 this.setBonus((long)add);
	}

	public String toString() {		
		return "구매자 : "+this.getName()  +", bunus point: "+this.getBonus()+", 등급 : "+this.getGrade();
	}
}
