package algorithm;

public class Test92 {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
		  
		 // ����ǿ�����
		 if(head == null) {
			 return null;
		 }
		 ListNode pre = null; 
		 ListNode cur = head;
		 ListNode con = null;
		 ListNode tail = null;
		 ListNode next = null;
		 // pre��cur�ƽ���ֱ��curָ���m�����
		 while(m > 1) {
			 pre = cur;
			 cur = cur.next;
			 m--;
			 n--;
		 }
		 // con�����m������ǰһ���ڵ�
		 con = pre;
		 // con�����m�����
		 tail = cur; 
		 // ��m����㵽��n�������з�ת
		 while(n > 0) {
			 next = cur.next;
			 cur.next = pre;
			 pre = cur;
			 cur = next;
			 n--;
		 }
		 // ��ǰm����㡢��n������Ľڵ���������
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
