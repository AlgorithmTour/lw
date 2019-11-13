package algorithm;

/**
 * @date: 11/12
 * @author xiaoqi
 * 
 * 题目：
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */

public class Test26 {
	/*
	 * 使用双指针i,j，
	 * i 用来遍历数组
	 * j 用来存储不重复的元素
	 * 只要当i指向的元素与j指向的不同就将j++,并且进行赋值nums[j] = nums[i]
	 * 
	 */ 
	public static int removeDuplicates(int[] nums) {
		
		int i = 1,j=0;
        for( ;i< nums.length;i++){
            if(nums[j] != nums[i]) {
                j++;  
                nums[j] = nums[i];                             
            }   
        }
        return  j+1;
        
		 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = {0,0,1,1,1,2,2,3,3,4};
		int i = 0;
		int n = removeDuplicates(array);
		for(;i<n;i++) {
			System.out.print(array[i]);
		}
		
	}

}
 
