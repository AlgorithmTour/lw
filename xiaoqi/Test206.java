package algorithm;
/**
 * @date 1/12
 * @author xiaoqi
 * @��Ŀ�� ��תһ��������
	ʾ��:
	����: 1->2->3->4->5->NULL
	���: 5->4->3->2->1->NULL
   @˼·�� ��������ָ��pre cur next 
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
		//  β�巨��������
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
