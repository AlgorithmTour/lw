package algorithm;
/**
 * @date��11/26
 * @author xiaoqi
 * @��Ŀ������һ������ n ���������������һ�������� s ���ҳ���������������� �� s �ĳ�����С�����������顣��������ڷ������������������飬���� 0��
 * ˼·����������
 * 1:���[i,j]����������С��s,j++,��[i,j]���ڵ���s����¼����Ӵ��ĳ��ȣ�
 * 2:i++,ֱ��[i,j]С��s,�ظ�1
 * 3:�ظ������1,2ֱ����������������
 */
public class Test209 {
	 public static  int minSubArrayLen(int s, int[] nums) {
		 for(int i = 0 ;i<nums.length;i++) {
			 if(nums[i] == s) {
				 return 1;
			 }
		 }
	     int len = 2;
	     while(len <= nums.length) {
	    	 int left = 0,right = len-1;
	    	 while(right<=nums.length -1) {
	    		 int num = 0;
	    		 for(int i = left;i<=right;i++) {
	    			 num += nums[i];
	    		 }
	    		 if(num>=s) {
	    			 System.out.println(left+" "+right);
	    			 return len;
	    		 }else {
	    			 left++;
	    			 right++;
	    		 }
	    	 }
	    	 len++;
	     }
		 return 0;
	 }
	 // ��������
	 public static  int minSubArrayLen2(int s, int[] nums) {
		 int left = 0,right = -1;
		 int len = nums.length + 1;
		 int num = 0;
		 while(left < nums.length ) {
			 if(right < nums.length-1 && num < s) {
				 right++;			
				 num += nums[right];
			 }else {
				 num -= nums[left++];
			 }
			 if(num >= s) {
				 len = Math.min(len, right - left + 1);
			 }
			
		 }
		 if(len == nums.length+1) {
			 return 0;
		 }
		 
		 return len;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,2,4,3};
		int k = minSubArrayLen2(7, nums);
		System.out.print(k);
	}

}
