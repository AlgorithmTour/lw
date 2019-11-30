package algorithm;
/**
 * @date 11/30
 * @author xiaoqi
 *  @题目： 给定两个数组，编写一个函数来计算它们的交集。输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2]
 * 思路： 使用set
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test349 {
	// 方法一：一个set，一个array。将 nums1数组转为set，在检测set中是否含有num2数组的元素，将含有的数组元素添加到array中。注意要将set含有nums2元素的元素移除，以免发生重复
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
				s.remove(nums2[i]); // 将set含有nums2元素的元素移除，以免发生重复
			}
		}
		 return Arrays.copyOf(array, index);	 
    }
	// 方法2：两个set，一个array
	public static int[] intersection2(int[] nums1, int[] nums2) {
		// 创建nums1与nums2的set
		Set<Integer> s = new HashSet<Integer>();
		Set<Integer> s1 = new HashSet<Integer>();
		for(int num : nums1) {
			s.add(num);
		}
		for(int num: nums2) {
			s1.add(num);
		}
		// 两个set的交集
		s.retainAll(s1);
		// 将s转数组
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
