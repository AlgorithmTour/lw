package algorithm;
/**
 * @date: 1/29
 * @author xiaoqi
 * @题目： 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @思路： 使用一个哑结点，两个指针p,q,初始时，让p、q初始时保持两个节点之间的距离为n，之后再将它们同时向后移，直到q指向null。此时的p的下一个节点点就是要删除的节点
 */
public class Test19 {
	
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
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode dummyP = new ListNode(0);
		 ListNode dummyQ = new ListNode(0);
		 ListNode tempNode =  dummyP;
		 dummyP.next = head;
		 dummyQ.next = head;
		 // 先让dummyP,dummyQ保持两节点之间的节点个数为n(即先让q前移n+1次)
		 for(int i = 0;i< n+1;i++) {
			 dummyQ = dummyQ.next;
		 }
		 // 当dummyQ不为null时，dummyP、dummyQ两节点同时向后移
		 while(dummyQ != null) {
			 dummyP = dummyP.next;
			 dummyQ = dummyQ.next;
		 }
		 // 此时dummyP的下一个结点为所要删除的节点
		 dummyP.next = dummyP.next.next;
		 	 
		return tempNode.next;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		ListNode head = create(arr, 5);
		ListNode newHead =  removeNthFromEnd(head,2);
		printList(newHead);
	}

}
