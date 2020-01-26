/*
 * @Author: lsd
 * @Date: 2020-01-26 14:45:33
 * @Software: vscode
 * @Description: 自顶向下归并链表
 */
package cn.andios.lc;

public class Test148 {
    public static void main(String[] args) {
        ListNode13 head = new ListNode13(Integer.MAX_VALUE);
        ListNode13 newNode = null;
        int [] arr = new int []{-1,5,3,4,0};
        for (int i = arr.length - 1; i >= 0; i--) {
            newNode = new ListNode13(arr[i]);
            newNode.next = head.next;
            head.next = newNode;
        }

        // head = head.next;
        // while(head != null){
        //     System.out.print(head.val+"\t");
        //     head = head.next;
        // }
        ListNode13 list =  sortList(head.next);
        while(list != null){
            System.out.println(list.val);
            list = list.next;
        }
    }
    /**
     * 自顶向下归并链表
     * @param head
     * @return
     */
    public static ListNode13 sortList(ListNode13 head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode13 pre = null,slow = head,fast = head;
        //执行这个循环后，fast指向末尾，slow指向中间，pre指向中间的前一个元素
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //将整个链表一分为二
        pre.next = null;

        //将每一半都进行排序               
        ListNode13 l1 = sortList(head);
        ListNode13 l2 = sortList(slow);

        //排序后进行归并,归并后返回
        return merge(l1,l2);
    }
    /**
     * 对两个链表进行归并，和数组差不多
     */
    public static ListNode13 merge(ListNode13 l1,ListNode13 l2){
        ListNode13 header = new ListNode13(Integer.MIN_VALUE);
        ListNode13 pre = header;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }  
            pre = pre.next;
        }  
        while(l1 != null){
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }
        while(l2 != null){
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
        return header.next;
    }
}
class ListNode13 {
    int val;
    ListNode13 next;
    ListNode13(int x) {
        val = x;
    }
}
 