package leetcode692;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTopKFrequentWords {
	// Bucket sort
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();

		if (words.length == 1 && k == 1) {
			return Arrays.asList(words[0]);
		}

		// Count the appears
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}

		// Bucket sort
		List<String>[] bucket = new ArrayList[words.length + 1];

		for (String key : map.keySet()) {
			int mostRepeated = map.get(key);

			if (bucket[mostRepeated] == null) {
				bucket[mostRepeated] = new ArrayList<>();
			}

			bucket[mostRepeated].add(key);
		}

		List<String> solution = new ArrayList<>();

		for (int end = bucket.length - 1; end > 0 && k > 0; --end) {
			if (bucket[end] != null) {
				// This will make this O(nlog(k))
				bucket[end].sort((p1, p2) -> p1.compareTo(p2));

				solution.addAll(bucket[end]);

				k = k - bucket[end].size();
			}

		}

		// Just in case if there are more than there should be
		while (k < 0) {
			solution.remove(solution.size() - 1);
			k++;
		}

		return solution;
	}
}
