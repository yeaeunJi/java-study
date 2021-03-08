
public class Computer extends Product {
	public Computer() {
		super();
		this.setCategory("Computer");
		this.setPrice(200);
	}
	
	public String toString() {
		return this.getCategory()+"- "+this.getPrice();
	}
}
