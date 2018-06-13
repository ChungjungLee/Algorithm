package ps.careerinjapan;

public class ThreeBaka {

	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {
			//String output = String.format("argv[%s]: %s", i, args[i]);
			
			String numberStr = args[i];
      
			int number = 0;
			boolean isInvalid = false;
			boolean has3inNum = false;
			
			for (int j = 0; j < numberStr.length(); j++) {
				char digit = numberStr.charAt(j);
				
				if ('0' <= digit && digit <= '9') {
					number = number * 10 + (digit - '0');
					if (digit == '3') {
						has3inNum = true;
					}
				} else {
					System.out.println("invalid");
					isInvalid = true;
					break;
				}
			}
			
			if (isInvalid) {
				continue;
			}
			
			if (number < 0 || number > 1000) {
				System.out.println("invalid");
				continue;
			}
			
			if (number % 3 == 0) {
				if (has3inNum) {
					System.out.println("dumb");
				} else {
					System.out.println("idiot");
				}
			} else {
				if (has3inNum) {
					System.out.println("stupid");
				} else {
					System.out.println("smart");
				}
			}
		}
	}

}

