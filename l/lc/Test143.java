/*
 * @Author: lsd
 * @Date: 2020-01-29 09:57:26
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test143 {
    public static void main(String[] args) {
        ListNode17 header = new ListNode17(Integer.MAX_VALUE);
        ListNode17 tail = header;
        ListNode17 newNode = null;
        int arr [] = new int[]{1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode17(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        header = header.next;

        reorderList(header);

        while(header != null){
            System.out.print(header.val + "\t");
            header = header.next;
        }

    }
    public static void reorderList(ListNode17 head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode17 slow = head;
        ListNode17 fast = head;
        ListNode17 pre = null;
        //slow、fast起始指向头节点(不是哑结点)，执行以下循环后，将链表一分为二，
        //第一段： [head,pre]，第二段[slow,fast]，
        //如果原链表节点为奇数个，fast不为null,
        //如果原链表节点为偶数个，fast为null,
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        //将第二段链表翻转,翻转之后头节点为 preNode
        ListNode17 preNode = null;
        ListNode17 curNode = slow;
        ListNode17 nextNode = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        //将两段链表合并为一段
        ListNode17 header = new ListNode17(Integer.MAX_VALUE);
        ListNode17 list = header;
        while(head != null && preNode != null){
            list.next = head;
            head = head.next;
            
            list.next.next = preNode;
            preNode = preNode.next;

            list = list.next.next;
        }
        if(preNode != null){
            list.next = preNode;
        }
        head = header.next;
    }
}
class ListNode17 {
    int val;
    ListNode17 next;
    ListNode17(int x) {
        val = x;
    }
}