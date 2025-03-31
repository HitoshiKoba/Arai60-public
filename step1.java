class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};
        boolean found = false;
        outerloop:
        for (int i= 0; i < nums.length; i++) {
            int theOther = target - nums[i];
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (theOther == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    found = true;
                    break outerloop;
                }
            }
        }
        return result;

    }
}

//コメント
//boolean found = false というフラッグを使っているが、結局foundがfalseのままだった場合のreturn文の条件分岐を書いていないので、意味がないかもしれない。
