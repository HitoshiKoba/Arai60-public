chatGPTの写経.
写経しつつ考えたことをコメントアウトで書きます.

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //Character型を初めて見た（charは知っていた←intなどと同じ基本型で一文字を扱う型。Character型はcharのラッパークラスで、一文字をオブジェクトとして扱えるようにするものらしい。Integerと同じ枠組み。）
        //コレクションを扱うときはCharacter型が良いらしい。← コレクションは要素もオブジェクトとして扱うから。
        Stack <Character> stack = Stack<>();

        //文字列の各文字を順番に走査
        //Stringの内部ではcharの配列を使って文字列を管理している。
        for (char c : s.toCharArray()) {
            //char型のときは'' ←Stringの時は""。コンパイラが厳密に区別する。
            if (c == '('|| c == '{' || c == '[') {

            }

        }


}
  
