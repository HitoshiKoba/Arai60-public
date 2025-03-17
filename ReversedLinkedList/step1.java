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
 //head.next.next
//最後のやつを表に持ってくる というやり方もあると思う
//隣あう二つを交互に交代していく？
//currentを最後まで持っていって、最後の一つを使えなくして次のループを始めるにはどうしたら良いか、分からなかった。

class Solution {
    public ListNode reverseList(ListNode head) {
        //ListNode dummyHead = new ListNode(0, head);
        ListNode current = head;
        int left = 0;

        while (current != null && current.next != null) {
            left = current.val;
            current.val = current.next.val;
            current.next.val = left;
            current = current.next;
            if (current.next == null) {
                continue;
            }            
        }
        return head;
    }
}
