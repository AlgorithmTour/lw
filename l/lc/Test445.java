/*
 * @Author: lsd
 * @Date: 2020-01-13 12:17:20
 * @Description: 
 * @Software: vscode
 */
package cn.andios;

import java.util.Stack;

public class Test445 {
    public static void main(final String[] args) {
        // 尾插法创建head1、head2两个链表
        final ListNode7 head1 = new ListNode7(Integer.MAX_VALUE);
        final ListNode7 head2 = new ListNode7(Integer.MAX_VALUE);
        ListNode7 tail1 = head1;
        ListNode7 tail2 = head2;

        ListNode7 newNode = null;

        final int[] arr1 = new int[] { 5 };
        final int[] arr2 = new int[] { 5 };

        for (int i = 0; i < arr1.length; i++) {
            newNode = new ListNode7(arr1[i]);
            tail1.next = newNode;
            tail1 = tail1.next;
        }
        for (int i = 0; i < arr2.length; i++) {
            newNode = new ListNode7(arr2[i]);
            tail2.next = newNode;
            tail2 = tail2.next;
        }

        // while(head1.next != null){
        // System.out.print(head1.next.val+"\t");
        // head1 = head1.next;
        // }
        // System.out.println("\n**************************************");
        // while(head2.next != null){
        // System.out.print(head2.next.val+"\t");
        // head2 = head2.next;
        // }

        ListNode7 listNode = addTwoNumbers(head1.next, head2.next);
        while(listNode != null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }
    }

    public static ListNode7 addTwoNumbers(ListNode7 l1, ListNode7 l2) {

        ListNode7 listNode = new ListNode7(Integer.MAX_VALUE);
        ListNode7 newNode = null;

        Stack stack1 = new Stack<Integer>();
        Stack stack2 = new Stack<Integer>();
        // 链表元素装入stack
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        //表示进位
        int s = 0;
        int sum = 0;
        int e1,e2;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            e1 = !stack1.isEmpty() ?((Integer)stack1.pop()).intValue() : 0;
            e2 = !stack2.isEmpty() ?((Integer)stack2.pop()).intValue() : 0;
           
            sum = e1 + e2 + s; 
            //尾插法构建链表
            newNode = new ListNode7(sum % 10 );       
            newNode.next = listNode.next;
            listNode.next = newNode;
             
            //更新进位
            s = sum / 10;
        }
        //最后还要判断一次
        if(s != 0){
            newNode = new ListNode7(s);
            newNode.next = listNode.next;
            listNode.next = newNode;
        }
        return listNode.next;
    }
}

/**
 * 节点类
 */
class ListNode7 {
    int val;
    ListNode7 next;

    ListNode7(final int x) {
        val = x;
    }
}