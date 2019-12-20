package cn.andios;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月16日下午7:32:06
 *
 */
public class Test217 {
	
    public static boolean containsDuplicate(int[] nums) {
    	if(nums == null ||nums.length <= 1)
    		return false;
    	Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return true;
			}
			map.put(nums[i], i);
		}
        return false;
    }
	public static void main(String[] args) {
		boolean isContain = containsDuplicate(new int[] {1,2,3,1});
		System.out.println(isContain);
	}
}
