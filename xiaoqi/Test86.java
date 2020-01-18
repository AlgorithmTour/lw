package algorithm;
/**
 * @data 1/18
 * @author xiaoqi
 * @题目：
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
	示例:
	输入: head = 1->4->3->2->5->2, x = 3
	输出: 1->2->2->4->3->5
	@ 思路：
	方法很简单，构建两个链表，将小于x的放在一个链表，大于或等于x的放在另一个链表，最后连接两个链表。
	思路简单，但是要使用一个技巧就是为两个链表建立哑结点，这个哑结点可以减少很多条件的判断。
	如果不采用哑结点，当只有一个值，比如[1]，会很麻烦。
 */
public class Test86 {
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
	 public static ListNode partition(ListNode head, int x) {
		 ListNode cur = head;
		 // 构建哑结点的好处：减少条件的判断
		 ListNode startMin = new ListNode(0); // 初始化构建哑结点（第一个结点的value为0）
		 ListNode startMax = new ListNode(0); // 初始化构建哑结点（第一个结点的value为0）
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
		tail2.next = null;//避免成环
		tail1.next = startMax.next; // 连接两个链表
		
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
