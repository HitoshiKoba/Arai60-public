//step2
解答をchatGPTで出力し、少し時間を置いてから、もう一回自分で書いてみた。コードを通した。
行ったこと：
  ポインタを学習した。
  head.nextとslow.nextが同じものを指すことを認識した。

次行うこと：
  ①C++で、同じ問題を解いてみる
  ②リンクリストサイクル２をjavaで解く

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
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        } 
        return false;   
    }
}
