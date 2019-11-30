package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * @date 11/30
 * @author xiaoqi
 * @题目： 给定两个数组，编写一个函数来计算它们的交集。
        输入: nums1 = [1,2,2,1], nums2 = [2,2]
        输出: [2,2]
   @思路：  (1)使用Map
   		 (2)先排序，后比较，相同的就放在数组中。
 */
public class Test350 {
	// 方法一：使用Map
	 public  static int[] intersect(int[] nums1, int[] nums2) {
		 Map<Integer, Integer>  map = new HashMap();
		 int array[] = new int[Math.max(nums1.length, nums2.length)];
		 int index = 0;
		 for (int i = 0; i < nums1.length; i++) {
			 // map.getOrDefault(nums1[i], 0)该方法判断nums[i]是否在map集合中。如果没有就将值赋为0，有的话将值加1；
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1); 
		}
		 for(int  i = 0;i < nums2.length;i++) {
			 if(map.containsKey(nums2[i])) {
				 array[index++] = nums2[i];
				 // 如果包含nums2[i],就要将其值-1,如果值减到0，就将键移除
				 map.put(nums2[i],map.get(nums2[i]) -1 );
				 if(map.get(nums2[i]) ==  0) {
					 map.remove(nums2[i]);
				 }
			 }
		 }
		 
		return Arrays.copyOf(array, index) ;     
	 }
	 // 方法二：
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
