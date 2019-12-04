package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月4日下午3:52:13
 *
 */
public class Test15 {
    /**
     * 	双指针
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length <3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) 
                        	lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) 
                        	hi--;
                        lo++; 
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                    	while (lo < hi && nums[lo] == nums[lo+1]) 
                    		lo++;
                    	lo++;
                    }else {
                    	while (lo < hi && nums[hi] == nums[hi-1]) 
                    		hi--;
                        hi--;
                    }                    	
               }
            }
        }
        return res;
    }
	/**
	 *	超时
	 */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if(nums == null || nums.length <3) {
            return new ArrayList<>();
        }
        
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) {
                break;
            }
            for(int j = i+1;j<nums.length;j ++) {
                if(list.contains(-(nums[i]+nums[j]))) {
                    set.add(Arrays.asList(nums[i],nums[j],-(nums[i]+nums[j])));                   
                }
                list.add(nums[j]);
            }
            list.clear();
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
		List<List<Integer>> threeSum1 = threeSum1(new int [] {-1,0,1,2,-1});
		List<List<Integer>> threeSum2 = threeSum2(new int [] {-1,0,1,2,-1});
		threeSum2.forEach(item->item.forEach(System.out::print));
	}
}
