import java.util.Random;
class Solution {
    private int[] cumulative;
    private int total;
    private Random rand;

    public Solution(int[] w) {
        cumulative = new int[w.length];
        total = 0;      
        //累積和作る
        for (int i = 0; i < w.length ; i++) {
            total += w[i];
            cumulative[i] = total;
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(total);
        //線形探索 二分探索も暗記せよ
        int left = 0, right = cumulative.length -1;
        for (int i = 0; i < cumulative.length; i++) {
            if (target < cumulative[i]) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
