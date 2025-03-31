//単語の文字をバラしてsetにcharacterで格納する方法でやろうとしたが、"aab", "aba"みたいな、同じ文字が二つ入っているものは{a, b}に縮減されてしまって条件を満たさないことに気づいた。
//自分でやったstep1。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Map; キーをstr, 値をcharSetにする Setはコレクションだから要素はcharではなくてCharacterにする 対応関係
        //mapのキーは一意！（重複なし、setと同じ）　値は一意ではない！
        Map<Set<Character>, String> map = new HashMap<>();    
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            Set<Character> eachCharacterSet = new HashSet<>();
            for (char c : str.toCharArray()) {
                eachCharacterSet.add(c);
            }
            if (map.containsKey(str)) {
                result.add(str);
            }
            //一回見かけたmapのキー=keySetを、マップに登録する
            map.put(eachCharacterSet, str);

            //List<Set<char>> setList = new ArrayList<>();

            }         
        }
        return result;
    }
}
