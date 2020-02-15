package algorithm;
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ date: 2/15
 * @author xiaoqi
 * @题目： 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Test103 {
//方法一： 队列（层次遍历）
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		 LinkedList<List<Integer>> res = new LinkedList<>();
		 if(root == null) {
			 return res;
		 }
		 Queue<TreeNode> queue = new LinkedList<>();
		 int flag = 1;
		 queue.offer(root);
		 while(!queue.isEmpty()) {
			 List<Integer> levelList = new ArrayList<Integer>();
			 int num = queue.size();
			 for(int  i = 0; i < num; i++) { // 队列的长度为一层
				 TreeNode node = queue.poll();
				 // 偶数层，从前面添加				 
				 if(flag % 2 == 0) {
					 levelList.add(0, node.val);
					 
				 }else {
					 levelList.add(node.val);
				 }
				 if(node.left != null) {
					 queue.offer(node.left);
				 }
				 if(node.right != null) {
					 queue.offer(node.right);
				 }
				 
			 }
			 flag++;
			 res.add(levelList); 
		 }
		 
		return res;
	        
	    }
	 
	 // 方法二：  双栈交替
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			 return res;
		 }
		// 存放奇数层的栈
		Stack<TreeNode> stack1 = new Stack<>();
		// 存放偶数层的栈
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			// 两栈交替
			if(!stack1.isEmpty()) {
				while(!stack1.isEmpty()) {
					List<Integer> level1 = new ArrayList<>();
					int num1 = stack1.size();
					for(int i = 0;i<num1;i++) {
						TreeNode node1 = stack1.pop();
						level1.add(node1.val);
						// 偶数层，先left节点入栈
						if(node1.left != null) {
							stack2.push(node1.left);
						}
						if(node1.right != null) {
							stack2.push(node1.right);
						}
						
					}
					res.add(level1);
				}
			}else {
				while(!stack2.isEmpty()) {
					// 奇数层，先right节点入栈
					List<Integer> level2 = new ArrayList<>();
					int num2 = stack2.size();
					for(int i = 0;i<num2;i++) {
						TreeNode node2 = stack2.pop();
						level2.add(node2.val);
						
						if(node2.right != null) {
							stack1.push(node2.right);
						}
						if(node2.left != null) {
							stack1.push(node2.left);
						}
					}
				   res.add(level2);
				}
			}
		}
		return res;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
