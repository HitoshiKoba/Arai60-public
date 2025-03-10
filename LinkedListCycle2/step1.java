import java.util.ArrayList;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //戦略
 //順序付き配列、Arrayリストに、メモリアドレスを格納する
//サイクルが始まるところで、contains()で引っかかるはずだから、そこのarrayListのインデックスをgetする。その順番にあるListNodeを返したかった。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ArrayList <ListNode> list = new ArrayList<>();
        ListNode current = head;
        while(current != null) {
            if (list.contains(current)) {
            int i = list.indexOf(current);
            return ;
            }
            list.add(current);
            current = current.next;
        }
        return null;
    }
}
