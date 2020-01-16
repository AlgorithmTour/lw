package algorithm;
/**
 * @data 1/16
 * @author xiaoqi
 * @题目： 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
		示例 1:
		输入: 1->1->2
		输出: 1->2
		
	@思路：直接法。
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
