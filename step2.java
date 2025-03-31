import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //アナグラムをグループ化するためのマップ
        //キー：ソートされた文字列、値：元の文字列のリスト
        
        Map<String, List<String>> signToStrings = new HashMap<>();
        
        for (String s : strs) {

            //配列を、アルファベット昇順にソート この下の３つの文はセット！
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            //map（signToStrings）にない場合は新しいリストを作成
            if (!signToStrings.containsKey(sortedStr)) {
                signToStrings.put(sortedStr, new ArrayList<>());
            }

            //マップのキーにsortedStrがある場合は、sをリストに追加する
            signToStrings.get(sortedStr).add(s);
        }
        //マップのバリュー（リスト）を結果リストに変換
        return new ArrayList<>(signToStrings.values());

    }
}
//Mapのネーミング：”キーTo値”にしてみた。signature(署名)To Strings、縮めてsignToStringsと書いたが、マップの値は文字列のリストなのでStringListなどの方が良いか...?
//forループで回すものは、"s"でなくて"str"のような命名の方が良いか？


