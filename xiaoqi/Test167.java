package algorithm;
/**
 * @date 11.23
 * @author xiaqi
 *@题目：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 */
public class Test167 {
	// 暴力解法
	 public static int[] twoSum1(int[] numbers, int target) {
		 	int count = 0;
		 	int[] arr = new int[numbers.length]; 
		 	int index = 0;	        
	        for(int i = 0;i<numbers.length;i++) {
	        	for(int j = i+1; j<numbers.length;j++) {
	        		if(numbers[i] + numbers[j] == target) {
	        			arr[index++] = i + 1;
	        			arr[index] = j + 1;
	        			index ++;
	        			count += 2;
	        		}
	        	}
	        }
	        int[] newArr = new int[count];
	        for(int i = 0;i<count;i++) {
	        	newArr[i] = arr[i];
	        }
	        return newArr;
	    }
	 // 二分查找     
	 /*
	  * 固定左值，利用二分查找找到右边部分的另外一个数（target-numbers[left]）的位置
	  */
	 public static  int binary(int[] numbers, int left, int right, int target){
	      	    while (left<=right){
	      	     int mid = left + (right - left) /2;
	            if(target == numbers[mid]) {
	                return mid;
	            }else if(target<numbers[mid]) {
	                right = mid -1;
	            }else{
	                left = mid +1;
	            }
	        }
	        return  -1;
	 }
	 // 指针碰撞
	 /*
	  * 左右两个指针碰撞，因为是有序数组，所以两指针元素之和小于target时，left指针++；两指针元素之和大于target时，right指针++；两指针元素之和等于target时， 返回两个指针位置。
	  */
	 public static int[] crash(int[] nums,int left,int right ,int target) {
		 	 
		 	 while(left < right) {
		 		 if(nums[left] + nums[right] > target) {
		 			 right--;
		 		 }else if(nums[left] + nums[right] < target) {
		 			 left++;
		 		 }else { 
		 			  return new int[] {left+1,right+1} ;
		 		 }
		 	 }
		 	 throw new RuntimeException("没有这样的值");
		 	 
		 	 
	 }
	 
	 

	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,2,3,5,4};
		int target = 6;
		
		// int[] newArr = twoSum1(arr,6);
		// int[] newArr = twoSum2(arr,6);
//		 int len = numbers.length;
//	        // 最后一个数不会成为起始的数字
//	        for (int left = 0; left < numbers.length - 1; left++) {
//	            // 挨个二分查找
//	            int right = binary(numbers, left + 1, len - 1, target - numbers[left]);
//	            if (right != -1) {
//	            	 newArr[0] = left+ 1;
//	            	 newArr[1] = right +1;
//	            }
//	        }
		int[] newArr = crash(numbers,0,numbers.length -1,target);
	     
	        System.out.print(newArr[0]+" "+ newArr[1]);

	 
		 
	}

}
