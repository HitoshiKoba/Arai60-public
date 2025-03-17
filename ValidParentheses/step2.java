chatGPTの写経.
写経しつつ考えたことをコメントアウトで書きます.

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //Character型を初めて見た（charは知っていた←intなどと同じ基本型で一文字を扱う型。Character型はcharのラッパークラスで、一文字をオブジェクトとして扱えるようにするものらしい。Integerと同じ枠組み。）
        //コレクションを扱うときはCharacter型が良いらしい。← コレクションは要素もオブジェクトとして扱うから。
        Stack <Character> stack = new Stack<>();

        //文字列の各文字を順番に走査
        //Stringの内部ではcharの配列を使って文字列を管理している。
        for (char c : s.toCharArray()) {
            //char型のときは'' ←→　Stringの時は""。コンパイラが厳密に区別する。
            if (c == '('|| c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }//elseは続いている

                //5. スタックのトップ（一番上）を取り出し、対応する”開きカッコ”か確認 <-同時に、一番上をstackから削除。
                char top = stack.pop();
                //取り出したtopと、else節内に入ってきたｃが合致するか 合致しないものを全て条件として出す
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                        return false;
                }
            }
        }
        //走査が終わった段階で、スタックが空なら、全て正しく対応している　←　stack.push()で積んで、stack.pop()で取り出している。
        return stack.isEmpty();
    }
} 

・感想
大枠としては、
①一文字ずつ判定する枠組み　for (char c : s.toCharArray()) {
②

