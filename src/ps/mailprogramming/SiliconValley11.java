package ps.mailprogramming;

import java.util.HashMap;

/**
 * 
 * 길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.
 * 
 * 예제)
 * Input: “EGG”, “FOO”
 * Output: True // E->F, G->O
 * 
 * Input: “ABBCD”, “APPLE”
 * Output: True // A->A, B->P, C->L, D->E
 * 
 * Input: “AAB”, “FOO”
 * Output: False
 * 
 * @author CHUNGJUNG
 *
 */
public class SiliconValley11 {

	public static void main(String[] args) {
		String plainText = "AAB";
		String encryptedText = "FOO";
		
		System.out.println(isEncryptable(plainText, encryptedText));
	}
	
	/**
	 * 해시 테이블을 이용하여 풀었지만, 영문자 26개를 원소로 하는 배열을 만들어 풀어도 괜찮겠다.
	 * @param plainText
	 * @param encryptedText
	 * @return
	 */
	private static boolean isEncryptable(String plainText, String encryptedText) {
		HashMap<Character, Character> encryptTable = new HashMap<>();
		
		char plainChar = 0;
		
		for (int i = 0; i < plainText.length(); i++) {
			plainChar = plainText.charAt(i);
			
			if (encryptTable.containsKey(plainChar)) {
				if (encryptTable.get(plainChar).charValue() != encryptedText.charAt(i)) {
					return false;
				}
			} else {
				encryptTable.put(plainChar, encryptedText.charAt(i));
			}
		}
		
		return true;
	}

}



