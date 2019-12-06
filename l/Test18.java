package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author LSD
 *
 * @datetime 2019��12��6������6:44:33
 *
 */
public class Test18 {
	/**
	 * 	Ҫ��֤���ؽ���в��ܰ����ظ���list��
	 * 	���Ե�
	 * 		nums[i] == nums[i-1];nums[j] == nums[j-1];nums[lo] == nums[lo+1];nums[hi] == nums[hi-1]
	 * 	ʱҪi,j,lo,hi��Ҫ�ƶ�����Ҫ�ų��������������i=0��j=i+1
	 * 	��Ϊ�����i=0���ų���nums[i-1]�ͻ�Խ��
	 * 	���j=i+1���ų����ͻ�©��
	 * 
	 * 	41ms��������Ҫ�Ż��ĵط���
	 */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<>();
        if(nums.length <4) {
        	return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
        	if(i ==0 || nums[i] != nums[i-1]) {
        		//	�Ż�1��
        		//	max = nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]
        		//	min = nums[i]+nums[i+1]+nums[i+2]nums[i+3]
        		//	���max<target||min>target��ֱ������;
        		for (int j = i+1; j < nums.length-2; j++) {
            		// 	�Ż�2(�����Ż�1)
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
