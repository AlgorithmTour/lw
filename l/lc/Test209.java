package cn.andios;

public class Test209 {

    public static int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	int l = 0,r = -1;//��������[l,r],����ұ�����
    	int sum = 0; //����������Ԫ�صĺ�
    	int res = nums.length + 1;//����������Ԫ�ظ���
    	while(l < nums.length) {
    		if(r+1 < nums.length && sum < s) {
    			r ++;
    			sum += nums[r];
    			
    		}else {
    			sum -= nums[l];
    			l ++;
    		}
    		if(sum >= s) {
    			res = Math.min(res, r-l+1);
    		}
    		
    	}
    	if(res == nums.length + 1) {
    		return 0;
    	}
        return res;
    }
	
	public static void main(String[] args) {
		int length = minSubArrayLen(7, new int []{2,3,1,2,4,3});
		System.out.println(length);
	}
}
