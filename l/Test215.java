package cn.andios;

/**
 * 88 75 215
 * @author LSD
 *
 * @datetime 2019��10��20������3:27:11
 *
 */
public class Test215 {

	/**
	 * �ǿ��ж�
	 * 
	 * ʱ�临�Ӷ� ����������
	 * ���Ž� ����������
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
        	//ִ�е����left�����<=nums[left],left���ұ�>nums[left]
        	
        	/**
        	 * nums[left]��ʾ���ǵ� end-left+1�����
        	 */
        	int temp = end - left +1;
        	//�����ҵ���
        	if(k == temp) {
        		return nums[left];
        	}
        	
        	/**
        	 * 	Ҫ�ҵ������ұߣ�����left=2,��end=5����temp=4,left��indexΪ2����ʾ��3С��������ʾ��4�������
        	 * 	��k=3(kҪ��֤<temp),����left���ұ��ҵ�3�������
        	 */
        	else if(k < temp) {
        		return partition(nums, left + 1, end, k);
        	}
        	/**
        	 * 	Ҫ�ҵ�������ߣ�����left=2,��end=5��start=0,��temp=4,left��indexΪ2����ʾ��3С��������ʾ��4�������
        	 * 	��k=5(kҪ��֤>temp),����left�����(0-1)�ҵ�1��(k-temp)������
        	 */
        	else{
        		return partition(nums, start, left - 1, k-temp);
            }
        	
        	
        	
//        	//��ʱleft��right�غϣ�nums[left]��ʾ���ǵ� left-start+1�����(Ӧ���ǵڵ� left-start+1�󣬶����Ǵ�)
//        	int temp = left - start + 1;
//        	if(k == temp) {
//        		return nums[left];
//        	}
//        	//Ҫ�ҵ�������ߣ�����left=4,��start=0����temp=5,left��indexΪ4����ʾ��5�����
//        	//��k=2������0-3�����ҵ�2�����
//        	else if(k < temp) {
//        		return partition(nums, start, left - 1, k);
//        	}
//        	//Ҫ�ҵ������ұߣ�����left=4,��start=0����temp=5,left��indexΪ4����ʾ��5�����
//        	//��k=7��end=100,����5-100�����ҵ�2���������
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
    	System.out.println("e��" + e);
	}
}