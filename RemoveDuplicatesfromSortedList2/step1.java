//did not run
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
 //一個ずらし？　自分自身も消す必要　
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null) {
            while (current.val == curent.next.val) {
                current.next = current.next.next;
                current = current.next
            }
        }
    }
}
