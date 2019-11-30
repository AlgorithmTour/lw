package algorithm;
/**
 * @date 11/30
 * @author xiaoqi
 *  @��Ŀ�� �����������飬��дһ���������������ǵĽ���������: nums1 = [1,2,2,1], nums2 = [2,2] ���: [2]
 * ˼·�� ʹ��set
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test349 {
	// ����һ��һ��set��һ��array���� nums1����תΪset���ڼ��set���Ƿ���num2�����Ԫ�أ������е�����Ԫ����ӵ�array�С�ע��Ҫ��set����nums2Ԫ�ص�Ԫ���Ƴ������ⷢ���ظ�
	public static int[] intersection1(int[] nums1, int[] nums2) {
		Set<Integer> s = new HashSet<Integer>();
		Set<Integer> s1 = new HashSet<Integer>();
		int[] array = new int[Math.min(nums1.length,nums2.length)];
		int index = 0;
		for(int i = 0;i<nums1.length;i++) {
			s.add(nums1[i]);
		}
		for(int i = 0;i<nums2.length;i++) {
			if(s.contains(nums2[i])) {
				array[index++] = nums2[i];
				s.remove(nums2[i]); // ��set����nums2Ԫ�ص�Ԫ���Ƴ������ⷢ���ظ�
			}
		}
		 return Arrays.copyOf(array, index);	 
    }
	// ����2������set��һ��array
	public static int[] intersection2(int[] nums1, int[] nums2) {
		// ����nums1��nums2��set
		Set<Integer> s = new HashSet<Integer>();
		Set<Integer> s1 = new HashSet<Integer>();
		for(int num : nums1) {
			s.add(num);
		}
		for(int num: nums2) {
			s1.add(num);
		}
		// ����set�Ľ���
		s.retainAll(s1);
		// ��sת����
		int[] array = new int[ s.size()];
		int k = 0;
		for(int nums: s) {
			array[k++] = nums;
		}
		return array;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		int[] nums1 = {1,2,2,1};
		int[] nums2 =  {2,2};
		
		int[] arr = intersection2(nums1, nums2);
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		
		}

}
