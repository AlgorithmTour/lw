package cn.andios;

/**
 * @Author: lsd
 * @Description: 92
 * @Date: 2019/12/25 下午3:13
 */
public class Test92 {
    public static ListNode2 reverseBetween(ListNode2 head, int m, int n) {

        //1.找到待反转节点的前一个节点
        //  比如链表为1->2->3->4->5.反转2-4,,就找到1
        ListNode2 node = head;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        //node即表示反转节点的前一个节点,node.next即需要反转的节点的起点

        //2.反转m到n这部分,从node.next开始反转
        //  2->3->4反转为2<-3<-4,即链表变为1 2<-3<-4 5
        /**
         * 类似Test206单链表的反转,申明3个指针
         *  1.箭头反向
         *  2.指针后移
         */
        ListNode2 nodeHead = node.next;
        ListNode2 pre = null;
        ListNode2 next = null;
        for (int i = m; i <= n; i++) {

            //更新next指针
            next = nodeHead.next;
            //将箭头反向
            nodeHead.next = pre;
            //pre指针后移
            pre = nodeHead;
            //nodeHead指针后移
            nodeHead = next;
        }

        //3.将反转的起点的next指向反转的后面一部分
        //  第2步后得到链表1 2<-3<-4 5,这一步就将2的next指向5,即链表变为1 5<-2<-3<-4

        //因为node.next为需要反转的节点的起点,所以直接赋值node.next.next
        node.next.next = next;

        //4.将第1步找到的节点指向反转后的头节点
        //  第3步后得到链表1 5<-2<-3<-4,这一步将1的next指向4,即链表变为5<-2<-3<-4<-1,即1->4->3->2->5
        node.next = pre;
        return head;
    }
    public static void main(String[] args) {
        //生成链表
        ListNode2 head = new ListNode2(0);
        ListNode2 tail = null;
        tail = head;
        ListNode2 newNode = null;
        for (int i = 10; i < 15; i++) {
            newNode = new ListNode2(i);
            tail.next = newNode;
            tail = newNode;
        }
        //10    11	12	13	14
//        while(head.next != null) {
//            head = head.next;
//            System.out.print(head.val+"\t");
//        }

        ListNode2 listNode = reverseBetween(head, 2, 4);

        while (listNode.next != null){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
/**
 * 节点类
 */
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}