package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 12/31
 * @author xiaoqi
 * @题目： 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
public class Test219 {
	// 方法一： 暴力法
	 public static boolean containsNearbyDuplicate(int[] nums, int k) {
		 for(int i= 0;i < nums.length;i++ ) {
			 for(int j = i+1; j < nums.length;j++) {
				 if(nums[i] == nums[j]) {
					 if(j-i <= k) {
						 return true;
					 }
					 
				 }
			 }
		 }
		 return false;        
	    }
	 // 方法二 滑动窗口+set(set中每次只存储k个数)
	 public static boolean containsNearbyDuplicate2(int[] nums, int k) {
		 if(k == 0) {
			 return false;
		 }
		 int left = 0,right = Math.min(nums.length, k);
		 Set set = new HashSet<>();
		 for(int i = left; i< right; i++) {
			 if(set.contains(nums[i])) {
				 return true;
			 }
			 set.add(nums[i]);
		 }
		 for(int i = right ; i< nums.length;i++) {
			 if(set.contains(nums[i])) {
				 return true;
			 }else {
				 set.remove(nums[left++]);
				 set.add(nums[i]);	 
			 }
			 
		 }
		return false;
		 
	 }
	public static void main(String[] args) {		
		int[] nums = {1,1};
	    int k = 2;
	    System.out.print(containsNearbyDuplicate2(nums, k));
	    
	}

}
