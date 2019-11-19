package algorithm;
/**
 * @date 11.18
 * @author xiaoqi
 * @题目:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
public class Test88 {
	/*
	 * 思路归并排序: 适用于将两个有序数组合并为一个有序数组。
	 * 双指针i,j,和一个k变量，以及一个与合并后数组长度一样的辅助空间数组，
	 * 初始i,j都为0,指向两个数组的第一个元素；
	 * 比较nums1[i] 与 nums2[j]的大小，小的值赋给新开辟的数组空间，直到一个其中一个数组遍历完，循环结束；
	 * 在将剩下一个数组中的元素放在新开辟空间中。
	 */
	 public static  void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i=0, j=0,k = 0;
	        int[] nums1_copy = new int [m];
	        System.arraycopy(nums1, 0, nums1_copy, 0, m);
	        while(i<m && j<n){
	            nums1[k++] = nums1_copy[i]<nums2[j]?nums1_copy[i++]:nums2[j++];
	        }
	        // 如果是nums1_copy有剩余的元素，遍历nums1_copy剩下的元素存在nums1中
	        while(i<m){
	            nums1[k++] = nums1_copy[i++];
	        }
	        // 如果是nums2有剩余的元素，遍历nums2剩下的元素存在nums1中
	        while(j<n){
	            nums1[k++] = nums2[j++];
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0,0};
		int[] nums2 = {2,3,4,6};
		merge(nums1,3,nums2,4);
		for(int i =0;i<nums1.length;i++) {
			System.out.print(nums1[i]);
		}
		
	}

}
