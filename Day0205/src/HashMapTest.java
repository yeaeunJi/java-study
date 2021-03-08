import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, Long> nation = new HashMap<String, Long>();
		
		String[] name = {"한국", "미국", "중국"};
		long[] pop = {1000l, 10000l, 100000l};
		
		for(int i=0; i<name.length;i++) {
			nation.put(name[i],pop[i]);
		}
		
		long temp = 0l;
		String nationName = "";
		
		for(Entry<String, Long> map : nation.entrySet()) {
			if (temp < map.getValue()) {
				temp = map.getValue();
				nationName = map.getKey();
			}
		}
		System.out.println(nationName);
	}
}
