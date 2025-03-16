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

        //↓1->2->5の場合、やる意味がある(current.next.nextで５が指されている)。1->2->3->3の場合、答えは１,2になる。
        while (current.next != null && current.next.next != null) {
        //if -> while : もしこうだったら、この（繰り返し）処理を行う
            if (current.next.val == current.next.next.val) {
                int duplicatedValue = current.next.val;
                while (current.next != null && current.next.val == duplicatedValue) {
                    //↓現在ノードから伸びるpointerの変更
                    current.next = current.next.next;//currentNodeが0の時、２個先の1のノードを指す。current.nextの値の更新
                }
            } else {
                //ifの処理が終わったら、現在ノードを先に進める
                current = current.next;
            } //そしてここでまだwhile文の中なので、先頭に戻ってまたwhileの条件判定からリスタート
        }
        return dummy.next;
    }
}
