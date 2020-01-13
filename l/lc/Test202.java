package cn.andios;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年11月30日上午11:18:25
 *
 */
public class Test202 {

	/**
	 *  	关键：当一个数各个数位上的平方和出现了两次，就一定是产生了循环，
	 *  		此时需要跳出，否则就一直计算下去，一直到等于1
	 */
    public static boolean isHappy(int n) {
    	Map<Integer,Integer> map = new HashMap();
    	while(true) {
    		if(countN(n) == 1) {
    			return true;
    		}
    		if(map.put(countN(n), 1) != null) {
    			return false;
    		}
    		n=countN(n);
    	}
    }
    
    /**
     * 	给定一个整数n，计算出它各个数位上的平方和
     */
	public static int countN(int n) {
		int result=0,sum =0,temp=n;
		while(temp >0) {
			sum = temp%10;
			result += Math.pow(sum, 2);
			temp /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(100));
	}
}
