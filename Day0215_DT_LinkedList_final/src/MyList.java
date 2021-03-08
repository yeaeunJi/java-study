
public class MyList {
	private Node  head;
	private int size ; 


	public MyList() {
		this.head = null;
		this.size = 0;
	}

	public boolean front_insert(Object data) { // head에 노드를 삽입하는 메서드
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
		}
		else {
			newnode.next = head;
			head = newnode;
		}
		size ++;
		return true;
	}

	public void selectAll() { // 전체 데이터를 순회하는 메서드
		Node cur = head;
		System.out.println("[ "+size+" ] ");
		while(cur != null) {
			int data = (int)cur.data ;	 // 언박싱(기본형타입에 참조형 타입이 대입될 때 자동으로 발생)
			System.out.print(data+" -> ");
			cur = cur.next;
		}
		System.out.println();
	}

	public boolean back_insert(Object data) { // 제일 마지막에 노드를 삽입하는 메서드
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
		}
		else {
			Node cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = newnode;
		}
		size ++;
		return true;
	}

	public boolean random_insert(Node cur, Object data) { // cur 다음 노드에 노드를 삽입하는 메서드
		Node newnode = new Node(data);
		if (cur.next != null) {
			newnode.next = cur.next;
		}
		cur.next = newnode;
		size ++;
		return true;
	}

	public Node select(Object key) { // 검색(검색 데이터 ---> Node 반환(실패:null)) 
		Node cur = head;
		while(cur != null) {
			int data = (int)cur.data;
			if ( data == (int)key) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	public boolean front_delete() { // head노드가 삭제되는 메서드
		Node del = head;

		if (del == null) return false;

		head = del.next;
		size --;
		return true;
	}

	public boolean back_delete() { // 마지막 노드 삭제
		Node prev = head;
		Node del = head;

		if (del == null) return false;

		if (del.next == null ) { // 현재 연결되어 있는  노드가 하나인 상황
			head = null;
		}
		else { // 현재 연결되어 있는 노드가 두개인 상황 
			while(del.next != null) {
				prev = del; 
				del = del.next;
			}

			prev.next = null; // prev.next = del.next
		}
		size --;
		return true;
	}

	public boolean random_delete(Node prev) { // prev의 다음 노드를 삭제
		if (prev.next == null)  return false;

		Node del = prev.next;
		if (del.next != null) {
			prev.next = del.next;
		}
		else 
			prev.next = null;
		size --;
		return true;
	}
}


