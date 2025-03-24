class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //マップ：キーを値にマッピングするオブジェクト（コレクション）。HashMapはその実装。各キーは一つの値にしかマッピングできない。(キーは一意で、対応も一意。)
        Map <Integer, Integer> countMap = new HashMap<>();
        for (int num :nums) {
            //put(k, v)で新しくKey-Valueをマップに追加する。getOrDefault()は、keyに対応するvalueを返す、もしくは、keyの値がマップ内に無い場合はデフォルト値として第二引数に書いた値を返す。keyはオブジェクト。intは4バイトだがIntegerは１６バイト。 このマップは数値の出現回数を記録する。
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        //step2:出現回数の少ない順に要素を保持する優先度キューを作成(カスタムComparatorをラムダ式で実装)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        //ステップ3: 各要素をヒープに追加し、サイズをk以下に保つ
        //countMap.keySet() ← Mapに連動する特殊なSetビューを返す
        for (int num : countMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll;//出現頻度が最も低い要素を１ループごとに削除する
            }
        }
        //step4: ヒープから要素を取り出して、「結果配列」を作成する
        int[] result = new int[k];
        for (int i = k-1 ; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
