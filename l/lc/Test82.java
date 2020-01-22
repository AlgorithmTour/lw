/*
 * @Author: lsd
 * @Date: 2020-01-14 21:09:09
 * @Description: 
 * @Software: vscode
 */
package cn.andios.lc;

public class Test82 {
    public static void main(String[] args) {
        int [] arr = new int []{1,2,3,3,4,4,5};
        ListNode9 head = new ListNode9(Integer.MAX_VALUE);
        ListNode9 tail = head;
        ListNode9 newNode = null; 
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode9(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        // while(head != null){
        //     System.out.print(head.val + "\t");
        //     head = head.next;
        // }

        ListNode9 listNode = deleteDuplicates(head.next);
        while(listNode != null){
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
    }
    public static ListNode9 deleteDuplicates(ListNode9 head) {
        if(head == null || head.next == null){
            return head;
        }
        //虚拟头节点
        ListNode9 header = new ListNode9(Integer.MAX_VALUE);
        
        header.next = head;
        //快慢指针
        //慢指针指向虚拟头节点，记录最后返回的链表的节点
        ListNode9 slow = header;
        //快指针遍历链表
        ListNode9 fast = header.next;
        //快指针与快指针.next是否重复的标志
        boolean isDump;
        while(fast != null){
            isDump = false;
            //如果重复了，快指针就一直后移
            while(fast.next != null && fast.val == fast.next.val){
                isDump = true;
                fast = fast.next;        
            }
            //一旦没重复，就把快指针节点添加到慢指针中
            if(!isDump){
                slow.next = fast;
                slow = slow.next;
            }
            //快指针后移
            fast = fast.next;
        }
        slow.next = null;
        return header.next;
    }
}

 
class ListNode9 {
    int val;
    ListNode9 next;
    ListNode9(int x) { val = x; }
}
 