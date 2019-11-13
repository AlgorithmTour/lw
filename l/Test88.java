package cn.andios;

import java.util.Arrays;
/**
 * 88 75 215
 * @author LSD
 *
 * @datetime 2019��10��20������3:27:56
 *
 */
public class Test88 {

	/**
	 * �Ӻ���ǰ�жϣ�����Ҫ���ٶ���ռ�
	 */	
	private static void merge2(int[] nums1, int m, int[] nums2, int n) {
		//m��n��ʾԪ�ظ�����pΪ�ϲ���nums1���±�[0,m+n-1]
		int p = m -- + n -- -1;
		while(m >= 0 && n >= 0) {
			//nums1[m]��nums2[n]˭��˭���ں��棬����֮��p��m��n��Ҫǰ��
			nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		//�Ѵ�ķ��ں��棬���nums1[m]��nums1[m]ȫ���Ƶ�����ʱ����ʱn���ܻ�>0
		//���nums2[n]��nums2[n]ȫ���Ƶ�����ʱ��nums1[m]��ԭ�����û�б䣬���в���Ҫ�ж�m�Ƿ�>0
		while(n>=0) {
			nums1[p--] = nums2[n--];
		}
		
	}
	
	/**
	 *	�鲢����ϲ����鲿�֣�ע��ǿ��ж�
	 *	
	 *	�����˶�������
	 */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int [] tempArr = new int[m+n];
        int p1 = 0,p2 = 0,p = 0;
        while(p1 < m && p2 < n) {
        	if(nums1[p1] <= nums2[p2]) {
        		tempArr[p ++] = nums1[p1 ++];
        	}else {
        		tempArr[p ++] = nums2[p2 ++];
        	}
        }
        while(p1 < m) {
        	tempArr[p ++] = nums1[p1 ++];
        }
        while(p2 < n) {
        	tempArr[p ++] = nums2[p2 ++];
        }
        for (int i = 0; i < tempArr.length; i++) {
			nums1[i] = tempArr[i];
		}
    }
    public static void main(String[] args) {
    	int [] nums1 = {1,1,1,0,0,0};
    	int [] nums2 = {2,5,6};  
    	//merge1(nums1, 3, nums2, 3);
    	merge2(nums1, 3, nums2, 3);
    	System.out.println(Arrays.toString(nums1));
	}

}
