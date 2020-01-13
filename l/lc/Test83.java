package cn.andios;

/**
 * @Author: lsd
 * @Description: 删除排序链表中的重复元素
 * @Date: 2019/12/26 上午10:56
 */
public class Test83 {
    public static ListNode3 deleteDuplicates(ListNode3 head) {
        if(head == null)
            return head;
        /**
         * 类比数组中双指针删除重复的元素
         */
        //定义一个头结点
        ListNode3 res = new ListNode3(Integer.MAX_VALUE);
        res.next = head;
        //cur指针,表示删除之后还存在的元素,从第1个节点开始
        ListNode3 cur = head;
        //node指针从第2个节点开始,遍历整个链表
        ListNode3 node = head.next;
        while (node != null){
            //如果cur.val == node.val,说明node.val已经存到cur中,node就移动到下一个
            if(cur.val == node.val){
                node = node.next;
            }else{
                //如果cur.val != node.val,说明node.val还没存到cur中
                //将node.val存到cur中
                cur.next = node;
                //更新cur
                cur = cur.next;
            }
        }
        //因为cur保存的是不重复的元素,所以当node遍历到末尾时,cur后面的元素一定在cur中存在
        cur.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        //生成链表
        ListNode3 head = new ListNode3(0);
        ListNode3 tail = null;
        tail = head;
        ListNode3 newNode = null;
        for (int i = 10; i < 15; i++) {
            newNode = new ListNode3(i);
            tail.next = newNode;
            tail = newNode;

            newNode = new ListNode3(i);
            tail.next = newNode;
            tail = newNode;
        }

        ListNode3 listNode = deleteDuplicates(head);

//        while (head != null){
//            System.out.print(head.val+"\t");
//            head = head.next;
//        }
        while (listNode != null){
            System.out.print(listNode.val+"\t");
            listNode = listNode.next;
        }
    }
}
/**
 * 节点类
 */
class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) { val = x; }
}