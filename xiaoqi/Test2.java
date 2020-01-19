package algorithm;
/**
 * @data 1/19
 * @author xiaoqi
 * @题目：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
		如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
		您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
		示例：
		输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
		输出：7 -> 0 -> 8
		原因：342 + 465 = 807
 
 */
public class Test2 {
	// 创建链表
				public static ListNode create(int arr[], int n) {
					if(n == 0 ) {
						return null;
					}
					// 将数组的第一个元素赋给头指针
					ListNode head =  new ListNode(arr[0]);
					ListNode curNode = head;
					// 依次赋值
					for(int  i = 1; i < n;i++) {
					    curNode.next = new ListNode(arr[i]);
						curNode = curNode.next;
					}
					return head;
				}
				// 打印链表
				public static void printList(ListNode head) {
					ListNode curNode = head;
					while(curNode != null) {
						System.out.print(curNode.val + "->");
						curNode = curNode.next;
					}
					System.out.print("NULL");
				}
				
	 public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode cur1 = l1;
		 ListNode cur2 = l2;
		 ListNode head = new ListNode(0);// 建新链表
		 ListNode cur3 = head; 
		 int n = 0;// n为进位数，满10进一
		 while(cur1 != null && cur2!= null) {
			 cur3  = cur3.next = new ListNode(0);
			 int num = cur1.val +cur2.val + n;
			 cur3.val = num %10 ;
			 n = (int) Math.ceil( num /10);	
			 cur1 = cur1.next;
			 cur2 = cur2.next;
			 // 防止最后一位时，还要给新链加新结点
//			 if(cur1!= null && cur2 != null ) {
//				
//			 }
//			
		 }
		 // 如果链表l1还有剩余,继续加结点
		 if(cur1!= null) {
			 while(cur1 != null) { 
				 cur3 = cur3.next = new ListNode(0);
				 cur3.val = (cur1.val + n) %10;
				 n = (int) Math.ceil( (cur1.val + n) /10);	
				 cur1 = cur1.next;
			 }
		 }
		 // 如果是链表l2还有剩余，继续加节点
		 if(cur2!= null) {
			 while(cur2 != null) { 
				 cur3  = cur3.next = new ListNode(0);
				 cur3.val = (cur2.val + n) %10;
				 n = (int) Math.ceil( (cur2.val + n) /10);
				 cur2 = cur2.next;
			 }
		 }
		 // 如果都没有剩余,两个链表位数一样，考虑最后的两数之和是否大于10，如果大于就加一位，值为n
		 if( n > 0) {
			 cur3.next = new ListNode(n);
		 }
	
		 return head.next;     
	    }
	public static ListNode  shengyu (ListNode cur ,ListNode cur3, int n) {
			 while(cur != null) { 
				 cur3 = cur3.next = new ListNode(0);
				 cur3.val = (cur.val + n) %10;
				 n = (int) Math.ceil( (cur.val + n) /10);
				 cur = cur.next;
			 }
			 return cur3;
		 } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1};
		int[] arr2 = {9,9};
		ListNode head1 = create(arr1, 1);
		ListNode head2 = create(arr2, 2);
		ListNode newHead =  addTwoNumbers(head1, head2);
		printList(newHead);
	}

}
