package algorithm;
/**
 * @date 11/11
 * @author xiaoqi
 * ��Ŀ��
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 */
public class Test238 {
	/*
	 * ͬ��ʹ��˫ָ�� i,j
	 * i ��������
	 * j �洢��Ϊ���Ԫ��
	 * ��nums[i] != 0ʱ���ͽ�iָ���Ԫ�ظ���j,����j++;
	 * ���Ѳ�Ϊ���Ԫ�ض�����j����j֮��Ķ���Ϊ0.
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
