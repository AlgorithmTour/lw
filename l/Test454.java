package cn.andios;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月7日下午9:46:21
 *
 */
public class Test454 {
	
	/**
	 * A、B、C、D分为两组，A+B=-(C+D)
	 */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	
    	Map<Integer,Integer> map = new HashMap<>();
    	int count = 0;
        for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < C.length; j++) {
				map.put(D[i]+C[j], map.getOrDefault(D[i]+C[j], 0)+1);
			}
		}
        
        for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if(map.containsKey(-(A[i]+B[j]))) {
					count += map.get(-(A[i]+B[j]));
				}
			}
		}
        return count;
    }
	public static void main(String[] args) {
		//int count = fourSumCount(new int[] {1,2}, new int[] {-1,-2}, new int[] {2,-1}, new int[] {0,2});
		//int count = fourSumCount(new int[] {-1,-1}, new int[] {-1,1}, new int[] {-1,1}, new int[] {1,-1});
		int count = fourSumCount(new int[] {1,1,-1,-1}, new int[] {-1,-1,1,1}, new int[] {1,-1,0,-1}, new int[] {1,1,-1,1});
		System.out.println(count);
	}
}
