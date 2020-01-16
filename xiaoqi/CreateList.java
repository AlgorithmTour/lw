package algorithm;
/**
 * @data 1/16
 * @author xiaoqi
 * @如何使用java创建、打印链表
 */
public class CreateList {
	// 创建链表
	public static ListNode create(int arr[], int n) {
		if(n == 0 ) {
			return null;
		}
		// 将数组的第一个元素赋给头指针
		ListNode head =  new ListNode(arr[0]);
		ListNode curNode = head;
		// 依次赋值
		for(int  i = 1; i < n;i++) {
		    curNode.next = new ListNode(arr[i]);
			curNode = curNode.next;
		}
		return head;
	}
	// 打印链表
	public static void printList(ListNode head) {
		ListNode curNode = head;
		while(curNode != null) {
			System.out.print(curNode.val + "->");
			curNode = curNode.next;
		}
		System.out.print("NULL");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 8, 3, 2};
		ListNode head = create(arr, 5);
		printList(head);
	}

}
