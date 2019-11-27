package algorithm;
/**
 * @date：11/26
 * @author xiaoqi
 * @题目：给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 思路：滑动窗口
 * 1:如果[i,j]连续子数组小于s,j++,当[i,j]大于等于s，记录这个子串的长度；
 * 2:i++,直到[i,j]小于s,重复1
 * 3:重复上面的1,2直到遍历完整个数组
 */
public class Test209 {
	 public static  int minSubArrayLen(int s, int[] nums) {
		 for(int i = 0 ;i<nums.length;i++) {
			 if(nums[i] == s) {
				 return 1;
			 }
		 }
	     int len = 2;
	     while(len <= nums.length) {
	    	 int left = 0,right = len-1;
	    	 while(right<=nums.length -1) {
	    		 int num = 0;
	    		 for(int i = left;i<=right;i++) {
	    			 num += nums[i];
	    		 }
	    		 if(num>=s) {
	    			 System.out.println(left+" "+right);
	    			 return len;
	    		 }else {
	    			 left++;
	    			 right++;
	    		 }
	    	 }
	    	 len++;
	     }
		 return 0;
	 }
	 // 滑动窗口
	 public static  int minSubArrayLen2(int s, int[] nums) {
		 int left = 0,right = -1;
		 int len = nums.length + 1;
		 int num = 0;
		 while(left < nums.length ) {
			 if(right < nums.length-1 && num < s) {
				 right++;			
				 num += nums[right];
			 }else {
				 num -= nums[left++];
			 }
			 if(num >= s) {
				 len = Math.min(len, right - left + 1);
			 }
			
		 }
		 if(len == nums.length+1) {
			 return 0;
		 }
		 
		 return len;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,2,4,3};
		int k = minSubArrayLen2(7, nums);
		System.out.print(k);
	}

}
