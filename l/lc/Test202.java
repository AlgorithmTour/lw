package cn.andios;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LSD
 *
 * @datetime 2019��11��30������11:18:25
 *
 */
public class Test202 {

	/**
	 *  	�ؼ�����һ����������λ�ϵ�ƽ���ͳ��������Σ���һ���ǲ�����ѭ����
	 *  		��ʱ��Ҫ�����������һֱ������ȥ��һֱ������1
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
     * 	����һ������n���������������λ�ϵ�ƽ����
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
