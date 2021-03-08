package example1;

//DNode �� MyDList������ ���Ǵ� ���� Ŭ����!
public class BitLinkedList implements BitCollection {
	public class DNode {
		Object data;	//����
		DNode next;		//�������
		DNode prev;		//�������
		
		public DNode(Object data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
	
	//�ɹ� �ʵ�
	private DNode head;
	private DNode tail;
	private int   size;
	
	//������
	public BitLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	//get �޼���
	public DNode getHead() {
		return head;
	}
	
	//insert --------------------------------------------------------------
	public boolean push_front(Object data) {
		DNode newnode = new DNode(data);
		
		if(head == null) {  // head == null && tail == null 
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		size++;
		return true;
	}

	public boolean push_back(Object data) {
		DNode newnode = new DNode(data);
		
		if(head == null) {  // head == null && tail == null 
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.prev = tail;
			tail.next = newnode;
			tail = newnode;
		}
		size++;
		return true;
	}
	
	public boolean push_random(DNode cur, Object data) {		
		
		if(cur.next == null) {
			//������ ��� �������...
			return push_back(data);
		}
		
		//���� ��� �߰��� �����ϴ� ��Ȳ
		DNode newnode = new DNode(data);
		
		newnode.prev = cur;
		newnode.next = cur.next;
		cur.next = newnode;
		newnode.next.prev = newnode;
		
		size++;
		return true;		
	}
	
	//��ü ��ȸ -----------------------------------------------------------
	public void Select_NextAll() {
		System.out.print("[" + size + "] ");
		
		DNode cur = head;	 //<---------------	1)
		while(cur != null) {
			//------------------------------
			int data = (int)cur.data;			//��ڽ�!(�ڵ�) : �⺻��Ÿ�� = ���۷���Ÿ��
			System.out.print(data + " -> ");
			//------------------------------
			cur = cur.next;  //<-----------------2)
		}
		
		System.out.println();
	}
	
	public void Select_PrevAll() {
		System.out.print("[" + size + "] ");
		
		DNode cur = tail;	 //<---------------	1)
		while(cur != null) {
			//------------------------------
			//int data = (int)cur.data;			
			System.out.print(cur.data + " -> "); //��ڽ�!(�ڵ�) : �⺻��Ÿ�� = ���۷���Ÿ��
			//------------------------------
			cur = cur.prev;  //<-----------------2)
		}
		
		System.out.println();
	}

	//�˻�(�˻������� --> Node��ȯ(����: null)
	public DNode Select(Object key) {
		DNode cur = head;		
		while(cur != null) {
			//------------------------------
			int data = (int)cur.data;			//��ڽ�!(�ڵ�) : �⺻��Ÿ�� = ���۷���Ÿ��
			if(data == (int)key){
				return cur;
			}
			//------------------------------
			cur = cur.next;
		}
		return null;
	}

	//delete -------------------------------------------------------------
	public boolean erase_front() {
		if( head == null) {		//������� ��
			return false;
		}
		else if(head.next == null) { //��尡 �ϳ��λ�Ȳ  tail.prev == null
			head = tail = null;
		}
		else {  //��尡 2�� �̻��� ��Ȳ
			DNode del = head;
			
			head = del.next;
			head.prev = null;		
			
			//del.next.prev = null;
			//head = del.next;
		}
		size--;
		return true;
	}

	public boolean erase_back() {
		if( head == null) {		//������� ��
			return false;
		}
		else if(head.next == null) { //��尡 �ϳ��λ�Ȳ  tail.prev == null
			head = tail = null;
		}
		else {  //��尡 2�� �̻��� ��Ȳ
			DNode delprev = tail.prev;
			delprev.next =null;
			tail = delprev;			
		}
		size--;
		return true;
	}

	//�ش� ��� ����!
	public boolean erase_random(DNode del) {
		if( del == null)
			return false;
		
		//���� ����
		if(del.prev == null) {		//ù��° ���
			return erase_front();
		}
		else if( del.next == null) { //�ι�° ���
			return erase_back();
		}
		else {
			del.prev.next = del.next;
			del.next.prev = del.prev;
		}
		size--;
		return true;		
	}

	@Override
	public int getSize() {
		return size;
	}

	//�迭 ���� �ε���[��������] : 0 ~ N
	//���Ḯ��Ʈ : ù��° ������ �ε����� ���� Ȱ���Ͽ� �̵� --> node�� �ƴ϶� data�� ��ȯ!
	@Override
	public Object getData(int idx) {
		if( idx <0 || idx >= size )//<============= ����
			return null;
		
		DNode cur = head;
		for(int i=0; i<idx; i++)
			cur = cur.next;	
		
		return cur.data;
	}

	//�迭�ϰ� �����ϰ� ����(push_back)
	@Override
	public void Insert(Object obj) throws Exception {
		if( push_back(obj) == false)
			throw new Exception("���� ����");		
	}

	//�迭 ���� �ε���[��������] : 0 ~ N
	//���Ḯ��Ʈ : ù��° ������ �ε����� ���� Ȱ���Ͽ� �̵� --> node�� ȹ��!
	//boolean erase_random(Node) ���!
	@Override
	public void Delete(int idx) throws Exception {
		if( idx <0 || idx >= size )   //<==================== ����
			throw new Exception("�߸��� �ε���");
		
		DNode cur = head;
		for(int i=0; i<idx; i++)
			cur = cur.next;			
		
		if(erase_random(cur) == false)
			throw new Exception("���� ����");
	}
}









