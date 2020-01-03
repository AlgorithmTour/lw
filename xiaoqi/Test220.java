package algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @date 12/31
 * @author xiaoqi
 * @题目：给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 */
public class Test220 {
	 public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		 TreeSet<Integer> set = new TreeSet<>();
		  int left = 0;// set的左边界
		  for(int i = 0;i< nums.length;i++) {
			  Integer  s = set.ceiling(nums[i]);
			  Integer  g = set.floor(nums[i]);
			   if(s!= null &&  (long)s - (long)nums[i]  <= (long)t) {
				  return true;
			  }
			  if( g != null &&  (long)nums[i] -(long)g<=(long)t) {
				  return true;
			  }
			  // 没有找到添加到set中
			  set.add(nums[i]);
			  if(set.size()>k) {
				  set.remove(nums[left++]);
			  }
		  } 
		 
		 
		return false;
		 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  nums = {1,5,9,1,5,9};
		int k = 2, t = 0;
		System.out.print(containsNearbyAlmostDuplicate(nums, k, t));
		

	}

}
