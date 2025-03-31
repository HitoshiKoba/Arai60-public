import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //これ間違い　Set <Integer> set1 = new HashSet<>(Arrays.asList(nums1)); 適切なint->Integerへのボクシングをする
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> result = new ArrayList<>();
        for (Integer set1Item : set1) {
            if(set2.contains(set1Item)) {
                result.add(set1Item);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

自力回答の方針：
1. 二つの配列をストリームオブジェクトにしてからセットに変換する。
2. set1の各要素が、set2に含まれるか、forEach + set.contains()で検証し、含まれていた場合Arrayリストに追加する
3. ArrayListをストリーム変換しながらArrayに変換し、return resultする。

このコードに対する自分の考え：
空間計算量が、setを二つ作っているから、少しかかるかも。
時間計算量も、streamにバラしているから、どうなんだろうな。意外とかかるのだろうか。
力技でやっている感がすごい
