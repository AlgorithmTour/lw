package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @date 2/7
 * @author xiaoqi
 * @题目
 */
public class Test144 {
	// 方法一： 递归
	public void helper1(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		res.add(root.val);
		helper1(root.left, res);
		helper1(root.right, res);
	} 
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper1(root, res ); 
    	return res;        
	}
	
	// 方法二：使用栈
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack();
		
		if(root == null) {
			return res ;
		}
		
		stack.push(root);
		while(!stack.empty()) {
			TreeNode type = stack.pop();
			if(type.right != null) {
				stack.push(type.right);
			}
			if(type.left != null) {
				stack.push(type.left);
			}
			res.add(type.val);
		}
		return res;
	}
	
	 // 方法三 ： 使用栈的优化解法
	public List<Integer> preorderTraversal3(TreeNode root) {
		
		List<Integer> res = new ArrayList<>();
		Stack<Command> stack = new Stack<Command>();
		if(root == null) {
			return res ;
		}
		Command command = new Command("visit", root);
		stack.push(command);
		while(!stack.empty()) {
			Command type = stack.pop();
			if(type.s == "print") { // 如果其s是"print", 就将其加入到输出数组res中
				res.add(type.node.val);
			}else {
				if(type.node.right != null) {
					Command typeRight = new Command("visit", type.node.right);
					stack.push( typeRight);
				}
				if(type.node.left != null) {
					Command typeLeft = new Command("visit", type.node.left);
					stack.push( typeLeft);
				}
				type.s = "print"; // 如果左右孩子都访问完，就将其s置为"print"
				stack.push(type);
			}
		}
		
		return res;
	}
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
