package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @date 2/9
 * @author xiaoqi
 * @题目： 
 */
public class Test102 {
	
	// 方法一： 递归
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 
	 }
	// 方法二： 队列 (树的层次遍历(即数的广度优先遍历))
	  public List<List<Integer>> levelOrder1(TreeNode root) {
		  
		  List<List<Integer>> res = new ArrayList<List<Integer>>();
		  if (root == null) {
			  return res;
		  }
		  Ceng ceng = new Ceng(0,root); // 一个实例包括节点、节点所在的层数。
		  Queue<Ceng> queue = new LinkedList<>();  // 创建一个队列
		  queue.offer(ceng); // 添加实例
		  while(!queue.isEmpty()) {
			  TreeNode node = queue.peek().node;
			  int level = queue.peek().level;
			  queue.poll(); // 移除队首
			  if(level == res.size()) { // 如果层数与res的长度相等，就将其放入res中，注意res中的每一个元素是List<Integer> 类型。
				  List<Integer> list = new ArrayList <Integer>();
				  list.add(node.val);
				  res.add(list);
			  }else {
				   res.get(level).add(node.val);// 如果层数小于res的长度，说明这个节点应该与上一个节点处在同一层。
			  }
			 // 将node的左右孩子添加到队列中
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
