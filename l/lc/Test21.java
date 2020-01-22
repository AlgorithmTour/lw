/*
 * @Author: lsd
 * @Date: 2020-01-22 12:02:05
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test21 {
    public static void main(final String[] args) {
        final ListNode10 list1 = new ListNode10(Integer.MAX_VALUE);
        final ListNode10 list2 = new ListNode10(Integer.MAX_VALUE);

        ListNode10 newNode = null;
        ListNode10 tailNode = null;

        final int[] arr1 = new int[] { 1, 2, 4 };
        final int[] arr2 = new int[] { 1, 3, 4 };

        tailNode = list1;
        for (int i = 0; i < arr1.length; i++) {
            newNode = new ListNode10(arr1[i]);
            tailNode.next = newNode;
            tailNode = tailNode.next;
        }

        tailNode = list2;
        for (int i = 0; i < arr2.length; i++) {
            newNode = new ListNode10(arr2[i]);
            tailNode.next = newNode;
            tailNode = tailNode.next;
        }

        // list1 = list1.next;
        // while(list1 != null){
        // System.out.print(list1.val + "\t");
        // list1 = list1.next;
        // }

        // list2 = list2.next;
        // while(list2 != null){
        // System.out.print(list2.val + "\t");
        // list2 = list2.next;
        // }
        ListNode10 listNode = mergeTwoLists(list1.next, list2.next);
        while(listNode != null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }

    }

    public static ListNode10 mergeTwoLists(ListNode10 l1,  ListNode10 l2) {
        ListNode10 list = new ListNode10(Integer.MAX_VALUE);
        ListNode10 listTmp = list;

        
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                list.next = l1;
                l1 = l1.next;
            }else{
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        while(l1 != null){
            list.next = l1;
            list = list.next;
            l1 = l1.next;
        }
        while(l2 != null){
            list.next = l2;
            list = list.next;
            l2 = l2.next;
        }
        return listTmp.next;
    }
}

class ListNode10 {
    int val;
    ListNode10 next;

    ListNode10(final int x) {
        val = x;
    }
}
 