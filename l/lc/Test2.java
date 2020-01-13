package cn.andios;
/**
 * 
 * @author LSD
 *
 * @datetime 2020年1月1日下午8:06:54
 *
 */
public class Test2 {
    public static ListNode6 addTwoNumbers(ListNode6 l1, ListNode6  l2) {
    	ListNode6 head = new ListNode6(Integer.MAX_VALUE);
    	ListNode6 tail = head;
    	
    	ListNode6 newNode = null;
    	//i表示进位，取1或0
    	int i = 0;
    	//sum表示两个链表的两个节点的val相加的值，sum=前一次相加的进位+本次相加的两个节点的val之和
    	int sum = 0;
    	while(l1 != null || l2 != null) {
    		//如果一个链表已经遍历完了，另一个还没，就把这个置为0
    		if(l1 == null) {
    			l1 = new ListNode6(0);
    		}
    		if(l2 == null) {
    			l2 = new ListNode6(0);
    		}
    		//计算sum
    		sum = l1.val + l2.val + i;
    		//因为sum可能会产生进位，所以取sum % 10之后的数
    		newNode = new ListNode6(sum % 10);
    		tail.next = newNode;
    		tail = tail.next;
    		
    		//取进位
    		i = sum / 10;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	//遍历完后，可能还存在进位
    	if(i != 0) {
    		tail.next = new ListNode6(i);
    	}
        return head.next;
    }
	public static void main(String[] args) {
		//构建两个链表
		ListNode6 head1 = new ListNode6(9);
		ListNode6 tail1 = head1;
		
		ListNode6 head2 = new ListNode6(1);
		ListNode6 tail2 = head2;
		
		ListNode6 newNode;
		
		int[] arr = new int[] {9,9,9,9,9,9,9,9,9};
		
//		for (int i = 0; i < arr.length-2; i++) {
//			newNode = new ListNode6(arr[i]);
//			tail1.next = newNode;
//			tail1 = tail1.next;		
//		}
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode6(arr[i]);
			tail2.next = newNode;
			tail2 = tail2.next;		
		}
		//[0]  [9]
//		while(head1 != null) {
//			System.out.print(head1.val+"\t");
//			head1 = head1.next;
//		}
		//[0]  [1,9,9,9,9,9,9,9,9,9]
//		System.out.println();
//		while(head2 != null) {
//			System.out.print(head2.val+"\t");
//			head2 = head2.next;
//		}
		
		ListNode6 addTwoNumbers = addTwoNumbers(head1, head2);
		while(addTwoNumbers != null) {
			System.out.print(addTwoNumbers.val+"\t");
			addTwoNumbers = addTwoNumbers.next;
		}
	}
}
/**
 * 节点类
 */
class ListNode6 {    
	int val;
    ListNode6 next;
    ListNode6(int x) { val = x; }
}
