package algorithm;
/**
 * @date 1/12
 * @author xiaoqi
 * @题目： 反转一个单链表。
	示例:
	输入: 1->2->3->4->5->NULL
	输出: 5->4->3->2->1->NULL
   @思路： 设置三个指针pre cur next 
 * 
 */
 
	 
public class Test206 {
	 public static ListNode reverseList(ListNode head) {
		 ListNode pre = null;
		 ListNode cur = head;
		 while(cur != null) {
			 ListNode next = cur.next;	 
			 cur.next = pre;
			 pre = cur;
			 cur = next;
			 
		 }
		return pre;
	        
	    }
	public static void main(String[] args) {
		//  尾插法生成链表
		ListNode head = new ListNode(0);
		ListNode tail = null;
		tail = head;
		ListNode newNode = null;
		for(int i = 10; i< 15; i++) {
			newNode = new ListNode(i);
			tail.next = newNode;
			tail = newNode;
		}
		
		ListNode reverseList = reverseList(head);
		while(reverseList != null) {
			System.out.print(reverseList + "\n");
			reverseList = reverseList.next;
		}
		
		
		
	}

}
