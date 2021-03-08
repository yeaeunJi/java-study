package example1;
/*
 * Java : extends[Ȯ��] / implements[����,�������]
 * 
 * [�θ�]   class A              interface IA                 interface IA
 * [�ڽ�]   class B extends A    interface IB extends IA      class C implements IA
 */

public class BitArray implements BitCollection {
	//1. �ɹ� �ʵ�
	private Object[] base; //���۷��� ����
	private int max;
	private int size;
	
	//2. ������
	public BitArray() {
		this(10);     //���ڸ� 1�� �޴� �����ڸ� ��������� ȣ��!
	}
	
	public BitArray(int _max) {
		setMax(_max);  //max = _max;
		setSize(0);
		base = new Object[max];
	}
	
	//3. get & set

	private void setSize(int size) {
		this.size = size;
	}

	public int getMax() {
		return max;
	}

	private void setMax(int max) {
		this.max = max;
	}
	
	private boolean IsOverflow() {
		if( max <= size)
			return true;
		else
			return false;
	}
	
	private boolean IsUseIdx(int idx) {
		if(idx >=0 && idx <= size-1)	//����ִ� ��Ȳ üũ? (size == 0)
			return true;
		else
			return false;
	}
	
	//BitCollection ���� ���
	@Override 
	public int getSize() {
		return size;
	}
	
	@Override 
	public Object getData(int idx) {
		if( IsUseIdx(idx) == false)
			return null;		
		return base[idx];
	}
	
	@Override 
	public void Insert(Object obj) throws Exception {
		if( IsOverflow() == true)
			throw new Exception("���� ������ �����մϴ�.");
		
		base[size] = obj;
		size++;
	}
	
	@Override 
	public void Delete(int idx) throws Exception {
		if(IsUseIdx(idx) == false)
			throw new Exception("��ȿ���� ���� �ε��� �����Դϴ�.");
		
		for(int i=idx; i< size-1; i++)
		{
			base[i] = base[i+1];
		}
		size--;
	}
}

















