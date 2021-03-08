import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
	static  List<User> allUsers = null ;
	private String id;
	private String password;
	
	static {
		allUsers = new ArrayList<User>();
	}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;	

	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String  getPassword() {
		return password;
	}
	public void setPassword(String  password) {
		this.password = password;
	}
	
	public void signUP(User user) {
		allUsers.add(user);
	}
	
	public void printAllUsers() {
		User[] all  = new User[allUsers.size()];
		System.out.println("현재 가입한 회원 정보 : "+all.length+"명");

		for(int i=0; i < all.length;i++) {
			all[i] = allUsers.get(i);
			System.out.println(all[i].getId());
		}
	}
	
}
