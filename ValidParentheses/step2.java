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
                //s.length()が１以上という条件(制約)があるから、下↓のif文書く。
                if (stack.isEmpty()) {
                    return false;
                }//elseは続いている

                //5. スタックのトップ（一番上）を取り出し、対応する”開きカッコ”か確認 <-同時に、一番上をstackから削除。
                //↓ここ、オートアンボクシングしてる　自動型変換
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


大枠の文字起こし
1. 一文字ずつ判定する枠組み　for (char c : s.toCharArray()) {
2. 開きカッコ{, [, ( の場合は、スタックに積む。→ そしてelseに入らずに次のforループへ。
3. elseの場合は、あとは、閉じカッコが、積んだ順番の逆順（LIFO）で来てほしい
4. もしstackが 空なら、s.length()は１以上であるので、}, ], ) が来ていることになり、❌。
5. 閉じカッコが積んだ順番の逆順{([])}で来ているなら、trueにしたい
6. 今回見ているｃが、スタックの一番上に積んだ括弧と同じタイプなら、true。他は全てfalse.
7. stack.pop()は、一番上に積まれている要素を取り出して、配列の最後の要素を削除する動作。 （スタックはコレクションの一種であり、リストListに基づいたデータ構造）スタックの一番上に積まれていた要素が取り出されて、char型のtopに格納された。
8. topに格納されているもの（Last In された要素）と、今見ているcが合致しているかをif文で確認　合致していなければ即座にfalseを返す
9. 成功trueなら、stack.pop()が全て滞りなく行われているはず。確認のためのreturn stack.isEmpty();文。


・スタックの構造を 配列（リスト） で考えると、「ポインタを1個下げる」というより、「配列の最後の要素を削除」 するイメージに近い。
・Stack<E> クラスは 内部的に Vector<E> を使い、可変長の配列でデータを管理。

