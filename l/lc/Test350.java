package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * hashmap或双指针
 * @author LSD
 *
 * @datetime 2019年11月26日下午7:21:53
 *
 */
public class Test350 {

	/**
	 * hashmap优化
	 */
    public static int[] intersect2(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int k = 0;
    	for (int i = 0; i < nums1.length; i++) {
    		map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
		}
    	
    	Set<Entry<Integer, Integer>> entrySet = map.entrySet();
    	Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
    	while(iterator.hasNext()) {
    		Entry<Integer, Integer> next = iterator.next();
    		System.out.println(next.getKey()+"-"+next.getValue());
    	}
    	
    	for (int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i])&& map.get(nums2[i])>0) {			
				map.put(nums2[i], map.get(nums2[i])-1);
				nums1[k++]=nums2[i];				
			}
		}	
    	return Arrays.copyOfRange(nums1, 0, k);
    }
	
	/**
	 * hashmap
	 */
    public static int[] intersect1(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	List<Integer> result = new ArrayList<Integer>();
    	
    	for (int i = 0; i < nums1.length; i++) {
    		if(!map.containsKey(nums1[i])) 
    			map.put(nums1[i], 1);
            else 
            	map.put(nums1[i], map.get(nums1[i]) + 1);
		}
    	    	
    	for (int i = 0; i < nums2.length; i++) {
			if(map.containsKey(nums2[i])) {			
				map.put(nums2[i], map.get(nums2[i])-1);
				if(map.get(nums2[i]) == 0) {
					map.remove(nums2[i]);
				}
				result.add(nums2[i]);
				
			}
		}	
    	return result.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
		String str1 = Arrays.toString(intersect1(new int[] {4,9,5}, new int [] {9,4,9,8,4}));
		String str2 = Arrays.toString(intersect2(new int[] {4,9,5}, new int [] {9,4,9,8,4}));
		System.out.println(str2);
	}
}
