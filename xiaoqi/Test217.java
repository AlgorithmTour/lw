package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 12/31
 * @author xiaoqi
 * @题目： 给定一个整数数组，判断是否存在重复元素。
 */
public class Test217 {
	// 方法：使用set
	public static boolean containsDuplicate(int[] nums) {
		Set set  =  new HashSet<>();
		for(int i = 0;i< nums.length;i++) {
			if(set.contains(nums[i])) {
				return  true;
			}else {
				set.add(nums[i]);
			}
		}
		return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 1};
		  System.out.print(containsDuplicate(nums));
	}

}
