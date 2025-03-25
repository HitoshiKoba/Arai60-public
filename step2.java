class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resultVector = new ArrayList<>();
        //順序がa[0] - b[0]の小さい順に作られる　優先度順
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //合計値が小さい順にソートされる優先度付きキュー

        //初期状態として、nums1の各要素とnums2[0]を組み合わせたペアをすべてPQに入れる
        for (int x : nums1) {
            minHeap.offer(new int[]{x + nums2[0], 0});
            //配列の先頭の数値で昇順に並んでいる。
            //新しい配列の定義の書き方. int[] x = new int[]{3, 4, 5};具体的な値を入れる
        }
        //isEmpty()はコレクションからの継承メソッドで、PriorityQueueでも使える
        while (k > 0 && !minHeap.isEmpty()) {
            int [] pair = minHeap.poll();
            int sum = pair[0];
            int position = pair[1];

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[position]);//add()で、リストにaddする
            currentPair.add(nums2[position]);//nums2要素
            resultVector.add(currentPair);

            //まだ次の要素がある場合、(nums2[pos+1])とのペアをキューに追加
            if (position + 1 < nums2.length) {
                minHeap.offer(new int[]{sum - nums2[position] + nums2[position + 1], position + 1});
            }
            k--;
        }
        return resultVector;
    }
}
