package ps.mailprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 정수 배열(int array)과 정수 N이 주어지면, N번째로 큰 배열 원소를 찾으시오.
 * 
 * 예제)
 * Input: [-1, 3, -1, 5, 4], 2
 * Output: 4
 * 
 * Input: [2, 4, -2, -3, 8], 1
 * Output: 8
 * 
 * Input: [-5, -3, 1], 3
 * ﻿Output: -5
 * 
 * @author CHUNGJUNG
 *
 */
public class SiliconValley13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input = in.readLine();
		
		String[] splited = input.split("\\[");
		input = splited[1];
		splited = input.split("\\]");
		String arrString = splited[0];
		
		input = splited[1];
		splited = input.split(" ");
		String nString = splited[1];
		
		ArrayList<Integer> elemList = new ArrayList<>();
		String[] elements = arrString.split(", ");
		for (int i = 0; i < elements.length; i++) {
			elemList.add(Integer.parseInt(elements[i]));
		}
		
		int[] splitedInput = buildIntArray(elemList);
		int N = Integer.parseInt(nString);
		
		long startTime = System.nanoTime();		
		System.out.println(solutionByQuickSelect(splitedInput, N));
		System.out.println("Elapsed Time: "+(System.nanoTime()-startTime)/1000000.0+"ms");
	}
	
	/**
	 * 그냥 정렬 후 k번째로 큰 수를 찾는 방법
	 * 
	 * time complexity: O(NlogN)
	 * space complexity: O(1)
	 * 
	 * better solution: quick selection을 이용하면 된다.
	 */
	private static int solution(int[] input, int N) {
		Arrays.sort(input);
		
		return input[input.length - N];
	}
	
	private static int solutionByQuickSelect(int[] input, int N) {
		int left = 0;
		int right = input.length - 1;
		int pivotIdx = (left + right) / 2;
		int findIdx = input.length - N;
		
		int properIdx;
		while(true) {
			properIdx = partition(input, left, right, pivotIdx);
			if (properIdx < findIdx) {
				left = properIdx + 1;
				pivotIdx = (left + right) / 2;
			} else if (properIdx > findIdx) {
				right = properIdx - 1;
				pivotIdx = (left + right) / 2;
			} else {
				return input[properIdx];
			}
		}
	}
	
	private static int partition(int[] array, int left, int right, int pivotIdx) {
		int pivotVal = array[pivotIdx];
		int properIdx = right;
		
		swap(array, left, pivotIdx);
		
		for (int i = left + 1; i <= properIdx; i++) {
			if (array[i] > pivotVal) {
				swap(array, properIdx, i);
				properIdx--;
				i--;
			}
		}
		
		swap(array, left, properIdx);
		
		return properIdx;
	}
	
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static int[] buildIntArray(List<Integer> integers) {
	    int[] ints = new int[integers.size()];
	    
	    int i = 0;
	    for (Integer n : integers) {
	        ints[i++] = n;
	    }
	    
	    return ints;
	}

}






