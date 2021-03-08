
public class BitArray {
	
	// 1. 멤버 필드 선언
	private Object[] base; // 모든 클래스 타입 저장 가능
	private int max;
	private int size;
	
	// 2. 생성자 및 변수 초기화
	public BitArray() { // 아무런 매개변수를 전달하지 않을 경우 size가 10인 배열 생성
		this(10);  // 인자를 1개 받는 생성자를 명시적으로 호출
	}
	
	public BitArray(int _max) {
		setMax(_max);  //max = _max;
		setSize(0); // 클래스 내외부에서 멤버필드에 값을 할당할 시에는 setter사용하는 것을 권고 	size = 0;
		base = new Object[max];
	}
	
	// 3. get & set
	public int getSize() {
		return size;
	}

	private void setSize(int size) {  // 외부에서 변수를 마음대로 변경하지 못하도록 private 선언
		this.size = size;
	}
	
	public int getMax() {
		return max;
	}

	private void setMax(int max) {
		this.max = max;
	}
	
	// 4. 기능 메서드
	
	// 데이터 조회
	public Object getData(int idx) {
		if (isUseIdx(idx) == false) 
			return null; // 초기화되어 있지 않고 비어있는 주소값임을 나타냄
		return base[idx];
	}
	
	public void insert(Object obj) throws Exception { 
		// 처음 구현 시 정상적인 기능부터 작성하고 확인 후에 예외 처리
		if( isOverFlow() == true)
			throw new Exception("저장 공간이 부족합니다.");
		
		base[size] = obj;
		size++;

	}
	
	// insert 시에 일어날 수 있는 오버플로우 체크(클래스 내부에서만 사용하는 함수로 정의)
	private boolean isOverFlow() {
		if( max <= size)
			return true;
		else
			return false;
	}
	
	// 유효한  idx인지를 체크 
	private boolean isUseIdx(int idx) {
		if (idx >=0 && idx <= size-1) return true; // 이럴 경우 비어있는 상황 체크가 가능한가? size==0인 상태
		else return false;
	}
	
	// delete 함수
	public void delete(int idx) throws Exception{
		if (isUseIdx(idx) == false) {
			throw new Exception("유효하지 않은 인덱스 접근입니다. ");
		}
		
		for(int i=idx; i < size-1; i++) {
			base[i] = base[i+1];
		}
		size--;
	}
	
	
	
}

