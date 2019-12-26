package cn.andios;

/**
 * @Author: lsd
 * @Description: 206
 * @Date: 2019/12/21 上午9:38
 */
public class  Test206 {
    /**
     * 方法二
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    /**
     * 方法一
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if(head== null) {
        	return null;
        }
        /**
         * 3个指针pre,cur,next,比如链表为 a->b->c->d->e->f,则开始时分别指向null,a,b
         * 第一步：因为要反转,即箭头反向,所以a->b变为a->null,即cur.next = pre;
         *      此时链表变为 null<-a b->c->d->e->f, pre,cur,next分别指向null,a,b
         * 第二步：pre,cur,next分别后移一位,pre指向null变为p指向a,cur指向a变为cur指向b,
         *      注意,cur！=null才会进入循环,而next指向cur的后一位,此时cur往后移了一位,
         *      但next不能往后移,因为next此时可能已经指向null,如果next后移,可能发生空指针，
         *      必须在下一次循环时才能后移next
         * 循环第二步,一直到cur指向null,此时pre指向最后一位f,所以最终返回pre
         *
         */
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;

            cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        return pre;
    }
    
    public static void main(String []args) {

        //尾插法生成链表
        ListNode head = new ListNode(0);
        ListNode tail = null;
        tail = head;
        ListNode newNode = null;
        for (int i = 10; i < 15; i++) {
    		newNode = new ListNode(i);
    		tail.next = newNode;
		    tail = newNode;
    	}

        //0	10	11	12	13	14
//        while(head != null) {
//            System.out.print(head.val+"\t");
//            head = head.next;
//        }

//      14	13	12	11	10	0
    	ListNode reverseList = reverseList1(head);
    	//ListNode reverseList = reverseList2(head);
        //打印反转后的结果
    	while(reverseList != null) {
            System.out.print(reverseList.val+"\t");
            reverseList = reverseList.next;
    	}
    }
}

/**
 * 节点类
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}