
public class TV extends Product {
	public TV() {
		super();
		this.setCategory("TV");
		this.setPrice(100);
	}
	public String toString() {
		return this.getCategory()+"- "+this.getPrice();
	}
}
