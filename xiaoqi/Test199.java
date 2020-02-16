package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @date 2/16
 * @author xiaoqi
 * @��Ŀ������һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
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
			 int count = queue.size(); // ÿһ��ĳ���
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
