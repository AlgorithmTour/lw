package cn.andios;
/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月30日下午7:23:56
 *
 */
public class Test86 {
	 public static ListNode4 partition(ListNode4 head, int x) {
		 /**
		  * 构造两个链表，分别存 < x 和 >= x的节点
		  * 
		  */
		 ListNode4 listNode1 = new ListNode4(0);
		 ListNode4 head1 = listNode1;
		 
		 ListNode4 listNode2 = new ListNode4(0);
		 ListNode4 head2 = listNode2;
		 
		 /**
		  * 	第一次：
		  * 	   head1    head
		  * 		0->null   0->10->15->14->13->12->null
		  * 	变为        head1	   head
		  * 		0->0->null	10->15->14->13->12->null
		  */
		 while(head != null) {
			 if(head.val < x) {
				head1.next = head;
				head1 = head1.next;
				head = head.next;
				head1.next = null;
			 }else {
				 head2.next = head;
				 head2 = head2.next;
				 head = head.next;
				 
				 head2.next = null;
			 }
		 }
		 head1.next = listNode2.next;
		 
	     return listNode1.next;
	 }
	 public static void main(String[] args) {
		//尾插法构造链表
		ListNode4 head = new ListNode4(0);
		ListNode4 newNode = null;
		ListNode4 tail = null;
		tail = head;
		
		int [] arr = new int[] {10,15,14,13,12};
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode4(arr[i]);
			tail.next = newNode;
			tail = newNode;
		}
		
//		while(head!= null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		
		ListNode4 partition = partition(head, 14);
		
		while(head!= null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}


class ListNode4 {	
    int val;
    ListNode4 next;
    ListNode4(int x) { val = x; }
}
