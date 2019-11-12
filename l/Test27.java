package cn.andios;

/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019年10月9日下午2:59:24
 *
 */
public class Test27 {

	public static int removeElementWithoutSwap(int [] nums,int val) {
		/**
		 * 	利用双指针i,j，开始都指向nums[0]，
		 * 	i从0到nums.length-1遍历nums
		 * 	j从0开始，记录删除指定元素后剩余的元素，因此j一定<=i
		 * 
		 * 	相比下面的解法，因为不需要考虑数组中超出新长度后面的元素，所以不用交换
		 */
		int i = 0,j = 0;
		while(i < nums.length) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j ++;				
			}
			i ++;
			
		}
		return j;
	}
	
	public static int removeElement(int[] nums, int val) {
	    /**
		 * 	利用双指针i,j，开始都指向nums[0]，
		 * 		如果nums[i] != val,就将nums[i]与nums[j]交换，
		 * 		如果nums[i] == val,nums[j]不动
		 * 		i后移
		 * 	直到i移到nums.length位置。返回j。
		 * 
		 */
		int j = 0;
		for(int i = 0;i <nums.length;i ++) {
			if(nums[i] != val) {
				if(nums[i] == nums[j]) {
					j ++;
				}else {
					swap(nums, j, i);				
					j ++;
				}
				
			}
		}
		return j;
    }

	private static void swap(int[] nums, int j, int i) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int []array = {0,1,2,2,3,0,4,2}; 
		int len = removeElementWithoutSwap(array, 2);
		System.out.println("len：" + len);
		for (int i = 0; i < len; i++) {
			System.out.print(array[i]+"\t");
		}
	}
	
	
}
