package algorithm;
/**
 * @date 1/30
 * @param xiaoqi
 * @题目： 
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

	示例 1:
	输入: 1->2->3->4->5->NULL, k = 2
	输出: 4->5->1->2->3->NULL
	
	示例 2:
	输入: 0->1->2->NULL, k = 4
	输出: 2->0->1->NULL
   @思路，先求出链表长度len，在将尾结点与头结点连接，形成环，（避免k大于len） ，再遍历找到分界点（遍历的次数是 (len- k%len)次，因为当k>len时，旋转链表就会开始循环）
 
 */
public class Test61 {
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
	
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		ListNode newHead = null;
		ListNode QNode = head;
		int len = 1;
		// 得到链表长度
		while(QNode.next != null) {
			QNode = QNode.next;
		    len ++;
		}
		// 将尾指针的next指向头指针,使其成环
		QNode.next = head;
		
		// 避免k大于len，如果大于len,旋转的与之前一样
		int x = (len -(k%len));
		
		// 找到分界点
		for(int i = 0; i < x;i++) {
			QNode = QNode.next;
		}
		// 分界点下一个节点就是新链表的头结点
		newHead = QNode.next;
		QNode.next = null;
		
		return newHead;
		      
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		ListNode head = create(arr, 3);
		ListNode newHead =  rotateRight(head,4);
		printList(newHead);
	}

}
