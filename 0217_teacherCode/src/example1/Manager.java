package example1;

/*
 * BitArray�� ��� �ż���
 * 1) getSize() : ���� ���� ��ȯ
 * 2) getData(idx) : �ε��������ϸ� ���������� ��ȯ
 * 3) Insert(��������) : ����
 * 4) Delete(idx) : �ش� �ε����� ������ ����
 */
public class Manager {
	//private BitArray arr = new BitArray();
	private BitLinkedList arr = new BitLinkedList();

	//��ɸ޼���
	public void SelectAll() {
		System.out.println("[���尳��] " + arr.getSize() + "��");
		for(int i=0; i< arr.getSize(); i++)
		{
			int number = (int)arr.getData(i);  //Down Casting...-> instanceof
			System.out.println(number);
		}
	}
	
	public void Insert() {
		try {
			arr.Insert(10);		
			//4. ������
			System.out.println("���� ����!");
		}
		catch(Exception ex) {
			System.out.println("[�������] " + ex.getMessage());
		}
	}
	
	//�˻� �˰���(���� �˻�)
	//ȸ����ȣ�� ���� --> �迭�� idx ��ȯ(���� : -1)
	private int NumberToIdx(int number) {
		for(int i=0; i< arr.getSize(); i++) {
			int num = (int)arr.getData(i);
			if( num == number)
				return i;
		}
		return -1;
	}	
	
	public void Select() {
		int idx = NumberToIdx(10);
		if(idx != -1) {
			int number = (int)arr.getData(idx);
			System.out.println(number);
		}
		else
			System.out.println("����\n");
	}
	
	public void Update() {
		try {
			//int idx = NameToMember(10);
			//arr.getData(idx)= 20;
			System.out.println("���� ����\n");
		}
		catch(Exception ex) {
			System.out.println("[��������]" + ex.getMessage());
		}
	}
	
	public void Delete() {
		//����ڿ��� ȸ����ȣ�� �Է¹޾� �˻� �� �ش� ȸ���� ����(BitArray.Delete�Լ��� Ȱ��)
		//�������� �帧 : Select�� �����ϴ�.
		try {			
			int idx = NumberToIdx(10);
			if(idx == -1) 
				throw new Exception("���� ȸ����ȣ �Դϴ�.");	//<=======			
			arr.Delete(idx);
			System.out.println("�����Ǿ����ϴ�.");
		}
		catch(Exception ex) {
			System.out.println("[���� ����] " + ex.getMessage());
		}
	}
}
