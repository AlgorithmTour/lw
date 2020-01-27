/*
 * @Author: lsd
 * @Date: 2020-01-27 11:08:10
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test237 {
    public static void deleteNode(ListNode14 node) {
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }
}
class ListNode14 {
    int val;
    ListNode14 next;
    ListNode14(int x) {
        val = x;
    }
}