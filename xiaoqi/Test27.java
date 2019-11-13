package algorithm;
/**
 * @date 11/12
 * @author  xiaoqi
 * 
 * 题目：
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 */
public class Test27 {
	/*
	 * 同样利用双指针 i,j
	 * i 遍历数组
	 * j 用来存储不等于val的元素
	 * 只要当i指向的元素不等于val,就将i指向的元素赋给num[j],并且j++
	 */
	 public static int removeElement(int[] nums, int val) {
	        int i = 0,j = 0;
	        int len =  nums.length;
	        for(;i < len; i++) {
	            if(nums[i] != val) {
	                nums[j] = nums[i];
	                j++;
	            }
	        }
	        return j;
	    }
	public static void main(String[] args) {
			int array [] = {3,2,4,3,5,3};
			int i = 0;
			int n = removeElement(array,3);
			for(;i<n;i++) {
				System.out.print(array[i]);
			}
			
	}

}
