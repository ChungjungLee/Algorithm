package ps.maru;

class ProblemSuper {
	ProblemSuper() {
		System.out.println("�θ�Ŭ���� ������ ȣ��");
	}
}

public class Problem3 extends ProblemSuper {
	Problem3() {
		super();
		
		// anonymous block ����
		
		System.out.println("c");
	}
	
	{
		System.out.println("y");
	}
	
	public static void main(String[] args) {
		new Problem3().go();
	}
	
	void go() {
		System.out.println("g");
	}
	
	static {
		System.out.println("x");
	}
}
