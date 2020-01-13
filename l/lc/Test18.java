package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月6日下午6:44:33
 *
 */
public class Test18 {
	/**
	 * 	要保证返回结果中不能包含重复的list，
	 * 	所以当
	 * 		nums[i] == nums[i-1];nums[j] == nums[j-1];nums[lo] == nums[lo+1];nums[hi] == nums[hi-1]
	 * 	时要i,j,lo,hi都要移动，但要排除几个特殊情况：i=0，j=i+1
	 * 	因为，如果i=0不排除，nums[i-1]就会越界
	 * 	如果j=i+1不排除，就会漏掉
	 * 
	 * 	41ms，还有需要优化的地方：
	 */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<>();
        if(nums.length <4) {
        	return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
        	if(i ==0 || nums[i] != nums[i-1]) {
        		//	优化1：
        		//	max = nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]
        		//	min = nums[i]+nums[i+1]+nums[i+2]nums[i+3]
        		//	如果max<target||min>target，直接跳出;
        		for (int j = i+1; j < nums.length-2; j++) {
            		// 	优化2(类似优化1)
        			if(j == i+1 || nums[j] != nums[j-1]) {
        				int lo = j+1,hi = nums.length-1;
        				while(lo <hi) {
        					if(nums[i]+nums[j]+nums[lo]+nums[hi] == target) {
        						res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
        						while (lo < hi && nums[lo] == nums[lo+1]) 
        	                        lo++;
        	                    while (lo < hi && nums[hi] == nums[hi-1]) 
        	                        hi--;
        						hi --;
        						lo ++;
        					}else if(nums[i]+nums[j]+nums[lo]+nums[hi] > target) {
        						while(lo < hi && nums[hi] == nums[hi - 1])
        							hi --;
        						hi -- ;
        					}else {
        						while (lo < hi && nums[lo] == nums[lo+1]) 
                            		lo++;
        						lo ++ ;
        					}
        				}
        			} 				
    			}
        	}		
		}
        return res;
    }
    
	public static void main(String[] args) {
//		List<List<Integer>> fourSum = fourSum(new int [] {-1,0,1,2,-1,-4}, -1);
		List<List<Integer>> fourSum = fourSum(new int [] {-3,-2,-1,0,0,1,2,3}, 0);
		fourSum.forEach(item->item.forEach(System.out::print));
	}
}
