/*
 * @Author: lsd
 * @Date: 2020-01-29 13:02:45
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test234 {
    public static void main(String[] args) {
        ListNode18 header = new ListNode18(Integer.MAX_VALUE);
        ListNode18 tail = header;
        ListNode18 newNode = null;
        int arr [] = new int[]{1,1,2,1};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode18(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        header = header.next;

       System.out.println(isPalindrome(header));
        
    }
    public static boolean isPalindrome(ListNode18 head) {
        //本题中head为null判定为true
        if(head == null || head.next == null){
            return true;
        }
        //slow、fast起始指向头节点(不是哑结点)，执行以下循环后，将链表一分为二，
        //第一段： [head,pre]，第二段[slow,fast]，
        //如果原链表节点为奇数个，fast不为null,
        //如果原链表节点为偶数个，fast为null,
        ListNode18 fast = head,slow = head,pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        //将第二段链表翻转,翻转之后头节点为 preNode
        ListNode18 preNode = null;
        ListNode18 curNode = slow;
        ListNode18 nextNode = null;
        while(curNode != null){
            nextNode = curNode.next;

            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        //比较两段链表
        while(head != null && preNode != null){
            if(head.val != preNode.val){
                return false;
            }
            head = head.next;
            preNode = preNode.next;
        }
        return true;
    }
}
class ListNode18 {
    int val;
    ListNode18 next;
    ListNode18(int x) {
        val = x;
    }
}