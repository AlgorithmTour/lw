/*
 * @Author: lsd
 * @Date: 2020-01-27 12:47:51
 * @Software: vscode
 * @Description: 删除链表倒数第n个节点
 *  用双指针 p,q 先让p指向头，再移动q让p和q相隔(n+1)个节点，同时移动p,q 让q移到末尾，此时p就是
 * 待删除元素的前一个元素
 */
package cn.andios.lc;

public class Test19 {
    public static void main(String[] args) {
        ListNode15 header = new ListNode15(Integer.MAX_VALUE);
        ListNode15 tail = header;
        ListNode15 newNode = null;
        int arr [] = new int[]{1};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode15(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        // header = header.next;
        // while(header != null){
        //     System.out.print(header.val + "\t");
        //     header = header.next;
        // }
        ListNode15 list =  removeNthFromEnd(header.next, 1);
        while(list != null){
            System.out.print(list.val);
            list = list.next;
        }
    }
    public static ListNode15 removeNthFromEnd(ListNode15 head, int n) {
        ListNode15 header = new ListNode15(Integer.MAX_VALUE);
        header.next = head;
        
        //这里p，q初始时不能指向head,而应该指向哑结点，因为删除的元素可能就是head
        //ListNode15 p = head,q = head;
        ListNode15 p = header,q = header;

        for (int i = 0; i < n; i++) {
            q = q.next;
        }
        while(q.next != null){
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return header.next; 
    }
}
class ListNode15 {
    int val;
    ListNode15 next;
    ListNode15(int x) {
        val = x;
    }
}