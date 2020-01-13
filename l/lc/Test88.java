package cn.andios;

import java.util.Arrays;
/**
 * 88 75 215
 * @author LSD
 *
 * @datetime 2019年10月20日下午3:27:56
 *
 */
public class Test88 {

	/**
	 * 从后往前判断，不需要开辟额外空间
	 */	
	private static void merge2(int[] nums1, int m, int[] nums2, int n) {
		//m、n表示元素个数，p为合并后nums1的下标[0,m+n-1]
		int p = m -- + n -- -1;
		while(m >= 0 && n >= 0) {
			//nums1[m]与nums2[n]谁大谁放在后面，放完之后，p、m或n都要前移
			nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		//把大的放在后面，如果nums1[m]大，nums1[m]全部移到后面时，此时n可能还>0
		//如果nums2[n]大，nums2[n]全部移到后面时，nums1[m]与原来相比没有变，所有不需要判断m是否>0
		while(n>=0) {
			nums1[p--] = nums2[n--];
		}
		
	}
	
	/**
	 *	归并排序合并数组部分，注意非空判断
	 *	
	 *	开辟了额外数组
	 */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int [] tempArr = new int[m+n];
        int p1 = 0,p2 = 0,p = 0;
        while(p1 < m && p2 < n) {
        	if(nums1[p1] <= nums2[p2]) {
        		tempArr[p ++] = nums1[p1 ++];
        	}else {
        		tempArr[p ++] = nums2[p2 ++];
        	}
        }
        while(p1 < m) {
        	tempArr[p ++] = nums1[p1 ++];
        }
        while(p2 < n) {
        	tempArr[p ++] = nums2[p2 ++];
        }
        for (int i = 0; i < tempArr.length; i++) {
			nums1[i] = tempArr[i];
		}
    }
    public static void main(String[] args) {
    	int [] nums1 = {1,1,1,0,0,0};
    	int [] nums2 = {2,5,6};  
    	//merge1(nums1, 3, nums2, 3);
    	merge2(nums1, 3, nums2, 3);
    	System.out.println(Arrays.toString(nums1));
	}

}
