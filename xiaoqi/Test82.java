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
	// 方法一：
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
	// 方法二
	public static ListNode deleteDuplicates2(ListNode head) {
		ListNode newHead = new ListNode(0); // 构建哑结点
		newHead.next = head;
		ListNode pre = newHead;
		ListNode cur = head;
		Boolean flag = false; // 建立哑结点
		while(cur!=null && cur.next!=null) {
			if(cur.val == cur.next.val) {
				cur.next = cur.next.next;
				flag = true;// 有重复的将flag设置为true，方便后面删除当前的cur
			}else {
				if(flag) {
					// 如果前面有重复的，则要删除当前的cur
					pre.next = cur.next;
					cur = cur.next;
					// 删除当前的cur之后要将flag设置为false
					flag = false;
				}else {
					// 如果没有重复的，pre与cur都向后移位
					pre = cur;
					cur = cur.next;
				}
			}
		}
		// 防止尾重复 再判断一次
		if(flag) {
			pre.next = cur.next;
			cur = cur.next;
		}
		return newHead.next;

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,2,2};
		ListNode head = create(arr, 4);
		ListNode newHead =  deleteDuplicates(head);
		printList(newHead);
	}

}
