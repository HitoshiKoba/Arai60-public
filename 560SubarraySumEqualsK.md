言語：Java

## step3(map.getOrDefault()などを使わずに、シンプルにifとelseで実装する)
```Java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        prefixSumMap.put(0, 1);
        
        int prefixSumAtJ = 0;

        int count = 0;

        for (int num : nums) {
            prefixSumAtJ += num;

            if (prefixSumMap.containsKey(prefixSumAtJ)) {
                prefixSumMap.put(prefixSumAtJ, prefixSumMap.get(prefixSumMap) + 1);
            } else {
                prefixSumMap.put(prefixSumAtJ, 1);
            }

            if(prefixSumMap.containsKey(prefixSumAtJ - k)) {
                count += prefixSumMap.get(prefixSumAtJ - k);
            }
        }
        return count;
    }
}
```
