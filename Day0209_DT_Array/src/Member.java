
public class Member { // 데이터
	private int number;
	private String name;
	private String phone;
	private char gender ;
	
	public Member(int number, String name, String phone, char gender){
		this.setNumber(number);
		this.setName(name);
		this.setPhone(phone);
		this.setGender(gender);
	}

	public Member(int number, String name) {
		this(number, name, "", ' ');
	}
	
	public int getNumber() {
		return number;
	}

	private void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}		
	
	public void println() {
		System.out.println("**********************************************************************");
		System.out.println(" [회원번호]  " + number);
		System.out.println(" [이름]  " + name);
		System.out.println(" [전화번호]  " + phone);
		System.out.println(" [성별]  " + gender);
		System.out.println("**********************************************************************");
	}
	
	public void print() {
		System.out.println("**********************************************************************");
		System.out.printf(" [%d] %s %s %c\n ",  number, name, phone, gender );
		System.out.println("**********************************************************************");
	}
	
	
}
