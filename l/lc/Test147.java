/*
 * @Author: lsd
 * @Date: 2020-01-23 22:43:15
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test147 {
    public static void main(String[] args) {
        ListNode12 head = new ListNode12(Integer.MAX_VALUE);
        ListNode12 newNode = null;
        int [] arr = new int []{-1,5,3,4,0};
        for (int i = arr.length - 1; i >= 0; i--) {
            newNode = new ListNode12(arr[i]);
            newNode.next = head.next;
            head.next = newNode;
        }

        // head = head.next;
        // while(head != null){
        //     System.out.print(head.val+"\t");
        //     head = head.next;
        // }
        ListNode12 list = insertionSortList(head.next);
        while(list != null){
            System.out.print(list.val + "\t");
            list = list.next;
        }
    }

    public static ListNode12 insertionSortList(ListNode12 head) {
        if(head == null || head.next == null){
            return head;
        }
        //头节点，用于最后返回
        ListNode12 header = new ListNode12(Integer.MAX_VALUE);
        header.next = head;
        //头节点，用于排序操作
        ListNode12 pre = header;
        ListNode12 cur = head;
        ListNode12 node = null;
        //[pre,cur]这部分是已经排好序的，初始时就head一个节点
        while(cur != null){
            //记录下一个要操作的节点
            node = cur.next;
            //[pre,cur]这部分已经递增排序，所以如果下一个要排序的节点值>cur，就直接放在cur后面即可
            //如果下一个要排序的节点值<cur，就要在[pre,cur]这部分中遍历，找到合适的位置并插入
            if(node != null && node.val < cur.val){
                //遍历找到合适位置
                while(pre.next != null && pre.next.val < node.val){
                    pre = pre.next;
                }
                //执行插入,将node插入到pre.next后面
                ListNode12 tmp = pre.next;
                pre.next = node;
                //更新cur指向的节点，node已经处理了，下次要处理的就是node.next
                cur.next = node.next;
                node.next = tmp;

                //更新pre
                pre = header;
            }else{
                //下次遍历时取node为cur.next
                cur = node;
            }
        }
        return header.next;
    }
}
class ListNode12 {
    int val;
    ListNode12 next;
    ListNode12(int x) {
        val = x;
    }
}
 