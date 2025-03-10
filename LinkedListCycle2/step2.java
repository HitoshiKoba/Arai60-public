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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null && head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;                
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// 解答(GPTの生成)を見て、それから小田さんの、LinkedListCycle２の解説を読んだ。
// 理解できた。
//    自分のために言語化すると、
//    1. slowをリンクリストの先頭ノードを指すポインタ（head）まで戻す
//    2.　一歩ずつ歩いていって、slowとfastが一致する点が、リンクリストのサイクルの開始ノード
//    3.　2.はなぜか。↓
//   最初の衝突地点のノード名称をcollisionとし、サイクル開始ノードの名称をbeginpointとすると、

//   collision - head　が、カメが歩くぶんの距離
//   亀が、後ろ向き歩きで　collision - head まで巻き戻し歩きをする間に、亀と等ステップで後ろ向き歩きするうさぎは、collisionに至る。なぜなら、うさぎは亀の二倍の距離歩いたはずなので、collisionにいて、もう一回|collision - head|ぶんの距離が残っていないと、辻褄が合わないからである。

//   collision - head = (collision - beginpoint) + (beginpoint - head)　であり、(collision - beginpoint)のぶんは、亀とうさぎは共有している。
//   うさぎは、亀が｜head - beginpoint｜ぶんの距離を（すなわちbeginpointまで）歩く間に、前向き方向で、fast = fast.nextし続け（サイクルを前向きに進み）、collisionからbeginpointに至る。beginpointで両者は出会う。

  
  
