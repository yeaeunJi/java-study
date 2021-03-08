
public class Member implements Comparable<Member>{
	private String name;
	private String  phone ;

	public Member(String phone, String name) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int compareTo(Member o) {
		return  this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		String s;
		s = this.name + "의 번호는 "+this.phone+"입니다.";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member temp = (Member) obj;
			return this.name.equals(temp.getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	
}
