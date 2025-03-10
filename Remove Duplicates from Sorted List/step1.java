//コード通らず。
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
 //重複値ありsorted!リンクリストを、重複値なしのリスト(setっぽい, HashSet)にする
 //そのリンクリストは、値の昇順に並び替えられた状態で、返す
 //setに変換　リストに戻す　ソートする
 //重そう　空間計算量いりそう　これだと
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        LinkedList <ListNode> list = new LinkedList<>();
        list.add(head);
        while (head.next == null){
            while(head.val == head.next.val) {
                head = head.next;                                
            }
            list.add(head);
        }
        return list;
    }
}
