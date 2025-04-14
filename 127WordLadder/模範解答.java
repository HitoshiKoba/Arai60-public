import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //不思議な箱と、ただの表を用意 mysterious box, table　←Hash Tableか
        //不思議な箱はPriorityQueueで実装。表はHash Map.

        if (!wordList.contains(endWord)) {
            return 0;
        }
        //探索を高速化するためにハッシュセットに変換
        Set<String> wordSet = new HashSet<>(wordList);//listをsetに入れて初期化

        //priorityQueueの要素Eには何を入れようか。table を入れるのでいいのか。順序づけはラムダ式で定義する気がする
        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((a, b)->a.getValue() - b.getValue(b));
        priorityQueue.offer(new Pair<>(beginword, 1));//始点の距離は１（単語数を数える）

        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Pair<String, Integer> current = priorityQueue.poll();
            //取り出したcurrentWordのKey：「hit」とか　currentWord
            String currentWord = current.getKey();
            String distance = current.getValue();

            //すでに処理済みならスキップ
            if (visited.contains(currentWord)) {
                continue;
            }

            //訪問済みとしてマーク
            visited.add(currentWord);

            if (currentWord.equals(endWord)) {
                return distance;
            }

            //現在の単語から遷移可能な単語を検討 //ここ一番大事　wordCharsを作ったこと
            char[] wordChars = currentWord.toCharArray();

            for (int j = 0; j < wordChars.length; j++) {
                //originalcharは、オリジナルな一単語 最初の一文字目 hitの「h」がoriginalChar
                //xit, hxt, hix すべて走査し、hitから一文字離れたものがwordListにあれば、それをpriorityQueueに加える
                //priorityQueueには、hitからの一文字の差分を持った単語(hotとかhix, sitとか。あれば)が追加される
                //全部追加し終わったら、

                char originalChar = wordChars[j];

                for (char c = 'a'; c <= 'z'; c++) {

                    if (originalChar == c) {
                        continue;
                    }
                    //wordChars[j]にcの値（a, b, c, d, f, g, ...）を代入する。
                    
                    //hitのhをait, bit, cit, ditにしていく
                    wordChars[j] = c;
                    String newWord = new String(wordChars);//変化したwordCharsをもう一回別のストリングにする
                    //すかさずStringにしてnewWordとして格納する

                    //もし、wordSetがnewWordを含み、visitedにまだなかったら、newWordをnewPairとして優先度キュー（不思議な箱）に追加し、distanceを+1する
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        priorityQueue.offer(newPair<>(NewWord, distance + 1));
                    }
                }

                //元の文字に戻す(一個めのforループ)
                wordChars[j]=originalChar;
            }
        }
        //経路が見つからなかった場合
        return 0;
    }
    //K,V は型パラメータ、プレースホルダー　＜＞山括弧の中に書いておくことで、識別子がジェネリック型パラメータであるとコンパイラが認識する
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V Value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    } 
}
