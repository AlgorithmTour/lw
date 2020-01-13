package cn.andios;
/**
 * 
 * @author LSD
 *
 * @datetime 2020��1��1������8:06:54
 *
 */
public class Test2 {
    public static ListNode6 addTwoNumbers(ListNode6 l1, ListNode6  l2) {
    	ListNode6 head = new ListNode6(Integer.MAX_VALUE);
    	ListNode6 tail = head;
    	
    	ListNode6 newNode = null;
    	//i��ʾ��λ��ȡ1��0
    	int i = 0;
    	//sum��ʾ��������������ڵ��val��ӵ�ֵ��sum=ǰһ����ӵĽ�λ+������ӵ������ڵ��val֮��
    	int sum = 0;
    	while(l1 != null || l2 != null) {
    		//���һ�������Ѿ��������ˣ���һ����û���Ͱ������Ϊ0
    		if(l1 == null) {
    			l1 = new ListNode6(0);
    		}
    		if(l2 == null) {
    			l2 = new ListNode6(0);
    		}
    		//����sum
    		sum = l1.val + l2.val + i;
    		//��Ϊsum���ܻ������λ������ȡsum % 10֮�����
    		newNode = new ListNode6(sum % 10);
    		tail.next = newNode;
    		tail = tail.next;
    		
    		//ȡ��λ
    		i = sum / 10;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	//������󣬿��ܻ����ڽ�λ
    	if(i != 0) {
    		tail.next = new ListNode6(i);
    	}
        return head.next;
    }
	public static void main(String[] args) {
		//������������
		ListNode6 head1 = new ListNode6(9);
		ListNode6 tail1 = head1;
		
		ListNode6 head2 = new ListNode6(1);
		ListNode6 tail2 = head2;
		
		ListNode6 newNode;
		
		int[] arr = new int[] {9,9,9,9,9,9,9,9,9};
		
//		for (int i = 0; i < arr.length-2; i++) {
//			newNode = new ListNode6(arr[i]);
//			tail1.next = newNode;
//			tail1 = tail1.next;		
//		}
		for (int i = 0; i < arr.length; i++) {
			newNode = new ListNode6(arr[i]);
			tail2.next = newNode;
			tail2 = tail2.next;		
		}
		//[0]  [9]
//		while(head1 != null) {
//			System.out.print(head1.val+"\t");
//			head1 = head1.next;
//		}
		//[0]  [1,9,9,9,9,9,9,9,9,9]
//		System.out.println();
//		while(head2 != null) {
//			System.out.print(head2.val+"\t");
//			head2 = head2.next;
//		}
		
		ListNode6 addTwoNumbers = addTwoNumbers(head1, head2);
		while(addTwoNumbers != null) {
			System.out.print(addTwoNumbers.val+"\t");
			addTwoNumbers = addTwoNumbers.next;
		}
	}
}
/**
 * �ڵ���
 */
class ListNode6 {    
	int val;
    ListNode6 next;
    ListNode6(int x) { val = x; }
}
