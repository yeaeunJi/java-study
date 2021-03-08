package example4;

import example2.ParseTree.Node;

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

	// 멤버 필드
	Node root;
	int count;

	public MyBSearchTree() {
		root = null;
		count = 0;
	}

	// 메서드
	// insert 알고리즘
	public void insert(int key) {
		Node cur = root;
		if (cur == null) {
			root = new Node(key);
			count++;
		}
		else 
			innerInsert(root, key);
	}


	// return
	private void innerInsert (Node cur, int key) {
		if ( cur.key > key) {
			if (cur.left != null)
				innerInsert(cur.left, key);
			else 
				cur.left = new Node(key);
			count++;
		}
		else if( cur.key < key) {
			if (cur.right != null)
				innerInsert(cur.right, key);
			else 
				cur.right = new Node(key);
			count++;
		}
		else if(cur.key == key)
			return;
	}

	public void inOrder() {
		innerInOrder(root);
		System.out.println();
	}

	private void innerInOrder(Node root) {
		if (root == null) return;
		if(root.left != null) 
			innerInOrder(root.left);
		System.out.print((int)root.key+ " ");
		if(root.right != null)
			innerInOrder(root.right);
	}

	public Node searchNonRecur(int  key) {
		Node cur = root;

		while(cur != null ) {
			if (cur.key < key)
				cur = cur.right;
			else if (cur.key > key)
				cur = cur.left;
			else 
				return cur;
		}
		return null; //못찾은 경우
	}

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

}
