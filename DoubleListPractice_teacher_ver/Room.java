package sample2;


public class Room {
	//�ɹ� �ʵ�
	private MyDList waitroom = new MyDList();
	private MyDList game1 = new MyDList();
	private MyDList game2 = new MyDList();
	private MyDList game3 = new MyDList();
	
	//������
	
	//�޼���
	public void PrintAll() {
		System.out.println("-------------------------------------------------");
		System.out.print("����\t");   waitroom.Select_PrevAll();
		System.out.print("���ӹ�1\t");  game1.Select_PrevAll();
		System.out.print("���ӹ�2\t");  game2.Select_PrevAll();
		System.out.print("���ӹ�3\t");  game3.Select_PrevAll();
		System.out.println("-------------------------------------------------");
	}

	public boolean Insert(int number) {
		waitroom.push_back(number);
		return true;
	}
	
	public boolean Delete(int number) {
		MyDList.DNode node = waitroom.Select(number);
		if(node == null)
			return false;
		
		waitroom.erase_random(node);
		return true;			
	}
	
	public boolean GameIn(int idx, int number) {		
		MyDList.DNode node = waitroom.Select(number);
		if(node == null)	//���濡 ������ ����
			return false;
		
		if(idx == 1) {
			game1.push_front(number);
		}
		else if(idx == 2) {
			game2.push_front(number);	
		}
		else if(idx == 3) {
			game3.push_front(number);	
		}
		waitroom.erase_random(node);
		return true;
	}
	
	public boolean GameOut(int idx, int number) {
		if(idx == 1) {
			MyDList.DNode node =  game1.Select(number);
			if(node == null)
				return false;
			
			game1.erase_random(node);
			waitroom.push_front(number);
			return true;
		}
		else if(idx == 2) {
			MyDList.DNode node =  game2.Select(number);
			if(node == null)
				return false;
			
			game2.erase_random(node);
			waitroom.push_front(number);
			return true;
		}
		else if(idx == 3) {
			MyDList.DNode node =  game3.Select(number);
			if(node == null)
				return false;
			
			game3.erase_random(node);
			waitroom.push_front(number);
			return true;
		}
		return false;
	}	
}
