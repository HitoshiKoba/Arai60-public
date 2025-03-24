import java.util.HashMap;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //step1 回数カウントのためのmap作成 valueは出現回数
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        //step2 minHeapのメモリ（箱）作成、comparatorのルールを定義
        PriorityQueue <Integer> minHeap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));

        //step3 minHeapに回数上位を格納していく＝上から順にｋ個ソートする
        for (int num : countMap.keySet()) { 
            minHeap.offer(num);
            if (minHeap.size() > k ) {
                minHeap.poll();
            }
            
        }
        //step4 結果配列作成、結果格納、返却
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
