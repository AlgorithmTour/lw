package cn.andios;

import java.util.Arrays;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月6日下午8:39:48
 *
 */
public class Test16 {

	/**
	 * 	双指针
	 */
    public static int threeSumClosest(int[] nums, int target) {
//    	if(nums == null || nums.length <3) {
//    		return 0;
//    	}
    	Arrays.sort(nums);
    	int min = Integer.MAX_VALUE;
    	int result=min,temp=min;
    	for (int i = 0; i < nums.length-2; i++) {
    		if(i==0 || nums[i] != nums[i-1]) {
    			int j=i+1,k=nums.length-1;
    			while(j < k) {
    				if(nums[i]+nums[k]+nums[j] == target) {
    					return target;
    				}else if(nums[i]+nums[k]+nums[j] > target){	     									
    					min = Math.min(min, Math.abs(nums[i]+nums[k]+nums[j]-target));
    					if(temp != min) {
    						//min变小了
    						result = nums[i]+nums[k]+nums[j];
    						temp = min;
    					}
    					k--;
    				}else {
    					min = Math.min(min, Math.abs(nums[i]+nums[k]+nums[j]-target));
    					if(temp != min) {
    						//min变小了
    						result = nums[i]+nums[k]+nums[j];
    						temp = min;
    					}
    					j++;
    				}  				
    			}
    		}
		}
    	return result;
    }
    
	public static void main(String[] args) {
		//System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));	
		//System.out.println(threeSumClosest(new int[] {0,0,0}, 1));	
		System.out.println(threeSumClosest(new int[] {0,1,2}, 3));	
	}
}
