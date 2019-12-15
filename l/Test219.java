package cn.andios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月15日下午8:51:27
 *
 */
public class Test219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums == null || nums.length <2)
    		return false;
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}else {
				int index = map.get(nums[i]);
				if(i-index <=k) {
					return true;
				}
				map.put(nums[i], i);
			}
		}
    	return false;
    }
    
	public static void main(String[] args) {
		boolean bool = containsNearbyDuplicate(new int[] {1,2,3,1}, 3);
		System.out.println(bool);
	}
}
