package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @date 2/7
 * @author xiaoqi
 * @��Ŀ
 */
public class Test144 {
	// ����һ�� �ݹ�
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
	
	// ��������ʹ��ջ
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
	
	 // ������ �� ʹ��ջ���Ż��ⷨ
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
			if(type.s == "print") { // �����s��"print", �ͽ�����뵽�������res��
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
				type.s = "print"; // ������Һ��Ӷ������꣬�ͽ���s��Ϊ"print"
				stack.push(type);
			}
		}
		
		return res;
	}
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
