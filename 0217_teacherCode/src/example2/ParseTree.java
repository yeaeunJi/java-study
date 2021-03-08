package example2;

import common.MyLinkedStack;

//수식나무[연결리스트기반, 알고리즘은 스택을 활용]
public class ParseTree {
	public class Node{
		int key;			//정수 저장!
		Node left;
		Node right;
		
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

	//맴버 필드
	Node root;		//루트 노드의 주소를 저장할 레퍼런스 변수
	int  count;		//노드 갯수 
	
	//생성자
	public ParseTree(){
		root = null;
		count = 0;				
	}
	
	//get 메서드
	public int getCount() {
		return count;
	}
	
	public int getRootNodeValue() {
		return root.key;
	}
	
	//메서드
	//1. 수식나무 구성[ 피연산자는 1의 자리로 제한 ] "3 2 + 4 * 2 -"  [연산자,피연산자,공백]
	void MakeParseTree(String str) {
		
		//1. 스택자료구조 생성 [ HAS A ]
		MyLinkedStack stack = new MyLinkedStack();
		
		//2. 반복문(문장의 끝까지)		
		//   2.1 연산자라면!
		//       2.1.1 노드 생성, count증가
		//       2.1.2 스택에서 팝한 노드를 오른쪽 자식으로 할당
		//		 2.1.4 다음 스택에서 POP 노드를 왼쪽 자식으로 할당
		//		 2.1.5 2.1.1에서 만든 노드를 스택에 PUSH
		//   2.2 연산자가 아니라면!
		//       2.2.1 노드 생성, count증가
		//       2.2.2 스택에 PUSH
		//   2.3 if( ch == ' ') continue;
		//3. 스택에서 POP에서 맴버필드 root에 대입!
		for(char ch : str.toCharArray()) {
			if( IsOperator(ch)) {
				Node node = new Node(ch);
				count++;
				node.right = (Node)stack.Pop();
				node.left  = (Node)stack.Pop();
				stack.Push(node);
			}
			else if(Character.isDigit(ch)) {
				Node node = new Node(ch);
				count++;
				stack.Push(node);
			}			
		}
		this.root = (Node)stack.Pop();
	}
	
	//1.1 연산자 식별하는 함수
	private boolean IsOperator(int value) {
		if( value == '+' || value == '-' || value == '*' || value == '*')
			return true;
		else
			return false;
	}
	
	//2. 순회코드(재귀)
	public void PreOrder() {
		InnerPreOrder(root);
		System.out.println();
	}
	
	private void InnerPreOrder(Node root) {
		System.out.print((char)root.key + " ");
		if(root.left != null)
			InnerPreOrder(root.left);
		if(root.right != null)
			InnerPreOrder(root.right);
	}
	
	public void InOrder() {
		InnerInOrder(root);
		System.out.println();
	}
	
	private void InnerInOrder(Node root) {		
		if(root.left != null)
			InnerInOrder(root.left);
		System.out.print((char)root.key + " ");
		if(root.right != null)
			InnerInOrder(root.right);
	}
	
	public void PostOrder() {
		InnerPostOrder(root);
		System.out.println();
	}
	
	private void InnerPostOrder(Node root) {		
		if(root.left != null)
			InnerPostOrder(root.left);
		if(root.right != null)
			InnerPostOrder(root.right);
		System.out.print((char)root.key + " ");
	}

	
	public void preOrderNonRecursive() {
		
		MyLinkedStack stack = new MyLinkedStack();
		
		Node cur = root;
		stack.Push(cur);
		
		while(stack.IsEmpty() == false) {
			cur = (Node) stack.Pop();
			System.out.print((char)cur.key+" ");
			if (cur.left != null) {
				if (cur.right != null)
					stack.Push(cur.right);
				stack.Push(cur.left);
			}
		}
		System.out.println();
	}
	
	
	
	//3. 순회코드(반복문- 스택)
	public void PreOrder_NonRe() {
		//1. 루트 노드를 스택에 Push
		//2. 반복문(스택이 비어있지 않다면)
		//   2.1 스택에서 Pop 해서 
		//   2.2 Pop한 노드가 != NULL
		//       2.2.1 스택에서 Pop한 노드를 방문
		//       2.2.2 스택에서 Pop한 오른쪽 자식을 PUSH
		//       2.2.3 스텍에서 Pop한 왼쪽 자식을 PUSH
		MyLinkedStack stack = new MyLinkedStack();
		stack.Push(root);
		while( stack.IsEmpty() == false) {
			Node node = (Node)stack.Pop();
			if( node != null) {
				System.out.print((char)node.key + " ");
				stack.Push(node.right);
				stack.Push(node.left);
			}
		}
		System.out.println();
	}

	//null값을 스택에 저장하지 않음
	public void PreOrder_NonRe1() {
		MyLinkedStack stack = new MyLinkedStack();
		stack.Push(root);
		while( stack.IsEmpty() == false) {
			//스택에 null은 저장되지 않으므로 pop후 조건검사 없이 방문 가능
			Node node = (Node)stack.Pop();
			System.out.print((char)node.key + " ");
			if(node.right != null)
				stack.Push(node.right);
			if(node.left != null)
				stack.Push(node.left);			
		}
		System.out.println();
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
				stack.Push(cur);
				cur = cur.left;
			}
			if( stack.IsEmpty() == false) {
				cur = (Node)stack.Pop();
				System.out.print((char)cur.key + " ");
				cur = cur.right;
			}
			else
				break;		
		}
		System.out.println();
	}
}
















