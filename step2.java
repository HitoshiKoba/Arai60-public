claude3.7の正答。これで暗記を図る。

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Step 1: Create a HashSet from nums1 (automatically removes duplicates)
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Step 2: Create a result HashSet
        Set<Integer> resultSet = new HashSet<>();
        
        // Step 3: Check each element in nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        
        // Step 4: Convert the resultSet to array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        
        return result;
    }
}
