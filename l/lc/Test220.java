package cn.andios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月16日下午8:22:00
 *
 */
public class Test220 {
	/**
	 * i、j差值最大为k
	 * nums[i]、nums[j]差值最大为t 
	 */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(t<0 || k<1 ||nums== null || nums.length == 0)
    		return false;
    	//	构建二叉树
    	TreeSet<Long> set = new TreeSet<Long>();
    	
    	//	遍历数组
        for (int i = 0; i < nums.length; i++) {
        	//	ceiling(key)：找到>=key的最小元素
        	//	如果在nums[i]左侧找到了与 nums [i] 的差的绝对值小于t的值，就返回true
        	Long ceiling = set.ceiling((long)nums[i]-t);
			if(ceiling != null && ceiling <= nums[i]) {
				return true;
			}
			
			//	floor：返回<=key的最大元素
        	//	如果在nums[i]右侧找到了与 nums [j] 的差的绝对值小于t的值，就返回true
			Long floor = set.floor((long)nums[i]+t);
			if(floor != null && floor >= nums[i]) {
				return true;
			}
			
			//	元素添加到set中
			set.add((long)nums[i]);
			
			//	因为要保证两个索引差值最大为k，
			//	比如k=4,如nums为[1,2,4,5,8,10，15],
			//	当i=3时，set为[1,2,4,5]，下一次循环判断是i=4，符合索引差最大为k
			//	当i=4时，set为[1,2,4,5,8]，下一次循环判断是i=5，不符合索引差最大为k，所以就要把nums的第1个元素从set中删掉
			//	当i=5时，set为[2,4,5,8,10]，下一次循环判断是i=6，不符合索引差最大为k，所以就要把nums的第2个元素从set中删掉

			if (i >= k) {
	            set.remove((long)nums[i - k]);
	        }
        }
        
        return false;
    }
	public static void main(String[] args) {
		boolean bool = containsNearbyAlmostDuplicate(new int [] {1,5,9,1,5,9}, 2, 3);
		System.out.println(bool);
	}
}
