package algorithm;
/**
 * @date 11.18
 * @author xiaoqi
 * @��Ŀ:
 * �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
 */
public class Test88 {
	/*
	 * ˼·�鲢����: �����ڽ�������������ϲ�Ϊһ���������顣
	 * ˫ָ��i,j,��һ��k�������Լ�һ����ϲ������鳤��һ���ĸ����ռ����飬
	 * ��ʼi,j��Ϊ0,ָ����������ĵ�һ��Ԫ�أ�
	 * �Ƚ�nums1[i] �� nums2[j]�Ĵ�С��С��ֵ�����¿��ٵ�����ռ䣬ֱ��һ������һ����������꣬ѭ��������
	 * �ڽ�ʣ��һ�������е�Ԫ�ط����¿��ٿռ��С�
	 */
	 public static  void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i=0, j=0,k = 0;
	        int[] nums1_copy = new int [m];
	        System.arraycopy(nums1, 0, nums1_copy, 0, m);
	        while(i<m && j<n){
	            nums1[k++] = nums1_copy[i]<nums2[j]?nums1_copy[i++]:nums2[j++];
	        }
	        // �����nums1_copy��ʣ���Ԫ�أ�����nums1_copyʣ�µ�Ԫ�ش���nums1��
	        while(i<m){
	            nums1[k++] = nums1_copy[i++];
	        }
	        // �����nums2��ʣ���Ԫ�أ�����nums2ʣ�µ�Ԫ�ش���nums1��
	        while(j<n){
	            nums1[k++] = nums2[j++];
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0,0};
		int[] nums2 = {2,3,4,6};
		merge(nums1,3,nums2,4);
		for(int i =0;i<nums1.length;i++) {
			System.out.print(nums1[i]);
		}
		
	}

}
