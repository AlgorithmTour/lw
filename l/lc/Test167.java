package cn.andios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 167 125 344 345 11
 * 	左右指针碰撞法 
 * @author LSD
 *
 * @datetime 2019年10月20日下午2:21:51
 *
 */
public class Test167 {

	/**
	 * 非空判断
	 * 可以用第1题一样的做法，但没有利用 升序排列  这一特点
	 */
	public static int[] twoSum2(int[] numbers, int target) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if(map.containsKey(target-numbers[i])) {
				return new int [] {map.get(target-numbers[i])+1,i+1};
			}
			map.put(numbers[i], i);
		}
		return null;
	}
	
	/**
	 * 双指针
	 */
    public static int[] twoSum1(int[] numbers, int target) {
        int i = 0,j = numbers.length - 1;
        if(numbers == null || numbers.length <2) {
        	return null;
        }
        int []a = new int [2];
        while(i < j) {
        	if(numbers[i] + numbers[j] == target) {
	        	a[0] = i + 1;
	        	a[1] = j + 1;
	        	return a;
        	}else if(numbers[i] + numbers[j] > target){
        		j --;
        	}else {
        		i ++;
        	}
        }
        
        return null;
    }
	//测试
	public static void main(String[] args) {
		int []array = {2, 7, 11, 15};
		//int [] a = twoSum1(array, 9);
		int [] a = twoSum2(array, 9);
		System.out.println(Arrays.toString(a));
		
	}

}
