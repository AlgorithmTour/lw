package algorithm;

public class Test80 {
/**
 * @date 11/12
 *  @author xiaoqi
 *  @题目:
 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *  如[1,1,1,2,2,2,3,3] 返回[1,1,2,2,3,3]
 */
	 public static int removeDuplicates(int[] nums) {
		 /*
		  * 同样利用双指针，只不过这里多一个标志位。
		  * i 遍历数组 ，从1开始
		  * j 存储不重复的元素，从0开始
		  * flag 初始为false
		  * 当i指向的元素不等于j指向的元素时，j++,并且将i指向的元素赋给j，flag赋值为fasle
		  * 当i指向的元素等于j指向的元素时，flag赋值为true，j++,并且将i指向的元素赋给j;
		  * 当 i指向的元素等于j指向的元素时且flag等于true时，跳过。
		  * 
		  */
	        boolean flag = false;
	        int i = 1 ,j = 0;
	        for(;i< nums.length; i++) {
	            if((nums[j] == nums[i]) && (flag == true)) {
	                continue;
	            }
	            if(nums[j] == nums[i])
	            {
	                flag = true;
	                j++;
	                nums[j] = nums [i];
	            }
	            if(nums[j] != nums[i]) {
	                flag = false;
	                j++;
	                 nums[j] = nums [i];
	                
	            }
	     
	        }
	           return ++j;
	    }
	public static void main(String[] args) {
		 
		int array [] = {1,1,1,2,2,2,3,3};
		int i = 0;
		int n = removeDuplicates(array);
		for(;i<n;i++) {
			System.out.print(array[i]);
		}
	}

}
