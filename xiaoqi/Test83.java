package algorithm;
/**
 * @data 1/16
 * @author xiaoqi
 * @��Ŀ�� ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
		ʾ�� 1:
		����: 1->1->2
		���: 1->2
		
	@˼·��ֱ�ӷ���
 */
public class Test83 {
	 public ListNode deleteDuplicates(ListNode head) {
		 ListNode cur = head;
		 while(cur != null&& cur.next != null) {
			 if(cur.val == cur.next.val) {
				 cur.next = cur.next.next;
			 } 
			 cur = cur.next;
		 }
		 
		return head;

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
