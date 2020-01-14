/*
 * @Author: lsd
 * @Date: 2020-01-14 21:09:09
 * @Description: 
 * @Software: vscode
 */
package cn.andios.lc;

public class Test203 {

    public static void main(String[] args) {
        int [] arr = new int []{1,2,6,3,4,5,6};
        ListNode8 head = new ListNode8(Integer.MAX_VALUE);
        ListNode8 tail = head;
        ListNode8 newNode = null; 
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode8(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        // while(head != null){
        //     System.out.print(head.val + "\t");
        //     head = head.next;
        // }

        ListNode8 listNode = removeElements(head.next, 6);
        while(listNode != null){
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
    }
    public static ListNode8 removeElements(ListNode8 head, int val) {
        ListNode8 header1 = new ListNode8(Integer.MAX_VALUE);
        ListNode8 header2 = new ListNode8(Integer.MAX_VALUE);
        header1.next = head;
        header2 = header1;
        while(header1.next != null){
            if(header1.next.val == val){
                header1.next = header1.next.next;
            }else{
                header1 = header1.next;
            }
        }
        return header2.next;
    }
}

 
class ListNode8 {
    int val;
    ListNode8 next;
    ListNode8(int x) { val = x; }
}
 