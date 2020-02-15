package algorithm;
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @ date: 2/15
 * @author xiaoqi
 * @��Ŀ�� ����һ����������������ڵ�ֵ�ľ���β�α����������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У���
 */
public class Test103 {
//����һ�� ���У���α�����
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
			 for(int  i = 0; i < num; i++) { // ���еĳ���Ϊһ��
				 TreeNode node = queue.poll();
				 // ż���㣬��ǰ�����				 
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
	 
	 // ��������  ˫ջ����
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			 return res;
		 }
		// ����������ջ
		Stack<TreeNode> stack1 = new Stack<>();
		// ���ż�����ջ
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			// ��ջ����
			if(!stack1.isEmpty()) {
				while(!stack1.isEmpty()) {
					List<Integer> level1 = new ArrayList<>();
					int num1 = stack1.size();
					for(int i = 0;i<num1;i++) {
						TreeNode node1 = stack1.pop();
						level1.add(node1.val);
						// ż���㣬��left�ڵ���ջ
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
					// �����㣬��right�ڵ���ջ
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
