package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2/16
 * @author xiaoqi
 * @题目：给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Test199 {
	 public List<Integer> rightSideView(TreeNode root) {
		 List<Integer> res = new ArrayList<>();
		 if (root == null) {
			  return res;
		  }
		 Queue<TreeNode> queue = new LinkedList<>(); 
		 queue.offer(root);
		 while(!queue.isEmpty()) {
			 int count = queue.size(); // 每一层的长度
			  for(int i = 0; i < count;i++ ) {
				  TreeNode node = queue.poll();
				  
				  if(node.left != null) {
					  queue.offer(node.left);
				  }
				  if(node.right != null) {
					  queue.offer(node.right);
				  }
				  if(i== count -1) {
					  res.add(node.val);
				  }
			  }
			  
		 }
		 
		return res;   
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
