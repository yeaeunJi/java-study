package ex_0203;

public class VipCustomer extends Customer implements Buy {
	
	private String manager;

	
	public VipCustomer(String id, String name, String grade, String manager) {
		super(id, name, grade);
		this.manager = manager;
		this.setAddRatio(2.5);
		
	}
	
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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
		return "매니저 : "+this.getManager()+", 구매자 : "+this.getName()  +", bunus point: "+this.getBonus()+", 등급 : "+this.getGrade();
	}
}
