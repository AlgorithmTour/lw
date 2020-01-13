package cn.andios;
/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019年10月10日下午5:00:23
 *
 */
public class Test80 {
	
	/**
	 * 	给定数组已排好序
	 * 	因为要去除重复两次以上的元素，所以定义一个变量j来计数，j初始为1，即元素自身，如果碰到一个相等的，j++，
	 * 	此时已有两个重复元素，后面再遇到，就应该去掉
	 * 	
	 * 	还是双指针，定义两个变量i,k
	 * 	i从0到nums.length-1遍历nums
	 * 	k记录去掉重复两次以上的元素后的数组(新数组)
	 * 
	 * 	定义一个变量p,p表示正在判断重复次数的元素
	 * 
	 * 	i从1开始，k从1开始(新数组第一个元素为nums[0])，此时p为nums[0],j=1
	 * 	如果nums[i] != p,即p元素只出现一次，那么新数组第下一个元素为nums[i],k后移
	 * 		此时p更新为nums[i]
	 * 	如果nums[i] == p,即p又出现了一次，那么j++，表示p出现两次，此时新数组第下一个元素
	 * 		仍为nums[i],k后移，p不更新
	 * 	
	 * 	i ++，判断下一个元素
	 * 	
	 * 	如果nums[i] != p，即p只出现两次，那么新数组第下一个元素为nums[i],k后移，p更新为nums[i]
	 * 	如果nums[i] == p，即p只出现了第三次，就应该把这次遇到的p去掉，不放到新数组中即可，只把i++
	 * 
	 */
    public static int removeDuplicates(int[] nums) { 
    	//非空判断
    	if(nums == null || nums.length == 0)
    		//return -1;  不能返回-1
    		return 0;
    	//计数相等元素的个数
    	int j = 1;
    	//k为新数组的下标
    	int k = 1;
    	int p = nums[0];
    	for(int i = 1;i < nums.length;i ++) {
    		if(nums[i] != p) {
    			//碰到和p不相等的，就存到新数组中
    			nums[k ++] = nums[i];
    			//下次再判断是，就判断是不是和新的p相等
    			p = nums[i];
    			//和p相等的元素个数是1，就是他自身
    			j =1;
    		}else {
    			//碰到nums[i]与p相等
    			j ++;
    			//此时与p相等的元素有两个，保存到新数组中
    			if(j == 2) {
    				nums[k ++] = nums[i];
    			}
    			//如果与p相等的元素大于两个，不考虑
    		}
    	}
        return k;  
    }
	
	public static void main(String[] args) {
		int [] array = {};
		int len = removeDuplicates(array);
		System.out.println("len：" + len);
		for(int j = 0;j <len;j ++) {
			System.out.print(array[j] + "\t");
		}
	}
}
