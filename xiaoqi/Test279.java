package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Test279 {
    // 方法一：队列 （建模为图论  若两数之间相差一个完全平方数 则连接一条边） 广度优先遍历
	 public static int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		int [] visited = new int[n+1];
		int count = 0; // 记录层数  层数就是最短路径 
		while(!queue.isEmpty()) {
			// 每次循环将队列中的元素取完（取完一层）
			int len = queue.size();
			for(int i = 0; i<len;i++) {
				int temp = queue.poll();// 取出队首
				System.out.println(temp);
				if(temp == 0) { // 找到0   就找到了最短路径 
					return count;
				}
				// 将相差平方数的数添加到队列
				  for(int k = 1; temp - k*k >= 0;k++){
					    if(visited[temp - k*k] == 0) {
					    	queue.offer(temp - k*k);
					    	visited[temp - k*k] = 1;
					    }
	                    
	                }
			}
			count++;
		}
		return count;

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n = 12;
//        System.out.print(numSquares(n));
       numSquares(n);
	}

}
