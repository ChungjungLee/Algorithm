package ps.rakuten;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Return the maximum distance between two indices of which the array has adjacent values.
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

public class Adjacent2 {
	public static void main(String[] args) {
		//int[] test = {1, 4, 7, 3, 3, 5};
		int[] test = {0, 3, 3, 7, 5, 3, 11, 1};
		//int[] test = {1, 1, 1, 1, 1};
		
		System.out.println("maximum distance: " + solution(test));
	}
	
	private static HashMap<Integer, ArrayList<Integer>> makeHashMap(int[] inputArr) {
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
		ArrayList<Integer> value;
		
		// make a hashmap which consists of the key that is elements 
		// and the corresponding value of which the indices.  
		for (int i = 0; i < inputArr.length; i++) {
			
			if (hashMap.containsKey(inputArr[i])) {
				value = hashMap.get(inputArr[i]);
				value.add(i);
				
			} else {
				value = new ArrayList<>();
				value.add(i);
			}
			
			hashMap.put(inputArr[i], value);
		}
		
		return hashMap;
	}
	
	public static int solution(int[] inputArr) {
		Ascending ascending = new Ascending();

		int result = 0;
		int absval = 0;
		boolean hasAdjacent = false;
		
		HashMap<Integer, ArrayList<Integer>> hashMap = makeHashMap(inputArr);
		
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
			ArrayList<Integer> list1 = hashMap.get(inputArr[compareIndex]);
			ArrayList<Integer> list2 = hashMap.get(inputArr[compareIndex + 1]);
			
			list1.sort(ascending);
			list2.sort(ascending);
			
			int distance1 = Math.abs( list1.get(0) - list2.get(list2.size() - 1) );
			int distance2 = Math.abs( list2.get(0) - list1.get(list1.size() - 1) );
			
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

class Ascending implements Comparator<Integer> {	 
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}

