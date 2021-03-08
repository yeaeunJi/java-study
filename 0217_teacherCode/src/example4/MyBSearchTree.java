package example4;

public class MyBSearchTree {
	public class Node{
		int key;
		Node left;
		Node right;

		public Node(int key){
			this.key = key;
			left = right = null;
		}
	}

	//맴버필드
	private Node root;
	private int count;

	public MyBSearchTree() {
		root = null;
		count = 0;
	}

	//메서드
	//insert 알고리즘---------------------------------------
	//재귀함수
	public void Insert(int key) {		
		if( root == null) {
			root = new Node(key);
			count++;
		}
		else
			InnerInsert(root, key);	
	}

	private void InnerInsert(Node cur, int key) {
		if( cur.key > key) {
			if(cur.left != null)
				InnerInsert(cur.left, key);
			else {
				cur.left = new Node(key);
				count++;
			}
		}
		else if(cur.key < key)
			if(cur.right != null)
				InnerInsert(cur.right, key);
			else {
				cur.right = new Node(key);
				count++;
			}
		else if(cur.key == key)
			return;
	}

	//비재귀함수
	public void Insert_NonRe(int key) {
		if( root == null) {
			root = new Node(key);  count++;
			return;
		}
		Node cur = root;
		while(true) {
			if(cur.key < key) {
				if(cur.right == null) {
					cur.right = new Node(key);  count++;
					break;
				}
				else
					cur = cur.right;
			}
			else if(cur.key > key){
				if(cur.left == null) {
					cur.left = new Node(key);  count++;
					break;
				}
				else
					cur = cur.left;
			}
			else if(cur.key == key)
				return;
		}
	}

	//search 알고리즘	--------------------------------------------
	//재귀
	public Node Search(int key) {
		return InnserSelect(root, key);	
	}

	private Node InnserSelect(Node cur, int key) {
		if(cur == null || cur.key == key)  //없을경우 or 찾았을 경우
			return cur;

		if( cur.key > key) 
			return InnserSelect(cur.left, key);
		else
			return InnserSelect(cur.right, key);		
	}

	//비재귀
	public Node Search_NonR(int key) {
		Node cur = root;

		while(cur != null) {  //단말노드의 left or right까지 이동
			if( cur.key == key)
				return cur;
			else if(cur.key < key)
				cur = cur.right;
			else if(cur.key > key)
				cur = cur.left;
		}		
		return null;
	}

	// del.left 노드를 del.right  최솟값 노드.left에 대입하는 메서드
	public void minumDelRightNode(Node del) {
		Node temp = del.right;
		while(temp.left != null) { // 삭제할노드.right의 최솟값 노드
			temp = temp.left;
		}
		temp.left = del.left; // 삭제 노드의 left는 삭제할 노드. right의 left가 됨
	}

	// 부모 노드를 반환하는 메서드
	private Node findGrandNode(Node del) {
		Node parent = root;

		while(parent.left != del && parent.right != del) {
			if (parent.left == del || parent.right == del) // 발견하면 나옴
				break;
			else { // 현재 parent의 key보다 del의 키가 작으면
				if (del.key < parent.key)
					parent = parent.left;
				else 
					parent = parent.right;
			}
		}
		return parent;
	}

	public boolean delete(int key) {

		Node del = Search(key);

		if (del == null) return false; // 존재하지 않는 값이면 삭제 실패

		Node parent = null;
		parent = findGrandNode(del);
		if (del.left != null && del.right != null) { // 만약에 삭제 노드의 자식이 2개이면
			minumDelRightNode(del); // 삭제 노드.left는 삭제노드.right의 최솟값노드.left에 대입됨
			if (del == root) { // 부모 노드가 없는 root가 del인 경우
				root = del.right; 
			}
			else { // 할머니 노드가 존재하는 경우
				parent.left = del.right;
			}
		}
		else if (del.left != null || del.right != null) { // 만약에 삭제 노드의 자식이 한개이면
			if (del == root) { // 부모 노드가 없는 root가 del인 경우
				if (del.left != null)  	root = del.left;
				else 	root = del.right;
			}
			else {
				if (parent.left == del) {
					if (del.left != null)	parent.left = del.left;
					else 	parent.left = del.right;
				}
				else {
					if (del.left != null) 	parent.right = del.left;
					else 	parent.right = del.right;
				}
			}
		}
		else { // 만약에 삭제 노드의 자식이 없다면
			if (del == root)  
				root = null;
			else {
				if (parent.left == del) parent.left = null;
				else  parent.right = null;
			}
		}
		count --;
		return true;
	}

	//delete 알고리즘 -------------------------------------------------
	//비재귀
	public boolean Delete(int key) {

		Node parent = null;
		Node del = root;
		//검색!
		//반복문 종료조건 : 현재노드가 null(검색실패) or 값을 찾은 경우
		while( ( del!= null) && del.key != key) {
			parent = del;
			if( key < del.key)
				del = del.left;
			else
				del = del.right;
		}

		if( del == null) 	//못찾은 경우
			return false;

		//삭제 알고리즘
		if( del.left == null && del.right == null ) { //자식이 없는 경우
			//1. 부모가 없는경우			
			//2. 부모가 있는 경우
			if( parent == null)  //root가 삭제 노드인 경우!
				root = null;
			else {
				if( parent.left == del) //삭제할 노드가 부모의 어느 부분에 존재하는가?
					parent.left = null;
				else
					parent.right = null;
			}
		}
		else if(del.left == null || del.right == null ) {  //자식이 하나인 경우
			//삭제할 노드의 어느부분에 자식이 존재하는가?
			//자식을 찾음.
			Node child;
			if(del.left != null)
				child = del.left;
			else
				child = del.right;

			//부모에 매다는 작업
			//1. 부모가 없는경우[root를 삭제할 경우]			
			//2. 부모가 있는 경우
			if( parent == null)
				root = child;
			else {
				if( parent.left == del)
					parent.left = child;
				else
					parent.right = child;
			}			
		}
		else {  //자식이 두개인 경우
			//선택 : 삭제 노드의 왼쪽자식중 가장 큰값을 갖
			//      삭제 노드의 오른쪽자식중 가장 작은값(0)

			//삭제 노드의 가장 작은 노드와 그 부모노드를 찾음.
			Node succ_parent = del;
			Node succ = del.right;
			while(succ.left != null) {
				succ_parent = succ;
				succ = succ.left;
			}

			if(succ_parent.left == succ)
				succ_parent.left = succ.right;  //right 는 null일수도있고, 노드주소일수도있다.
			else
				succ_parent.right = succ.right;

			del.key = succ.key;  //찾은 값을 삭제할 노드의 값에 저장!				
		}	
		count--;
		return true;		
	}


	//검증!-------------------------------------
	public void InOrder() {
		System.out.println("저장개수 : " + count);
		InnerInOrder(root);
		System.out.println();
	}


	private void InnerInOrder(Node root) {		
		if(root.left != null)
			InnerInOrder(root.left);
		System.out.print((int)root.key + " ");
		if(root.right != null)
			InnerInOrder(root.right);
	}
}















