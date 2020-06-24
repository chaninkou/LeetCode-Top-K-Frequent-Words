package leetcode692;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		
		int k = 2;
		
		System.out.println("Input: " + Arrays.toString(words));
		
		FindTopKFrequentWords solution = new FindTopKFrequentWords();
		
		System.out.println("Solution: " + solution.topKFrequent(words, k));
	}
}
