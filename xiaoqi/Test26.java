package algorithm;

/**
 * @date: 11/12
 * @author xiaoqi
 * 
 * ��Ŀ��
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 *
 */

public class Test26 {
	/*
	 * ʹ��˫ָ��i,j��
	 * i ������������
	 * j �����洢���ظ���Ԫ��
	 * ֻҪ��iָ���Ԫ����jָ��Ĳ�ͬ�ͽ�j++,���ҽ��и�ֵnums[j] = nums[i]
	 * 
	 */ 
	public static int removeDuplicates(int[] nums) {
		
		int i = 1,j=0;
        for( ;i< nums.length;i++){
            if(nums[j] != nums[i]) {
                j++;  
                nums[j] = nums[i];                             
            }   
        }
        return  j+1;
        
		 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = {0,0,1,1,1,2,2,3,3,4};
		int i = 0;
		int n = removeDuplicates(array);
		for(;i<n;i++) {
			System.out.print(array[i]);
		}
		
	}

}
 
