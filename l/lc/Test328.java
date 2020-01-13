package cn.andios;
/**
 * 
 * @author LSD
 *
 * @datetime 2020年1月1日下午8:06:43
 *
 */
public class Test328 {
	public static ListNode5 oddEvenList(ListNode5 head) {
		/**
		 * 构造两个链表，分别存奇数位的节点和偶数位的节点，
		 * 遍历完后再让偶数节点接在奇数节点后面，做法类似86
		 */
	    ListNode5  odd = new ListNode5(0);
	    ListNode5 even = new ListNode5(0);
	    
	    ListNode5  oddHead = odd;
	    ListNode5  evenHead = even;
	    
	    while(head != null) {
	    	//将当前head放到odd末尾
	    	oddHead.next = head;
	    	head = head.next;
	    	oddHead = oddHead.next;
	    	oddHead.next = null;
	    	
	    	//将当前head放到even末尾
	    	if(head != null) {
	    		evenHead.next = head;
		    	head = head.next;
		    	evenHead = evenHead.next;
		    	evenHead.next = null;
	    	}
	    }
	    oddHead.next = even.next;
		return odd.next;
	}
	public static void main(String[] args) {
		//构造链表
		ListNode5 head = new ListNode5(0);
		ListNode5 tail = head;
		ListNode5 newNode = null;
		int []arr = new int[] {1,2,3,4,5};
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode5(arr[i]);
			tail.next = newNode;
			tail = newNode;
		}
		
//		while(head!= null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		ListNode5 oddEvenList = oddEvenList(head);
		while(oddEvenList!= null) {
			System.out.println(oddEvenList.val);
			oddEvenList = oddEvenList.next;
		}
	}
}

class ListNode5 {    
	int val;
    ListNode5 next;
    ListNode5(int x) { val = x; }
}
 