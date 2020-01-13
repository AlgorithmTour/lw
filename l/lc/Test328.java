package cn.andios;
/**
 * 
 * @author LSD
 *
 * @datetime 2020��1��1������8:06:43
 *
 */
public class Test328 {
	public static ListNode5 oddEvenList(ListNode5 head) {
		/**
		 * �������������ֱ������λ�Ľڵ��ż��λ�Ľڵ㣬
		 * �����������ż���ڵ���������ڵ���棬��������86
		 */
	    ListNode5  odd = new ListNode5(0);
	    ListNode5 even = new ListNode5(0);
	    
	    ListNode5  oddHead = odd;
	    ListNode5  evenHead = even;
	    
	    while(head != null) {
	    	//����ǰhead�ŵ�oddĩβ
	    	oddHead.next = head;
	    	head = head.next;
	    	oddHead = oddHead.next;
	    	oddHead.next = null;
	    	
	    	//����ǰhead�ŵ�evenĩβ
	    	if(head != null) {
	    		evenHead.next = head;
		    	head = head.next;
		    	evenHead = evenHead.next;
		    	evenHead.next = null;
	    	}
	    }
	    oddHead.next = even.next;
		return odd.next;
	}
	public static void main(String[] args) {
		//��������
		ListNode5 head = new ListNode5(0);
		ListNode5 tail = head;
		ListNode5 newNode = null;
		int []arr = new int[] {1,2,3,4,5};
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode5(arr[i]);
			tail.next = newNode;
			tail = newNode;
		}
		
//		while(head!= null) {
//			System.out.println(head.val);
//			head = head.next;
//		}
		ListNode5 oddEvenList = oddEvenList(head);
		while(oddEvenList!= null) {
			System.out.println(oddEvenList.val);
			oddEvenList = oddEvenList.next;
		}
	}
}

class ListNode5 {    
	int val;
    ListNode5 next;
    ListNode5(int x) { val = x; }
}
 