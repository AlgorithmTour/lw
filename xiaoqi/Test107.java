package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Test107 {
	public List<List<Integer>> helper(TreeNode root,  List<List<Integer>> res ) {
		List<Integer> list = new ArrayList<Integer>();
		if(root.left != null) {
			helper(root.left, res);
		}else {
			list.add(root.val);
		}
		if(root.right != null) {
			helper(root.right, res);
		}else {
			list.add(root.val);
		}
		res.add(list);
		return res;
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		 if (root == null) {
			  return res;
		  }
		 helper(root,res);
		 
		return res;     
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
