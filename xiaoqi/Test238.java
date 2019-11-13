package algorithm;
/**
 * @date 11/11
 * @author xiaoqi
 * 题目：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Test238 {
	/*
	 * 同样使用双指针 i,j
	 * i 遍历数组
	 * j 存储不为零的元素
	 * 当nums[i] != 0时，就将i指向的元素赋给j,并且j++;
	 * 当把不为零的元素都赋给j，将j之后的都补为0.
	 */
	 public void moveZeroes(int[] nums) {
	       int  i = 0 ,j = 0;
	    for ( i = 0; i < nums.length; i++) {
	        if(nums[i] != 0) {
	            nums[j] = nums[i];
	            j++;
	        }   
	    }
	    while(j <nums.length) {
	        nums[j++] = 0;
	    }
	      
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
