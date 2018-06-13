package ps.rakuten;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Return the maximum distance between two indices of the array which has adjacent values.
 * Retrun -1 if no adjacent indices exists.
 * 
 * Assuming
 * N(the length of the input array): 1~40000
 * 
 * Complexity
 * time complexity: O(N * logN)
 * space complexity: O(N)
 * 
 * @author CHUNGJUNG
 *
 */

public class Adjacent3 {
	public static void main(String[] args) {
		int[] test = {0, 3, 3, 7, 5, 3, 11, 1};
		// 0 1 3 3 3 5 7 11
		//int[] test = {1, 4, 7, 3, 3, 5};
		//int[] test = {1, 1, 1, 1, 1};
		
		//�ð� ��� ����
        long startTime = System.nanoTime();
        System.out.println("maximum distance: " + solution(test));
        System.out.println("Elapsed Time: "+(System.nanoTime()-startTime)/1000000.0+"ms");
	}
	
	private static HashMap<Integer, Integer[]> makeHashMap(int[] inputArr) {
		HashMap<Integer, Integer[]> indicesMap = new HashMap<>();
		// indices[0]: the most left index where the element appeared in the input array 
		// indices[1]: the most right index
		Integer[] indices;
		
		// make a hashmap which consists of the key that is elements 
		// and the corresponding value of which the indices.  
		for (int i = 0; i < inputArr.length; i++) {
			
			if (indicesMap.containsKey(inputArr[i])) {
				indices = indicesMap.get(inputArr[i]);
				indices[1] = i;
			} else {
				indices = new Integer[2];
				indices[0] = indices[1] = i;
			}
			
			indicesMap.put(inputArr[i], indices);
		}
		
		return indicesMap;
	}
	
	public static int solution(int[] inputArr) {
		int result = 0;
		int absval = 0;
		boolean hasAdjacent = false;
		
		HashMap<Integer, Integer[]> indicesMap = makeHashMap(inputArr);
		
		Arrays.sort(inputArr);
		
		int arrayLength = inputArr.length;
		int compareIndex = 0;
		
		while (arrayLength > 1 && compareIndex < arrayLength - 1) {
			// not adjacent
			if (inputArr[compareIndex] == inputArr[compareIndex + 1]) {
				compareIndex++;
				continue;
			}
			
			// adjacent
			Integer[] indicesArr1 = indicesMap.get(inputArr[compareIndex]);
			Integer[] indicesArr2 = indicesMap.get(inputArr[compareIndex + 1]);
			
			int distance1 = Math.abs(indicesArr1[0] - indicesArr2[1]);
			int distance2 = Math.abs(indicesArr1[1] - indicesArr2[0]);
			
			absval = (distance1 > distance2) ? distance1 : distance2;
			result = (absval > result) ? absval : result;
			
			compareIndex++;
			hasAdjacent = true;
		}
		
		if (hasAdjacent) {
			return result;
		} else {
			return -1;
		}
	}
	
}
