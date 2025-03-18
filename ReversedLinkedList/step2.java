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
        ListNode prev = null;//0
        ListNode curr = head;//1
        while (curr != null) {
            ListNode nextTemp = curr.next;//2
            curr.next = prev;//2の位置に0を代入
            prev = curr;//0の位置に1を代入
            curr = nextTemp;//1の位置に２を代入
        }
        return prev;
    }
}
