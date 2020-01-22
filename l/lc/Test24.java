/*
 * @Author: lsd
 * @Date: 2020-01-22 13:30:58
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test24 {
    public static void main(String[] args) {
        ListNode11 head = new ListNode11(Integer.MAX_VALUE);
        ListNode11 newNode = null;
        int [] arr = new int []{1,2,3,4};
        for (int i = arr.length - 1; i >= 0; i--) {
            newNode = new ListNode11(arr[i]);
            newNode.next = head.next;
            head.next = newNode;
        }

        // head = head.next;
        // while(head != null){
        //     System.out.print(head.val+"\t");
        //     head = head.next;
        // }
        ListNode11 list = swapPairs(head.next);
        while (list != null) {
            System.out.print(list.val+"\t");
            list = list.next;
        }
    }
    public static ListNode11 swapPairs(ListNode11 head) {
        ListNode11 list = new ListNode11(Integer.MAX_VALUE);
        list.next = head;

        ListNode11 pre = list;
        while(pre.next != null && pre.next.next != null){
            ListNode11 node1 = pre.next;
            ListNode11 node2 = node1.next;
            ListNode11 next = node2.next;

            node2.next = node1;
            node1.next = next;
            pre.next = node2;

            pre = node1;
        }

        return list.next;
    }
}

class ListNode11 {
    int val;
    ListNode11 next;
    ListNode11(int x) {
        val = x;
    }
}
 