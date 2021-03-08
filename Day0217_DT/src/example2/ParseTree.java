package example2;

import common.MyLinkedStack;
import example2.ParseTree.Node;

// 수식 나무[ 연결리스트기반, 알고리즘은 스택을 활용 ]
public class ParseTree {
	public class Node{
		int key;  // 정수 저장
		Node left;
		Node right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

	// 멤버 필드
	Node root; // 루트 노드의 주소를 저장할 참조 변수
	int count; // 노드 개수 관리

	public int getCount() {
		return this.count;
	}

	public int getRootNodeValue() { 
		return this.getRootNodeValue();
	}

	// 생성자
	public ParseTree() {
		root = null;
		count = 0;
	}

	// 메서드
	// 1. 수식 나무 구성(피연산자는 1의 자리로 제한됨)
	// 1) 스택 자료구조 생성 [ HAS A ]
	// 2) 반복문(문장의 끝까지)
	// 	2.1 노드 생성, count 증가
	// 	2.2 피연산자면 스택에 팝하여 오른쪽, 또 팝하여 왼쪽 할당하고 연자노드를 스택에 푸시
	// 	2.3 연산자를 만나면 스택에 푸시
	// 3) root 노드 대입 : 스택에 마지막에 남은 노드가 root 노드
	public void makeParseTree(String str) {
		MyLinkedStack stack = new MyLinkedStack();
		try {				

			if (str == null) return;

			for(char c :  str.toCharArray()) {

				if (isOperator(c)) {
					Node node = new Node(c);
					node.right = (Node) stack.pop();
					node.left = (Node)  stack.pop();
					stack.push(node);
					count ++;
				}
				else if(Character.isDigit(c)) {
					Node node = new Node(c);
					stack.push(node);
					count ++;
				} 
			}
			if (!stack.isEmpty()) root = (Node) stack.pop();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 

	//	1.1 연산자를 식별하는 함수
	private boolean isOperator(int value) {
		if (value == '+' || value == '-' || value == '*' || value == '/')
			return true;
		else 
			return false;
	}

	// 2. 순회 코드(재귀)
	public void preOrder() {
		innerPreOrder(root);
		System.out.println();
	}

	private void innerPreOrder(Node root) {
		System.out.print((char)root.key+ " ");
		if(root.left != null) 
			innerPreOrder(root.left);
		if(root.right != null)
			innerPreOrder(root.right);

	}

	public void inOrder() {
		innerInOrder(root);
		System.out.println();
	}

	private void innerInOrder(Node root) {
		if(root.left != null) 
			innerPreOrder(root.left);
		System.out.print((char)root.key+ " ");
		if(root.right != null)
			innerPreOrder(root.right);
	}

	public void postOrder() {
		innerPostOrder(root);
		System.out.println();
	}

	private void innerPostOrder(Node root) {
		if(root.left != null) 
			innerPreOrder(root.left);
		if(root.right != null)
			innerPreOrder(root.right);
		System.out.print((char)root.key+ " ");
	}

	// 2. 순회 코드(비재귀- 반복문과 스택)
	// 1. 스택에 push(root)
	// 2. 반복문(스택이 비어있지 않다면)
	// 	2.1 stack pop
	// 	2.2 pop한 노드가 right child가 있으면 stack에 push
	// 	2.3 pop한 노드가 left child가 있으면 stack에 push
	public void preOrder_NonRecur() {
		try {
			MyLinkedStack  stack= new MyLinkedStack();
			stack.push(root); 

			while(!stack.isEmpty()) {
				Node node;
				node = (Node) stack.pop();
				System.out.print((char)node.key + " " );

				if (node.right != null)
					stack.push(node.right);
				if (node.left != null) 
					stack.push(node.left);
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preOrder_NonRecur1() {
		try {
			MyLinkedStack  stack= new MyLinkedStack();
			stack.push(root); 

			do {
				Node node;
				node = (Node) stack.pop();

				if (node != null) {
					System.out.print((char)node.key + " " );
					stack.push(node.right);
					stack.push(node.left);
				}
			}while(!stack.isEmpty());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void inOrder_NonRecur() {
		MyLinkedStack  stack = new MyLinkedStack();
		Node cur = root;
		
		if (cur != null) {
			if (cur.right != null) 
				stack.push(cur.right);
		}
		
		
		
	}
	public void InOrder_NonRe() {
		//NODE cur = root;
		//무한반복
			//1.반복(NULL이 아닐때까지)
			//  1.1 cur노드를 PUSH
			//  1.2 cur노드를 LEFT자식노드로 이동
			//2.조건(스택이 비어있지 않다면)
			//  2.1 POP
			//  2.2 방문!
			//  2.3 cur노드를 RIGHT 자식으로 이동
		    //3.스택이 비어있다면
		    //  무한반복을 종료!
		//
		MyLinkedStack stack = new MyLinkedStack();
		Node cur = root;
		while(true) {
			while( cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if( stack.isEmpty() == false) {
				try {
					cur = (Node)stack.pop();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print((char)cur.key + " ");
				cur = cur.right;
			}
			else
				break;		
		}
		System.out.println();
	}
	
	
	public void preOrderNonRecursive() {
		
		MyLinkedStack stack = new MyLinkedStack();
		
		Node cur = root;
		stack.push(cur);
		
		while(stack.isEmpty() == false) {
			try {
				cur = (Node) stack.pop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print((char)cur.key+" ");
			if (cur.left != null) {
				if (cur.right != null)
					stack.push(cur.right);
				stack.push(cur.left);
			}
		}
		System.out.println();
	}
	
	public void InOrder_NonRe1() {
		//NODE cur = root;
		//무한반복
			//1.반복(NULL이 아닐때까지)
			//  1.1 cur노드를 PUSH
			//  1.2 cur노드를 LEFT자식노드로 이동
			//2.조건(스택이 비어있지 않다면)
			//  2.1 POP
			//  2.2 방문!
			//  2.3 cur노드를 RIGHT 자식으로 이동
		    //3.스택이 비어있다면
		    //  무한반복을 종료!
		//
	}

}
