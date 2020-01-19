package algorithm;
/**
 * @data 1/19
 * @author xiaoqi
 * @题目：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
		示例 1:
		输入: 1->2->3->4->5->NULL
		输出: 1->3->5->2->4->NULL
   @思路： 构建奇偶链表。
 */
public class Test328 {
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
	 public static ListNode oddEvenList(ListNode head) {
		 if(head == null) {
			 return null;
		 }
		 ListNode list1 = new ListNode(0); // 奇链表
		 ListNode tail1 = list1;
		 ListNode list2 = new ListNode(0); // 偶链表
		 ListNode tail2 = list2;
		 ListNode cur = head;
		 int num = 1;
		 while(cur != null) {
			 if(num % 2 != 0) {
				 tail1.next = cur;
				 tail1 = tail1.next;
			 }else {
				 tail2.next = cur;
				 tail2 = tail2.next;
			 }
			 num++;
			 cur = cur.next;
		 }
		 // 避免成环
		 tail2.next = null;
		 // 连接奇链表与偶链表
		 tail1.next = list2.next;
		 // 返回奇链表哑结点的下一个结点
		return list1.next;   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		ListNode head = create(arr, 5);
		ListNode newHead =  oddEvenList(head);
		printList(newHead);
	}

}
