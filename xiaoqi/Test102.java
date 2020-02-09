package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @date 2/9
 * @author xiaoqi
 * @��Ŀ�� 
 */
public class Test102 {
	
	// ����һ�� �ݹ�
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 
	 }
	// �������� ���� (���Ĳ�α���(�����Ĺ�����ȱ���))
	  public List<List<Integer>> levelOrder1(TreeNode root) {
		  
		  List<List<Integer>> res = new ArrayList<List<Integer>>();
		  if (root == null) {
			  return res;
		  }
		  Ceng ceng = new Ceng(0,root); // һ��ʵ�������ڵ㡢�ڵ����ڵĲ�����
		  Queue<Ceng> queue = new LinkedList<>();  // ����һ������
		  queue.offer(ceng); // ���ʵ��
		  while(!queue.isEmpty()) {
			  TreeNode node = queue.peek().node;
			  int level = queue.peek().level;
			  queue.poll(); // �Ƴ�����
			  if(level == res.size()) { // ���������res�ĳ�����ȣ��ͽ������res�У�ע��res�е�ÿһ��Ԫ����List<Integer> ���͡�
				  List<Integer> list = new ArrayList <Integer>();
				  list.add(node.val);
				  res.add(list);
			  }else {
				   res.get(level).add(node.val);// �������С��res�ĳ��ȣ�˵������ڵ�Ӧ������һ���ڵ㴦��ͬһ�㡣
			  }
			 // ��node�����Һ�����ӵ�������
			  if(node.left != null) {
				  Ceng cengLeft = new Ceng(level+1,node.left);
				  queue.offer(cengLeft);
			  }
			  if(node.right != null) {
				  Ceng cengRight = new Ceng(level+1,node.right);
				  queue.offer(cengRight);
			  }	   	  
		  }  
		return res;      
	 }
	public static void main(String[] args) { 
		// TODO Auto-generated method stub

	}

}
