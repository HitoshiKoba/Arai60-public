class Solution {
    public int firstUniqChar(String s) {
        //s consists of only lowercase English letters.
        //so int array size gonna be 26
        int[] count = new int[26];

        //[]arrayは array.lengthという形で（）がいらないが、Stringはs.length()という形でメソッドである。
        //各文字の出現回数をカウント　HashMapのKeyみたいな？
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) -'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;//一位の文字がない時
    }
}
