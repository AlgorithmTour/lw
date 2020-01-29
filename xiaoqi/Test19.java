package algorithm;
/**
 * @date: 1/29
 * @author xiaoqi
 * @��Ŀ�� ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
 * @˼·�� ʹ��һ���ƽ�㣬����ָ��p,q,��ʼʱ����p��q��ʼʱ���������ڵ�֮��ľ���Ϊn��֮���ٽ�����ͬʱ����ƣ�ֱ��qָ��null����ʱ��p����һ���ڵ�����Ҫɾ���Ľڵ�
 */
public class Test19 {
	
	// ��������
		public static ListNode create(int arr[], int n) {
			if(n == 0 ) {
				return null;
			}
			// ������ĵ�һ��Ԫ�ظ���ͷָ��
			ListNode head =  new ListNode(arr[0]);
			ListNode curNode = head;
			// ���θ�ֵ
			for(int  i = 1; i < n;i++) {
			    curNode.next = new ListNode(arr[i]);
				curNode = curNode.next;
			}
			return head;
		}
		// ��ӡ����
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
		 // ����dummyP,dummyQ�������ڵ�֮��Ľڵ����Ϊn(������qǰ��n+1��)
		 for(int i = 0;i< n+1;i++) {
			 dummyQ = dummyQ.next;
		 }
		 // ��dummyQ��Ϊnullʱ��dummyP��dummyQ���ڵ�ͬʱ�����
		 while(dummyQ != null) {
			 dummyP = dummyP.next;
			 dummyQ = dummyQ.next;
		 }
		 // ��ʱdummyP����һ�����Ϊ��Ҫɾ���Ľڵ�
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
