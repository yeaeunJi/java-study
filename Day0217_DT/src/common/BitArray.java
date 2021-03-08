package common;

/*
 * Java : extends[확장] / implements[생성,구현상속]
 * 
 * [부모]   class A              interface IA                 interface IA
 * [자식]   class B extends A    interface IB extends IA      class C implements IA
 */

public class BitArray implements BitCollection {
	//1. 맴버 필드
	private Object[] base; //레퍼런스 형태
	private int max;
	private int size;
	
	//2. 생성자
	public BitArray() {
		this(10);     //인자를 1개 받는 생성자를 명시적으로 호출!
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
		if(idx >=0 && idx <= size-1)	//비어있는 상황 체크? (size == 0)
			return true;
		else
			return false;
	}	
	
	@Override
	public int getSize() {
		return size;
	}
	
	//4. 기능 메서드	
	@Override
	public Object getData(int idx) {
		if( IsUseIdx(idx) == false)
			return null;		
		return base[idx];
	}
	
	@Override
	public void Insert(Object obj) throws Exception {
		if( IsOverflow() == true)
			throw new Exception("저장 공간이 부족합니다.");
		
		base[size] = obj;
		size++;
	}
	
	@Override
	public void Delete(int idx) throws Exception {
		if(IsUseIdx(idx) == false)
			throw new Exception("유효하지 않은 인덱스 접근입니다.");
		
		for(int i=idx; i< size-1; i++)
		{
			base[i] = base[i+1];
		}
		size--;
	}
}
