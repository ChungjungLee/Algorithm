package ps.ateam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * ���� ���� "�ձ��� �� �α�" ���� ����
 * 
 * @author CHUNGJUNG
 *
 */
public class Problem2Advanced {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		String pLine = in.readLine();
		String[] splited = pLine.split(" ");
		
		int[] arrP = new int[N];
		for (int i = 0; i < N; i++) {
			arrP[i] = Integer.parseInt(splited[i]);
			
		}
		
		long startTime = System.nanoTime();		
		System.out.println(solution(arrP));
		System.out.println("Elapsed Time: "+(System.nanoTime()-startTime)/1000000.0+"ms");
	}
	
	/**
	 * �� ���� ������ �α� �� ��Ģ�� �ִ�. (a[i] >= a[i+1])
	 * ������ �α� �� a[i]�� �־��� P[i]�� �α� �� ���ٴ� ������ �۾ƾ� �Ѵ�.
	 * 
	 * �׷��Ƿ� P[i]���� ���� �� �ִ� �ּҰ� min�� �����ϰ� ���ϴ� ���� �ʿ��ϴ�.
	 */
	private static int solution(int[] arrP) {
		int result = arrP[0], min = arrP[0];
		
		for (int i = 1; i < arrP.length; i++) {
			if (min < arrP[i]) {
				result += min;
			} else {
				result += arrP[i];
				min = arrP[i];
			}
		}
		
		return result;
	}

}
