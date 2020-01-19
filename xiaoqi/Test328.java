package algorithm;
/**
 * @data 1/19
 * @author xiaoqi
 * @��Ŀ������һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
		ʾ�� 1:
		����: 1->2->3->4->5->NULL
		���: 1->3->5->2->4->NULL
   @˼·�� ������ż����
 */
public class Test328 {
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
	 public static ListNode oddEvenList(ListNode head) {
		 if(head == null) {
			 return null;
		 }
		 ListNode list1 = new ListNode(0); // ������
		 ListNode tail1 = list1;
		 ListNode list2 = new ListNode(0); // ż����
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
		 // ����ɻ�
		 tail2.next = null;
		 // ������������ż����
		 tail1.next = list2.next;
		 // �����������ƽ�����һ�����
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
