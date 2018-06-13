package ps.maru;

/**
 * 
 * @author CHUNGJUNG
 *
 */
class Num {
	private int number1 = 10;
	
	public Num() {
		
	}
	
	public void Num() {
		System.out.println("�����ڶ� �̸��� �Ȱ��� �޼ҵ忡��");
		number1 = 100;
	}
	
	public void disp() {
		System.out.println(number1);
	}
}

public class Problem2 {

	public static void main(String[] args) {
		Num n = new Num();
		
		//n.disp();
		//n.Num();
	}

}
