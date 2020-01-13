package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年11月25日上午11:28:08
 *
 */
public class Test349 {

    public static int[] intersection(int[] nums1, int[] nums2) {
    	
    	List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
    	List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
    	
    	List<Integer> collect = list1.stream().filter(item -> list2.contains(item)).distinct().collect(Collectors.toList());
    	
        return collect.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
		String str = Arrays.toString(intersection(new int[] {4,9,5},new int [] {9,4,9,8,4} ));
		System.out.println(str);
	}
}
