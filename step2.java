class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create Map key:数値、value:そのインデックス
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            //もし相方(補数)の数値がMapに存在すれば、解答を返す
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };//{}の中は、空白ありの方が、要素間の区切りが明確で読みやすい　javaコーディング規約
            }

            //なければ、現在の数値とインデックスをマップに保存
            numToIndex.put(nums[i], i);
        }

        return new int[] {};

    }
}
