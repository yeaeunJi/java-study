package ex_0203;

public class Dog {
	private String name;
	private String type;
	
	public Dog(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString() {
		return  "name : "+this.getName()+", type : "+this.getType();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
