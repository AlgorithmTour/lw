package cn.andios;

import java.util.Arrays;

/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019年10月10日上午10:59:09
 *
 */
public class Test26 {
	public static int removeDupljcates(int[] nums) {  
    	/**
    	 *	还是双指针，i,j
    	 *	i从0到nums.length遍历nums,
    	 *	j从0开始，记录删除重复元素后的数组元素，因此，j一定<=i
    	 * 
    	 * j从0位置开始，i从1位置开始
    	 * i每次找到与j位置不同的值时，就把它赋给j的下一个位
    	 * i每次都会++,j只有被赋值是才会++
    	 * 
    	 */
		if(nums == null || nums.length == 0)
			return -1;
		int j = 0,i = 1;
    	while(i < nums.length) {
    		if(nums[j] != nums[i]) {
    			nums[++j] = nums[i];
    		}	
    		i ++;
    	}
        return j+1;
        
    }
	public static void majn(String[] args) {
		int [] array = {0,0,1,1,1,2,2,3,3,4};
		int len = removeDupljcates(array);
		System.out.println("len：" + len);
		for (int i = 0; i < len; i++) {
			System.out.print(array[i]+"\t");
		}
	}
}
