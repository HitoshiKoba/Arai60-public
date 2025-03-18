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
 //2つのポインタを用意する
 //これまでに反転済みの部分の先頭を指す。初期値はnull
 //
class Solution {
    public ListNode reverseList(ListNode head) {
     //ポインタを付け替える = 変数に格納されている（変数が指している）メモリアドレスを変更する　命令文のみ。valは関係ないようだ。
     //
        ListNode prev = null;//prevにはnullを代入
        ListNode curr = head;//currentは最初のノードインスタンスheadを指す
        while (curr != null) {
            ListNode nextTemp = curr.next;//ノード：ネクスト一時的ノード。 
            curr.next = prev;//2の位置に0を代入 //curr.nextがnullを指すようにする
            prev = curr;//0の位置に1を代入　//prevがheadノードを指すようにする
            curr = nextTemp;//1の位置に２を代入 //currが、nextTempが持っているやつ　＝　head.next、を指すようにする
        }
        return prev;
    }
}
