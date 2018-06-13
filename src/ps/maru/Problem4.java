package ps.maru;

class Animal {
	int num = 10;
	static int stNum = 100;
	
	void eat() {
		System.out.println("Animal: eat");
	}
	
	static void stEat() {
		System.out.println("Animal: stEat");
	}
}

class Dog extends Animal {
	int num = 20;
	static int stNum = 200;
	
	void eat() {
		System.out.println("Dog: eat");
	}
	
	static void stEat() {
		System.out.println("Dog: stEat");
	}
}

public class Problem4 {
	public static void main(String[] args) {
		Animal a = new Dog();
		
		System.out.println("a.num= " + a.num);
		System.out.println("a.stNum= " + a.stNum);
		
		a.eat();
		a.stEat();
		((Dog)a).stEat();
	}
}
