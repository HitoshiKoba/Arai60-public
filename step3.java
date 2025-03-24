//hashmap-heap-solution
//try to write English comments
import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            //by put(), add mapped Key-Value to HashMap-Object countMap. 
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //Ordinally, inside bracket() there is a number which represents the size of Minimum Heap. But this time we put lambda function.
        //On lambda function, we definite Comparator, which is the rule for ordering the elements on Minimum Heap. Inside the lambda function, We get Value corresponding with Key(get(a)), which means we get the appearance times of the each number.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int num : countMap.keySet()) {
            minHeap.offer(num);
            //here, we made capacity of Minimum heap. 
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k-1 ; i >= 0 ; i--) {
            result[i] = minHeap.poll();
        } 
        return result;
    }
}
