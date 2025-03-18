/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//currとheadが紛らわしかったので、一旦headだけでかいてみた。
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }    
}

//清書した。処理の流れを追った考えはコメントに。
class Solution {
    public ListNode reverseList(ListNode head) {
        //反転したリストにおいて、最後のノードが指す先がnull←これにてwhile文終了
        ListNode prev = null;
        //headと同じ機能・指し先を持ち、リスト内で走査する役割を果たす変数current
        ListNode current = head;

        //currentがnullになったら終わり
        while (current != null) {
            //必要なノードを一時置いておける変数temp
            ListNode temp = current.next;
            //ポインタの付け替え
            current.next = prev;
            //prevを一個先に移動
            prev = current;
            //currentを一個先に移動
            current = temp;
        }
        return prev;
    }
}

//思ったことの書き起こし
//・時間計算量をふんわりとだけ知っていて、この処理は実質的にはポインタの付け替え（と、それに必要な変数の準備と、位置の移動に必要な代入（上書き））を繰り返すだけなので、自分が考えた「隣あう二つのノードの入れ替えを繰り返して逆順リストを作る」よりも計算時間が短く済みそうだなと思った。
