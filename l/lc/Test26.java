package cn.andios;

import java.util.Arrays;

/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019��10��10������10:59:09
 *
 */
public class Test26 {
	public static int removeDupljcates(int[] nums) {  
    	/**
    	 *	����˫ָ�룬i,j
    	 *	i��0��nums.length����nums,
    	 *	j��0��ʼ����¼ɾ���ظ�Ԫ�غ������Ԫ�أ���ˣ�jһ��<=i
    	 * 
    	 * j��0λ�ÿ�ʼ��i��1λ�ÿ�ʼ
    	 * iÿ���ҵ���jλ�ò�ͬ��ֵʱ���Ͱ�������j����һ��λ
    	 * iÿ�ζ���++,jֻ�б���ֵ�ǲŻ�++
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
		System.out.println("len��" + len);
		for (int i = 0; i < len; i++) {
			System.out.print(array[i]+"\t");
		}
	}
}
