package cn.andios;
/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019��10��8������8:24:11
 *
 */
public class Test283 {
	public static void moveZeroesDoublePointIfAllElementIs0(int[] nums) {
		/**
		 * 	����˫ָ��i,j����ʼ��ָ��nums[0]��
		 * i��0��nums.length-1����nums,
		 * j��0��ʼ����¼nums�в�Ϊ0��Ԫ�أ����jһ��<=i
		 * 
		 * 	���nums[i] == 0 
		 * 		i����,j����
		 * 	���nums[i] != 0
		 * 		��nums[i]��nums[j]����(�������Ͳ���ר�ŰѺ����Ԫ�ظ�Ϊ0)
		 * 		j ++;i ++
		 * 	
		 * 	�����迼��������������nums������Ԫ�ض���Ϊ0����ônums[i]��nums[j]�Ͳ���Ҫ����
		 *	 ֱ��i��λ�õ�����ĩβ��i == nums.length-1,nums[j,i)ȫΪ0 
		 */
		int i=0,j=0;
		while(i<nums.length) {
			if(nums[i] == 0) {
				i ++;
			}else {
				//�������Ԫ�ض���Ϊ0����ôi,j�Ͳ���Ҫ��������ʱֱ��++
				if(nums[j] == nums[i]) {
					j ++;
					i ++;
				}else {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					j ++;
					i ++;
				}	
			}
		}
	}
	public static void moveZeroesDoublePointWithOutAssign0(int[] nums) {
		/**
		 * 	����˫ָ��i,j����ʼ��ָ��nums[0]��
		 * 
		 * nums[i] == 0 
		 * 	i����,j����
		 * nums[i] != 0
		 * 	��nums[i]��nums[j]����,�������Ͳ���ר�ŰѺ����Ԫ�ظ�Ϊ0
		 * 	j ++;i ++
		 * 	ֱ��i��λ�õ�����ĩβ��i == nums.length-1,nums[j,i)ȫΪ0 
		 */
		int i=0,j=0;
		while(i<nums.length) {
			if(nums[i] == 0) {
				i ++;
			}else {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				
				j ++;
				i ++;
			}
		}
	}
	public static void moveZeroesDoublePoint(int[] nums) {
		/**
		 * ����˫ָ��i,j����ʼ��ָ��nums[0]��
		 * 
		 * nums[i] == 0 
		 * 	i����,j����
		 * nums[i] != 0
		 * 	nums[j] = nums[i]
		 * 	j ++;i ++
		 * ֱ��i��λ�õ�����ĩβ��i == nums.length-1,nums[j,i)ȫ��ֵΪ0
		 * 
		 * 
		 * nums[0]�Ƿ�Ϊ0û��Ӱ��
		 * 	nums[0]Ϊ0
		 * 		i���ƣ����iָ���Ԫ��Ϊ0��i���ƣ�j����
		 * 			    ���iָ���Ԫ�ز�Ϊ0����Ԫ���Ƶ�j��λ�ã�j���ƣ�i��������...
		 * 	nums[0]��Ϊ0
		 * 		i���ƣ�jҲ���ƣ����iָ���Ԫ��Ϊ0��i���ƣ�j����
		 * 			    ���iָ���Ԫ�ز�Ϊ0��i���ƣ�jҲ���ƣ�
		 * ֱ��i��λ�õ�����ĩβ��i == nums.length-1,nums[j,i)ȫ��ֵΪ0
		 */
		int i=0,j=0;
		while(i<nums.length) {
			if(nums[i] == 0) {
				i ++;
			}else {
				nums[j] = nums[i];
				j ++;
				i ++;
			}
		}
		//��0Ԫ���Ƶ�ǰ��󣬺����Ԫ��ȫ��Ϊ0
		for(int k = j; k<nums.length;k ++) {
			nums[k] = 0;
		}
	}
	
	public static void moveZeroes(int[] nums) {
        int count = 0;
        //�ȱ����������ж��ٸ�Ԫ�ز���0
        for(int i =0;i < nums.length;i ++){
            if(nums[i] != 0){
                count ++;
            }
        }
        int index = 0;
        //����0��Ԫ�ض�Ҫ��ǰ�ƣ�ȫ���Ƶ�0��ǰ�棬����[0,count)��Ų���0��Ԫ�أ�[count,nums.length)��0
        for(int j = 0;j< count;j++){
        	//index��ʼΪ0������һ�δ�nums�е�һ��Ԫ�ؿ�ʼ�����������ǲ���0����0���ùܣ�����0����Ҫ����nums[0]
            for(int i =index;i < nums.length;i ++){
                if(nums[i] != 0){
                    nums[j] = nums[i];
                    //��nums[i]���ҵ�һ������0��Ԫ�غ��´ξ�Ҫ������ε���һ��Ԫ�ؿ�ʼ�ң�����indexҪ++
                    index = i;
                    index ++;
                    //nums[j]����ֵ�󣬾�Ҫ����һ��jֵ�ٸ�ֵnums[j]����i�����ѭ��Ҫ��ֹ����Ϊ���Ѿ������˵�ǰj��nums[j]
                    break;
                }   
            }
        }
        for(int k =count;k < nums.length;k ++){
            nums[k] = 0;
        }
    }
	//����
	public static void main(String[] args) {
		int []array = {0,1,0,3,12};
//		moveZeroes(array);
//		moveZeroesDoublePoint(array);
//		moveZeroesDoublePointWithOutAssign0(array);
		moveZeroesDoublePointIfAllElementIs0(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}
