package ps.rakuten;
import java.util.Arrays;

/**
 * Return the maximum distance between two indices of which the array has adjacent values.
 * 
 * Assuming
 * 
 * Complexity
 * time complexity: 
 * 
 * @author CHUNGJUNG
 *
 */

public class Adjacent {
	public static void main(String[] args) {
		int[] test = {1, 4, 7, 3, 3, 5};
		//int[] test = {0, 3, 3, 7, 5, 3, 11, 1};
	}
	
	public static int solution(int[] inputArr) {
		int result = 0;
		int absval = 0;
		boolean hasAdjacent = false;
		
		int[] sortedArr = inputArr.clone();
		
		Arrays.sort(sortedArr);
		
		for (int i = 0; i < sortedArr.length; i++) {
			for (int j = (i + 1); j < sortedArr.length; j++) {
				if (areAdjacent(inputArr, sortedArr, i, j) == true) 
                {
					
					hasAdjacent = true;
					
                    absval = Math.abs(i - j);
                    
                    if (absval > result) 
                    { 
                    	result = absval; 
                    } 
                } 
			}
		}
		
		if (hasAdjacent) {
			return result;
		} else {
			return -2;
		}
		
	}
	
	public static boolean areAdjacent(int[] myArray, int[] sortedArray, int index1, int index2) 
    { 
        int value1, value2; 
        int minval, maxval; 

        value1 = myArray[index1]; 
        value2 = myArray[index2]; 

        if (value1 > value2) {
        	int temp = value1;
        	value1 = value2;
        	value2 = temp;
        }
        
        if (value1 == value2) { return false; } 
        
        index1 = getFirstIndex(sortedArray, value1); 
        index2 = getLastIndex(sortedArray, value2); 

        minval = (index1 >= index2) ? index2 : index1;
        maxval = (index1 >= index2) ? index1 : index2;
        

        for (int between = minval + 1; between < maxval; between++) 
        { 
            if ((sortedArray[between] != value1) && (sortedArray[between] != value2)) 
            { 
                return false; 
            } 
        } 
        return true; 
    } 
	
	public static int getFirstIndex(int[] sortedArray, int target) {
		for (int i = 0; i < sortedArray.length; i++) {
			if (sortedArray[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public static int getLastIndex(int[] sortedArray, int target) {
		for (int i = sortedArray.length - 1; i >= 0; i--) {
			if (sortedArray[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
}




