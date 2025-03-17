import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        //Character型のスタックを用意
        Stack<Character> stack = new Stack<>();

        //for文で一文字ずつ判定の上　スタックに積むか、falseするか、スタックから取り出すか、していく
        for (char c : s.toCharArray()) {
            if (c == '(' ||
                c == '{' ||
                c == '[') {
                    //スタックに積む
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    //スタックから取り出す
                    char top = stack.pop();
                    if ((c == ']' && top != '[') ||
                        (c == '}' && top != '{') ||
                        (c == ')' && top != '(')) {
                            return false;
                        }
                }
        }
        return stack.isEmpty();
    }
}
