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
	public void helper2(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		
	}
	
	public List<Integer> preorderTraversal2(TreeNode root) {
		if(root == null) {
			return null;
		}
		List<Integer> res = new ArrayList<>();
		Stack stack = new Stack();
		while()
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
