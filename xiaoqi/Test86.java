package algorithm;
/**
 * @data 1/18
 * @author xiaoqi
 * @��Ŀ��
 * ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
 * ��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
	ʾ��:
	����: head = 1->4->3->2->5->2, x = 3
	���: 1->2->2->4->3->5
	@ ˼·��
	�����ܼ򵥣���������������С��x�ķ���һ���������ڻ����x�ķ�����һ���������������������
	˼·�򵥣�����Ҫʹ��һ�����ɾ���Ϊ�����������ƽ�㣬����ƽ����Լ��ٺܶ��������жϡ�
	����������ƽ�㣬��ֻ��һ��ֵ������[1]������鷳��
 */
public class Test86 {
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
	 public static ListNode partition(ListNode head, int x) {
		 ListNode cur = head;
		 // �����ƽ��ĺô��������������ж�
		 ListNode startMin = new ListNode(0); // ��ʼ�������ƽ�㣨��һ������valueΪ0��
		 ListNode startMax = new ListNode(0); // ��ʼ�������ƽ�㣨��һ������valueΪ0��
		 ListNode tail1 = startMin; 
		 ListNode tail2 = startMax;
		   
		 while(cur != null ) {
			if(cur.val < x) {
				    tail1.next = cur;
					tail1 =  tail1.next;
			}	 
				 
			else {
					tail2.next = cur;
					tail2 =  tail2.next;
				}	
			  cur = cur.next;	  
		}
		tail2.next = null;//����ɻ�
		tail1.next = startMax.next; // ������������
		
		return startMin.next;  
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1};
		ListNode head = create(arr, 1);
		ListNode newHead =  partition(head,0);
		printList(newHead);
	}

}
