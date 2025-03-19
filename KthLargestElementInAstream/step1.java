import java.util.ArrayList;

class KthLargest {
    int k;
    int[] nums;
    //コンストラクタを定義する
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = null;
    }
    
    public int add(int val) {
        //配列をソートする
        //nums.add(val);
        //int[] sortedNums = Arrays.sort(nums);
        ArrayList arrayList = new ArrayList<>(Arrays.asList(nums));
        arrayList.add(val);
        ArrayList sortedNums = arrayList.sort();
        return sortedNums.get(2);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 //配列をソートすることを思いついた時点で、どんなメソッドがあるかと思いoracleの公式ドキュメントを読んでみた。Arrays.sort(int[] a)　は　Dual-Pivot Algorithmを使っているらしい.
