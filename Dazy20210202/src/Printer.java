
public class Printer {
	private String name ;
	private String id;
	private int price ;
	
	public Printer(String name, String id, int price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}
	
	
	
	@Override
	public String toString() {
		return "제품명 : "+this.name +", ID : "+this.id +", 가격 : "+this.price;
	}
	
	
	
	
	
}
