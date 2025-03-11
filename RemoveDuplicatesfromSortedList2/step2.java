//chatGPTで回答生成後、見ながら回答
//難しい。duplicatedValueを作ることを忘れていた。current にdummyでなくheadを代入していた。
//　if -> whileの流れ　while内で、ポインタ（参照）変数の値を更新していく流れ　

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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            
            if (current.next.val == current.next.next.val) {
                int duplicateValue = current.next.val;
                while (current.next != null && current.next.val == duplicateValue) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
