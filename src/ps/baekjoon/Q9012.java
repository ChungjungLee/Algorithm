package ps.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		scanner.nextLine();
		
		String str = "";
		
		for (int i = 0; i < T; i++) {
			str = scanner.nextLine();
			
			// core solution
			boolean isVps = false;
			int index = 0;
			int len = str.length();
			Stack<Character> stack = new Stack<>();
			
			while (index < len) {
				if (str.charAt(index) == '(') {
					stack.push('(');
				} else {
					if (stack.isEmpty() || stack.pop() != '(') {
						break;
					}
				}
				index++;
			}
			
			if (index == len && stack.isEmpty()) {
				isVps = true;
			}
			
			if (isVps) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		scanner.close();
		
	}
}
