package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Test279 {
    // ����һ������ ����ģΪͼ��  ������֮�����һ����ȫƽ���� ������һ���ߣ� ������ȱ���
	 public static int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		int [] visited = new int[n+1];
		int count = 0; // ��¼����  �����������·�� 
		while(!queue.isEmpty()) {
			// ÿ��ѭ���������е�Ԫ��ȡ�꣨ȡ��һ�㣩
			int len = queue.size();
			for(int i = 0; i<len;i++) {
				int temp = queue.poll();// ȡ������
				System.out.println(temp);
				if(temp == 0) { // �ҵ�0   ���ҵ������·�� 
					return count;
				}
				// �����ƽ����������ӵ�����
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
