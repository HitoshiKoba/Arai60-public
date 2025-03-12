//わからなかったのでchatGPT-O1で生成。一行一行写経。
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
 //各ノードの値と繰り上がり（carry）を足し合わせながら新しい連結リストを作成する。
 //
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        //create carry
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            //今いる桁での計算　carryは一個前の桁からの繰り上がりがあれば
            int sum = x + y + carry;
            //桁あがりがあるのなら、carryに記録
            carry = sum/10;
            //１０で割った余りが、この桁の値。
            int digit = sum % 10;
            //新しいリストに新しいノードを追加
            current.next = new ListNode(digit);
            //現在のリストの末尾ノードを示す変数currentを、更新（上書き）
            current = current.next;
            //l1やl2がnullでなければ、それらを次のノードに進める。
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
    return dummyHead.next;
    }
}
