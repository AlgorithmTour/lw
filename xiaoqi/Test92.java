package algorithm;

public class Test92 {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		  
		 // 如果是空链表
		 if(head == null) {
			 return null;
		 }
		 ListNode pre = null; 
		 ListNode cur = head;
		 ListNode con = null;
		 ListNode tail = null;
		 ListNode next = null;
		 // pre与cur推进，直到cur指向第m个结点
		 while(m > 1) {
			 pre = cur;
			 cur = cur.next;
			 m--;
			 n--;
		 }
		 // con保存第m个结点的前一个节点
		 con = pre;
		 // con保存第m个结点
		 tail = cur; 
		 // 第m个结点到第n个结点进行反转
		 while(n > 0) {
			 next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
			 n--;
		 }
		 // 将前m个结点、第n结点后面的节点连接起来
		 if(con != null) {
			 con.next = pre;
		 }else {
			 head = pre;
		 }
		
		 tail.next = cur;
		
		 
		 
		return head;
         
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
