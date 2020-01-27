/*
 * @Author: lsd
 * @Date: 2020-01-27 15:16:31
 * @Software: vscode
 * @Description: 环形链表解决链表旋转问题
 *  
 */
package cn.andios.lc;

public class Test61 {
    public static void main(String[] args) {
        ListNode16 header = new ListNode16(Integer.MAX_VALUE);
        ListNode16 tail = header;
        ListNode16 newNode = null;
        int arr [] = new int[]{1,2};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode16(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        // header = header.next;
        // while(header != null){
        //     System.out.print(header.val + "\t");
        //     header = header.next;
        // }
        ListNode16 list1 =  rotateRight1(header.next, 2);
        //ListNode16 list2 =  rotateRight2(header.next, 2);
        while(list1 != null){
            System.out.print(list1.val);
            list1 = list1.next;
        }
    }
    public static ListNode16 rotateRight1(ListNode16 head, int k) {
        //非空判断
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode16 tail = head;
        ListNode16 header = head;
        
        int count = 1;
        //获得链表长度，并把 tail指向链表尾
        while(tail.next != null){
            tail = tail.next;
            count ++;
        }
        //真正右移的次数为 (k % 链表长度)
        k = k % count;
        if(k == 0){
            return head;
        }
        //tail指向链表尾，形成环形链表，
        //******
        //  这里形成环形链表必须在判断 “ k是否为0，如果为0就返回head之后 ”，
        //  因为如果在这之前就形成环形链表,一旦直接返回了head，那么就返回了一个环形链表
        // ******
        tail.next = head;
        //此时 header指向头
        //真正右移的次数为 k，那么倒数第 k个节点就是头节点，
        //倒数第 k + 1个节点就是头节点的前一个节点，我们就是要找到这个节点记为 tmp
        for (int i = 0; i < count - (k + 1); i++) {
            header = header.next;
        }
        ListNode16 tmp = header.next;
        header.next = null;
        return tmp;
    }

    public static ListNode16 rotateRight2(ListNode16 head, int k) {
        //非空判断
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode16 header = head,tailer = head,tailNode = head;
        int count = 1;
        //获得链表长度，并把 tailer,tailNode指向链表尾
        while(tailer.next != null){
            tailer = tailer.next;
            tailNode = tailNode.next;
            count ++;
        }
        //真正右移的长度为 (k % 链表长度)
        k = k % count;
        if(k == 0){
            return head;
        }
        //形成环形链表
        //******
        //  这里形成环形链表必须在判断 “ k是否为0，如果为0就返回head之后 ”，
        //  因为如果在这之前就形成环形链表,一旦直接返回了head，那么就返回了一个环形链表
        // ******
        tailNode.next = head;
        //此时,header指向头，tailer指向尾，
        //header永远指向最终返回的头，tailer永远指向最终返回的尾
        //那么
        //链表右移 1位，相当于 header和 tailer指针右移 (count - 1) 位
        //链表右移 k位，相当于 header和 tailer指针右移 (count - 1)k 位
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < count - 1; j++) {
                header = header.next;
                tailer = tailer.next;
            }
            
        }
        //移完后，断开环，返回header
        tailer.next = null;
        return header;
    }
    
}
class ListNode16 {
    int val;
    ListNode16 next;
    ListNode16(int x) {
        val = x;
    }
}