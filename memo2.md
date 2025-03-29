難しかった。

クロードclaude 3.7 sonnetの回答が一番わかりやすかったので、貼っておく。

# LeetCode 373: Find K Pairs with Smallest Sums を一緒に解きましょう！

こんにちは！「Find K Pairs with Smallest Sums」という問題ですね。この問題は最初見ると少し複雑に感じるかもしれませんが、PriorityQueueとSetを使って効率よく解くことができます。一緒に考えていきましょう！

## 問題の整理

まず、問題の内容をおさらいしましょう：
- 2つの昇順にソートされた配列 `nums1` と `nums2` が与えられます
- ペア `(u, v)` は `nums1` から一つの要素と `nums2` から一つの要素で構成されます
- 合計値が最小の `k` 個のペアを返す必要があります

## 解き方の基本的な考え方

問題をシンプルにするために、最初に思いつくのは「全てのペアを作って、和でソートして、最初の k 個を返す」という方法です。しかし、これは非効率的です。なぜなら、nums1の長さが n で nums2の長さが m だとすると、全ペアは n×m 個になり、大きな入力データでは時間・メモリ両方でオーバーフローしてしまいます。

そこで、PriorityQueueとSetを使った効率的な解法を考えましょう！

## Priority Queue と Set を使う理由

### Priority Queue（優先度キュー）の役割：
- 「和が最小のペア」を効率的に取得するためです
- MinHeapとして使うと、常に最小値が先頭に来るので、最小の和を持つペアをO(log n)で取得できます

### Set（集合）の役割：
- すでに訪れたインデックスのペアを記録するためです
- 同じインデックスの組み合わせを重複して処理しないようにします

## アルゴリズムの流れ

1. `(0, 0)` から始める：最初のペア（nums1[0], nums2[0]）は必ず最小の和になります（両方の配列は昇順ソート済みなので）
2. 現在のペア (i, j) に対して、次の候補は (i+1, j) と (i, j+1) になります
3. これらの候補をPriorityQueueに追加し、和が最小のものを次々と取り出していきます
4. 重複を避けるために、既に処理したインデックスのペアはSetに記録します

それでは、実際にコードで見てみましょう：

```java
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 空の配列のケースを処理
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }
        
        // [nums1のインデックス, nums2のインデックス, 和] を保持するPriorityQueue
        // 和を基準に昇順でソート
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // 訪問済みのインデックスペアを記録するSet
        Set<String> visited = new HashSet<>();
        
        // 最初のペア (0,0) を追加
        minHeap.offer(new int[]{0, 0, nums1[0] + nums2[0]});
        visited.add("0,0");
        
        // k個のペアを見つけるまで繰り返す
        while (k > 0 && !minHeap.isEmpty()) {
            // 現在の最小和のペアを取得
            int[] current = minHeap.poll();
            int i = current[0];
            int j = current[1];
            
            // 結果に追加
            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;
            
            // 次の候補: (i+1, j)
            if (i + 1 < nums1.length && !visited.contains((i + 1) + "," + j)) {
                minHeap.offer(new int[]{i + 1, j, nums1[i + 1] + nums2[j]});
                visited.add((i + 1) + "," + j);
            }
            
            // 次の候補: (i, j+1)
            if (j + 1 < nums2.length && !visited.contains(i + "," + (j + 1))) {
                minHeap.offer(new int[]{i, j + 1, nums1[i] + nums2[j + 1]});
                visited.add(i + "," + (j + 1));
            }
        }
        
        return result;
    }
}
```

## コードの解説

1. **初期設定**:
   - 結果を格納する `result` リストを作成します
   - 和でソートする `minHeap` (PriorityQueue) を作成します
   - 訪問済みのインデックスペアを記録する `visited` (Set) を作成します

2. **初期状態**:
   - (0, 0) のペアをminHeapに追加します（両方の配列は昇順ソート済みなので、これが最小の和を持つペアになります）

3. **メインループ**:
   - minHeapから最小の和を持つペアを取り出します
   - そのペアを結果に追加します
   - 次の候補 (i+1, j) と (i, j+1) をminHeapに追加します（まだ訪問していない場合）

4. **終了条件**:
   - k個のペアを見つけたら終了
   - または、minHeapが空になったら終了

## なぜこのアルゴリズムが正しいのか？

この問題の重要なポイントは、「ソート済みの配列では、隣接する要素が次の候補になる」ということです。具体的には：

1. 和が最小のペアは (0, 0) です（両方の配列は昇順ソート済みのため）
2. 次に小さい和を持つ可能性があるのは (1, 0) か (0, 1) です
3. その次は (1, 1), (2, 0), (0, 2) などの候補から最小のものになります

このアプローチを使うと、全ての n×m 個のペアを生成せずに、必要な k 個のペアだけを効率的に見つけることができます。時間複雑度は O(k log k) となり、大きな入力データでも効率的に動作します。

## 実例で確認

例1: nums1 = [1,7,11], nums2 = [2,4,6], k = 3

1. 最初のペア (0,0) → [1,2], 和=3
2. 次の候補 (1,0) → [7,2], 和=9 と (0,1) → [1,4], 和=5 をminHeapに追加
3. minHeapから最小の (0,1) → [1,4], 和=5 を取り出す
4. 次の候補 (0,2) → [1,6], 和=7 をminHeapに追加
5. minHeapから最小の (0,2) → [1,6], 和=7 を取り出す

結果: [[1,2], [1,4], [1,6]]

いかがでしょうか？この解法の流れが理解できましたか？質問があればどうぞ！
