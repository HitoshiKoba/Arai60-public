
import java.util.PriorityQueue;
//最小ヒープ使える
//ペアのsumでcomparatorする
//最大ヒープ？下から３個選ぶから。reverseOrderか。ちっちゃいのを選ぶ カスタムcomparator
//nums1の要素数＊nums2の要素数＝　全部で９通り
//non-decreasing orderって書いてあるからそれを利用せよ
//(u, v)で選ぶ　first array からひとつと、second arrayからひとつ
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairsList = new ArrayList<>();
        for (int i = 0 ; i < nums1.length ; i++) {
            for (int j = 0 ; j < nums2.length ; j++) {
                List<Integer> eachPair = new ArrayList<>();
                eachPair.add(nums1[i]);
                eachPair.add(nums2[j]);
                pairsList.add(eachPair);
            }
        }
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for (List<Integer> each : pairsList) {
            map.put(each, each.get(0) + each.get(1));
        }
        
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (List<Integer> each : map.keySet()) {
            maxHeap.offer(each);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = k-1 ; i >= 0; i--) {
            result.add(maxHeap.poll());
        }
        return result;


    }
}
