
public class Member2 implements Comparable<Member2>{
	private String name;
	private String  id ;

	public Member2(String id, String name) {
		this.name = name;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Member2 o) {
		return  this.id.compareTo(o.getId());
	}
	
	@Override
	public String toString() {
		String s;
		s = this.name + "회원님의 아이디는 "+this.id+"입니다.";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member2) {
			Member2 temp = (Member2) obj;
			return this.id.equals(temp.getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	
	
}
