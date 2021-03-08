package ex_0203;

public class Customer {
	private String id;
	private String name;
	private String grade;
	private long bonus ;
	private double addRatio;
	
	public Customer(String id, String name, String grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.bonus =10000;
		this.addRatio = 0;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getBonus() {
		return bonus;
	}

	public void setBonus(long bonus) {
		this.bonus = bonus;
	}

	public double getAddRatio() {
		return addRatio;
	}

	public void setAddRatio(double addRatio) {
		this.addRatio = addRatio;
	}
	
	
	
	
}
