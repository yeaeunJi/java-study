
public class Member {
	private String name;
	private String  id ;
	
	public Member(String id, String name) {
		this.name = name;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public int equals(Member o) {
		if(this.id.equals(o.getId())) {
			if(this.name.equals(o.getName())) {
				return 1;
		}
	}
	return 0 ;
	}

}
