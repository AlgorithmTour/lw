package cn.andios;

/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019��10��9������2:59:24
 *
 */
public class Test27 {

	public static int removeElementWithoutSwap(int [] nums,int val) {
		/**
		 * 	����˫ָ��i,j����ʼ��ָ��nums[0]��
		 * 	i��0��nums.length-1����nums
		 * 	j��0��ʼ����¼ɾ��ָ��Ԫ�غ�ʣ���Ԫ�أ����jһ��<=i
		 * 
		 * 	�������Ľⷨ����Ϊ����Ҫ���������г����³��Ⱥ����Ԫ�أ����Բ��ý���
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
		 * 	����˫ָ��i,j����ʼ��ָ��nums[0]��
		 * 		���nums[i] != val,�ͽ�nums[i]��nums[j]������
		 * 		���nums[i] == val,nums[j]����
		 * 		i����
		 * 	ֱ��i�Ƶ�nums.lengthλ�á�����j��
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
		System.out.println("len��" + len);
		for (int i = 0; i < len; i++) {
			System.out.print(array[i]+"\t");
		}
	}
	
	
}
