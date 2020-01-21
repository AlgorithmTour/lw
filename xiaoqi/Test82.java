package algorithm;
/**
 * @data 1/21
 * @author xiaoqi
 * @题目：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

	示例 1:
	输入: 1->2->3->3->4->4->5
	输出: 1->2->5
	
	@思路：构建哑结点，将cur指向哑结点，考虑后面是否有重复元素，如果有，设置temp节点，temp = temp.next,直到将重复的元素全部跳过，cur.next = temp.next;如果没有cur = cur.next.
		使用哑结点完美的避开了(11222)删除头结点的情况。
 */
public class Test82 {
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
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode newhead = new ListNode(0);// 构建哑结点
		newhead.next = head; // 给原链表加一个哑结点
		ListNode cur = newhead; // 将cur赋给哑结点
		// 使用哑结点巧妙的避开了删除头结点的极端情况
		while(cur.next != null && cur.next.next !=null) {
			 
			if(cur.next.val == cur.next.next.val) {
				 ListNode temp = cur.next;
				 while(temp!=null &&temp.next!=null&&temp.val== temp.next.val )
				 { temp = temp.next;}
				 cur.next = temp.next;
			} else {
				cur = cur.next;
			}
			
		}
		return  newhead.next;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,2,2};
		ListNode head = create(arr, 5);
		ListNode newHead =  deleteDuplicates(head);
		printList(newHead);
	}

}
