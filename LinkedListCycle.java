//write in Java
//初めての提出です、全然わかりませんでした。
考え方のプロセスを以下に書きます。
①どうやったら解けるかをまず考えた。
② trueになるケースなら、node.valの値がグルグルと同じ順番で繰り返すはずだ、と考えた。（3 -> 2 -> 0 -> -4 -> 2-> 0 -> -4 -> ...以下繰り返し。）なので、新しく配列などを作って、そこに値を順番に記録していき、連番の値被りが２回以上起きたら、サイクルがあると判定する、と言うやり方を考えた。だが、入力にくるリンクリストがとても長く、そのオリジナルの入力リンクリストのなかで「連番の値」の繰り返しがあった場合、このやり方ではサイクルがあルカ判別できない、と考え、諦めた。
③別の考え方をしてみた。逆にfalseになるのはどう言う場合か、で考えてみた。ListNode current = head;と定義してみた場合、current = current.next;この代入（値すなわちメモリアドレスの更新）を延々と繰り返し、次の値に行かなくなった場合（値を更新しなくなった場合）、サイクルがないということになり、falseと判定できる。だが、それを実装するやり方がわからなかった。　whileなどを使ってみても、trueの場合は、延々と値の更新を繰り返し続けるのだから、whileループが終わらないのではないか（ずっとループから抜けれないのではないか）と思った。これもダメなのかもしれない。

考え方のヒントがあればぜひいただきたいです。また、進め方のアドバイスがあれば、ぜひ教えていただきたいです。（基本的にleetcodeは考え方のインプット（筋トレ）なのだから、１５分悩んでみてわからなかったら、chatGPTにヒントを聞いたり、答えや考え方のプロセスを聞いたりして良いのか、などについて教えてくださいますと大変嬉しいです。）

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
//     ListNode node1 = new ListNode(3);
//     ListNode node2 = new ListNode(2);
//     node1.next = node2;
//    ListNode current = head;
//     current = node4.next;
//     System.out.println(current.val);
//     current = node2.next;  
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        while (head.next = ) 
        current = head.next;

        
    }
}
