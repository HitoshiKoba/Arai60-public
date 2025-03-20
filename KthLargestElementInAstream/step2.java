//写経
//PriorityQueueを使う（最小ヒープ）
//PriorityQueue(int initialCapacity)
//自然順序付けに従って要素を順序付けする、指定された初期容量を持つPriorityQueueを作成します。

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    //コンストラクタ：ｋと初期スコア配列numsを受け取る
    public KthLargest(int k, int[] nums) {
        this.k = k;
        //ヒープにはk個の要素のみ保持するため、初期容量をｋに設定
        minHeap = new PriorityQueue<>(k);
        //初期スコアをaddで追加して整える
        for (int num : nums) {
            add(num);
        }
    }
    // 新しいスコアを追加し、現在の k 番目に大きいスコアを返す
    public int add(int val) {
        //ヒープサイズがk未満なら単純に追加
        if (minHeap.size() < k) {
            minHeap.offer(val);//offer()末尾に追加
        } else if (val > minHeap.peek()) {
            //peek();削除しないで先頭を取得
            minHeap.poll();//最小値を取り除く
            minHeap.offer(val);//新たな値を追加
            // 追加する値がヒープの最小値（＝現時点で k 番目に大きい値）より大きい場合、
            // 最小値を取り除いて新たな値を追加することで、常に上位 k 個を保持する
        }
        //ヒープの最小値が、k番目に大きな値になる
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
