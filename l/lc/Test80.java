package cn.andios;
/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019��10��10������5:00:23
 *
 */
public class Test80 {
	
	/**
	 * 	�����������ź���
	 * 	��ΪҪȥ���ظ��������ϵ�Ԫ�أ����Զ���һ������j��������j��ʼΪ1����Ԫ�������������һ����ȵģ�j++��
	 * 	��ʱ���������ظ�Ԫ�أ���������������Ӧ��ȥ��
	 * 	
	 * 	����˫ָ�룬������������i,k
	 * 	i��0��nums.length-1����nums
	 * 	k��¼ȥ���ظ��������ϵ�Ԫ�غ������(������)
	 * 
	 * 	����һ������p,p��ʾ�����ж��ظ�������Ԫ��
	 * 
	 * 	i��1��ʼ��k��1��ʼ(�������һ��Ԫ��Ϊnums[0])����ʱpΪnums[0],j=1
	 * 	���nums[i] != p,��pԪ��ֻ����һ�Σ���ô���������һ��Ԫ��Ϊnums[i],k����
	 * 		��ʱp����Ϊnums[i]
	 * 	���nums[i] == p,��p�ֳ�����һ�Σ���ôj++����ʾp�������Σ���ʱ���������һ��Ԫ��
	 * 		��Ϊnums[i],k���ƣ�p������
	 * 	
	 * 	i ++���ж���һ��Ԫ��
	 * 	
	 * 	���nums[i] != p����pֻ�������Σ���ô���������һ��Ԫ��Ϊnums[i],k���ƣ�p����Ϊnums[i]
	 * 	���nums[i] == p����pֻ�����˵����Σ���Ӧ�ð����������pȥ�������ŵ��������м��ɣ�ֻ��i++
	 * 
	 */
    public static int removeDuplicates(int[] nums) { 
    	//�ǿ��ж�
    	if(nums == null || nums.length == 0)
    		//return -1;  ���ܷ���-1
    		return 0;
    	//�������Ԫ�صĸ���
    	int j = 1;
    	//kΪ��������±�
    	int k = 1;
    	int p = nums[0];
    	for(int i = 1;i < nums.length;i ++) {
    		if(nums[i] != p) {
    			//������p����ȵģ��ʹ浽��������
    			nums[k ++] = nums[i];
    			//�´����ж��ǣ����ж��ǲ��Ǻ��µ�p���
    			p = nums[i];
    			//��p��ȵ�Ԫ�ظ�����1������������
    			j =1;
    		}else {
    			//����nums[i]��p���
    			j ++;
    			//��ʱ��p��ȵ�Ԫ�������������浽��������
    			if(j == 2) {
    				nums[k ++] = nums[i];
    			}
    			//�����p��ȵ�Ԫ�ش���������������
    		}
    	}
        return k;  
    }
	
	public static void main(String[] args) {
		int [] array = {};
		int len = removeDuplicates(array);
		System.out.println("len��" + len);
		for(int j = 0;j <len;j ++) {
			System.out.print(array[j] + "\t");
		}
	}
}
