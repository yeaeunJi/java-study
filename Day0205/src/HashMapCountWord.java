import java.util.HashMap;
import java.util.Map;

public class HashMapCountWord {

	public static void main( String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		
		String[] sample = {"one1", "two", "one","one", "three", "aaa", "ab"};
		
		for(String a : sample) {
			Integer freg = m.get(a);
			m.put(a,  (freg == null) ?1:freg+1);
		}
		System.out.println(m.size() +"단어가 있습니다.");
		System.out.println(m.containsKey("a"));
		System.out.println(m.containsKey("one"));
		System.out.println(m.isEmpty());
		System.out.println(m);
		
		//		6단어가 있습니다.
		//		false
		//		true
		//		false
		//		{aaa=1, ab=1, one=2, two=1, three=1, one1=1}
	}
}
