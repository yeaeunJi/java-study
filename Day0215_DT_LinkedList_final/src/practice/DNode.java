package practice;

public class DNode {
	Object data; // 저장된 데이터
	DNode prev; // 이전 노드
	DNode next; // 다음 노드
	
	public DNode(Object data) {
		this.data= data;
		this.prev = null;
		this.next = null;
	}
	
	
}
