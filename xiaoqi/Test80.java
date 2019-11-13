package algorithm;

public class Test80 {
/**
 * @date 11/12
 *  @author xiaoqi
 *  @��Ŀ:
 *  ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
 *  ��[1,1,1,2,2,2,3,3] ����[1,1,2,2,3,3]
 */
	 public static int removeDuplicates(int[] nums) {
		 /*
		  * ͬ������˫ָ�룬ֻ���������һ����־λ��
		  * i �������� ����1��ʼ
		  * j �洢���ظ���Ԫ�أ���0��ʼ
		  * flag ��ʼΪfalse
		  * ��iָ���Ԫ�ز�����jָ���Ԫ��ʱ��j++,���ҽ�iָ���Ԫ�ظ���j��flag��ֵΪfasle
		  * ��iָ���Ԫ�ص���jָ���Ԫ��ʱ��flag��ֵΪtrue��j++,���ҽ�iָ���Ԫ�ظ���j;
		  * �� iָ���Ԫ�ص���jָ���Ԫ��ʱ��flag����trueʱ��������
		  * 
		  */
	        boolean flag = false;
	        int i = 1 ,j = 0;
	        for(;i< nums.length; i++) {
	            if((nums[j] == nums[i]) && (flag == true)) {
	                continue;
	            }
	            if(nums[j] == nums[i])
	            {
	                flag = true;
	                j++;
	                nums[j] = nums [i];
	            }
	            if(nums[j] != nums[i]) {
	                flag = false;
	                j++;
	                 nums[j] = nums [i];
	                
	            }
	     
	        }
	           return ++j;
	    }
	public static void main(String[] args) {
		 
		int array [] = {1,1,1,2,2,2,3,3};
		int i = 0;
		int n = removeDuplicates(array);
		for(;i<n;i++) {
			System.out.print(array[i]);
		}
	}

}
