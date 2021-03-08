package sample1;

public class Start {
	public static void exam1() {
		System.out.println("------------------------------ exam1------------------------------ ");
		MyDList list = new MyDList();
		list.push_back(10);
		list.push_back(20);
		list.push_back(30);
		list.selectNextAll();
		list.selectPrevAll();
		MyDList.DNode cur = list.select(10);
		if(cur!=null)
			System.out.println("검색 결과 : " + (int)cur.data);
		else 
			System.out.println("없음");
	}

	public static void exam2() {
		System.out.println("------------------------------ exam2------------------------------ ");
		MyDList list = new MyDList();
		list.push_back(10);
		list.push_back(20);
		list.push_back(30);
		list.selectNextAll();
		MyDList.DNode cur = list.select(10);
		list.push_random(cur, 14);
		list.selectNextAll();
		list.push_random(cur, 40);
		cur = list.select(20);
		list.push_random(cur, 50);
		cur = list.select(30);
		list.push_random(cur, 60);
		list.selectNextAll();
	}
	public static void exam3() {
		System.out.println("------------------------------ exam3------------------------------ ");
		MyDList list = new MyDList();
		list.push_back(10);
		list.push_back(20);
		list.push_back(30);
		list.selectNextAll();

		for(int i =0; i<6; i++) {
			list.erase_front();
			list.selectNextAll();
		}
	}
	public static void exam4() {
		System.out.println("------------------------------ exam4------------------------------ ");
		MyDList list = new MyDList();
		list.push_back(10);
		list.push_back(20);
		list.push_back(30);
		list.selectNextAll();

		for(int i =0; i<6; i++) {
			list.erase_back();
			list.selectNextAll();
		}
	}
	public static void exam5() {
		System.out.println("------------------------------ exam5------------------------------ ");
		MyDList list = new MyDList();
		list.push_back(10);
		list.push_back(20);
		list.push_back(30);
		list.push_back(40);
		list.selectNextAll();
		
		MyDList.DNode del = list.select(10);
		list.erase_random(del);
		list.selectNextAll();
		del = list.select(30);
		list.erase_random(del);
		list.selectNextAll();
		del = list.select(40);
		list.erase_random(del);
		list.selectNextAll();
		}
	public static void main(String[] args) {
		exam1();
		exam2();
		exam3();
		exam4();
		exam5();
		
	}
}
