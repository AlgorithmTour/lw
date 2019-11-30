package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * @date 11/30
 * @author xiaoqi
 * @��Ŀ�� �����������飬��дһ���������������ǵĽ�����
        ����: nums1 = [1,2,2,1], nums2 = [2,2]
        ���: [2,2]
   @˼·��  (1)ʹ��Map
   		 (2)�����򣬺�Ƚϣ���ͬ�ľͷ��������С�
 */
public class Test350 {
	// ����һ��ʹ��Map
	 public  static int[] intersect(int[] nums1, int[] nums2) {
		 Map<Integer, Integer>  map = new HashMap();
		 int array[] = new int[Math.max(nums1.length, nums2.length)];
		 int index = 0;
		 for (int i = 0; i < nums1.length; i++) {
			 // map.getOrDefault(nums1[i], 0)�÷����ж�nums[i]�Ƿ���map�����С����û�оͽ�ֵ��Ϊ0���еĻ���ֵ��1��
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1); 
		}
		 for(int  i = 0;i < nums2.length;i++) {
			 if(map.containsKey(nums2[i])) {
				 array[index++] = nums2[i];
				 // �������nums2[i],��Ҫ����ֵ-1,���ֵ����0���ͽ����Ƴ�
				 map.put(nums2[i],map.get(nums2[i]) -1 );
				 if(map.get(nums2[i]) ==  0) {
					 map.remove(nums2[i]);
				 }
			 }
		 }
		 
		return Arrays.copyOf(array, index) ;     
	 }
	 // ��������
	 public  static int[] intersect2(int[] nums1, int[] nums2) {
		 Arrays.sort(nums1);
		 Arrays.sort(nums2);
		 int i = 0 ,j = 0,index = 0;
 		 int[] array =  new int[Math.max(nums1.length,nums2.length)];
		 while(i < nums1.length && j< nums2.length) {
			 if(nums1[i] == nums2[j]) {
				 array[index++] = nums1[i];
				 i++;
				 j++;
				 
				
			 }else if (nums1[i] > nums2[j]) {
				 j++;
			 }else {
				 i++;
			 }
		 }
		 
		 return Arrays.copyOf(array, index);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,1};
		int[] nums2 =  {2,2};
		
		int[] arr = intersect2(nums1, nums2);
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
	}

}
