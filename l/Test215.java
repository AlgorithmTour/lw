package cn.andios;

/**
 * 88 75 215
 * @author LSD
 *
 * @datetime 2019年10月20日下午3:27:11
 *
 */
public class Test215 {

	/**
	 * 非空判断
	 * 
	 * 时间复杂度 ？？？？？
	 * 更优解 ？？？？？
	 */
    public static int findKthLargest(int[] nums, int k) {
    	if(nums == null || nums.length == 0 || nums.length < k) {
    		return 0;
    	}
    	int start = 0,end = nums.length - 1;
        int index = partition(nums,start,end,k);
        return index;
    }
    private static int partition(int[] nums,int start,int end,int k) {
    	int pivot = nums[start];
    	int left = start,right = end;
    	if(start < end) {
        	while(left != right) {
        		while(nums[right] > pivot && left < right) {
        			right --;
        		}
        		while(nums[left] <= pivot && left < right) {
        			left ++;
        		}
        		if(left < right) {
        			swap(nums, left, right);
        		}
        	}
        	swap(nums, start, left);
        	//执行到这里，left的左边<=nums[left],left的右边>nums[left]
        	
        	/**
        	 * nums[left]表示的是第 end-left+1大的数
        	 */
        	int temp = end - left +1;
        	//碰巧找到了
        	if(k == temp) {
        		return nums[left];
        	}
        	
        	/**
        	 * 	要找的数在右边，比如left=2,若end=5，则temp=4,left的index为2，表示第3小的数，表示第4大的数，
        	 * 	若k=3(k要保证<temp),则在left的右边找第3大的数。
        	 */
        	else if(k < temp) {
        		return partition(nums, left + 1, end, k);
        	}
        	/**
        	 * 	要找的数在左边，比如left=2,若end=5，start=0,则temp=4,left的index为2，表示第3小的数，表示第4大的数，
        	 * 	若k=5(k要保证>temp),则在left的左边(0-1)找第1大(k-temp)的数。
        	 */
        	else{
        		return partition(nums, start, left - 1, k-temp);
            }
        	
        	
        	
//        	//此时left与right重合，nums[left]表示的是第 left-start+1大的数(应该是第第 left-start+1大，而不是大)
//        	int temp = left - start + 1;
//        	if(k == temp) {
//        		return nums[left];
//        	}
//        	//要找的数在左边，比如left=4,若start=0，则temp=5,left的index为4，表示第5大的数
//        	//若k=2，即在0-3上面找第2大的数
//        	else if(k < temp) {
//        		return partition(nums, start, left - 1, k);
//        	}
//        	//要找的数在右边，比如left=4,若start=0，则temp=5,left的index为4，表示第5大的数
//        	//若k=7，end=100,即在5-100上面找第2大的数即可
//        	else {
//        		return partition(nums, left + 1, end, k-temp);
//        	}
    	}else {
    		return pivot;
    	}

	}
    private static void swap(int [] arr,int a,int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void main(String[] args) {
    	int [] nums = {3,2,1,5,6,4};
    	int e = findKthLargest(nums, 2 );
    	System.out.println("e：" + e);
	}
}