347. Top K Frequent Elements
first try

//もっとも頻繁に現れる値を上位k個返す
//set?
//countして多いものからk個取り出す
//障害点：Arrayにおいて要素がランダム順序で現れる時
//各数の個数を記録する→ 多い順にｋ個
//時間計算量・空間計算量・実行時間見積もり
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> counter = new LinkedList<>();
        int count = 0;
        for (int i ; i < nums.length ; i++) {
            if (nums[i] == nums[i+1]) {
                int element = count++;
                counter. = element;
            } else {
                countArray[]

            }
        }
    }
}
