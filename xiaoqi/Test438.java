package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @date 12/1
 * @author xiaoqi
 * @题目：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * @思路：滑动窗口 
 */
public class Test438 {
     // 方法一：
	 public static List<Integer> findAnagrams(String s, String p) {
		 List<Integer> list1 = new ArrayList<>();// 存储最终的结果的list集合
		 // 判断如果s小于p的长度直接返回
		  if (s == null || p == null || s.length() < p.length())
	             return list1;
		 // 滑动窗口[left, right]
		 int left  = 0,right = p.length() - 1;
		 char[] ch = p.toCharArray();
		 // 计算p字符串的频率
		 int arr[] = new int[26]; 
		 int n = 0;
		 while( n  < p.length()) { 
			 arr[ch[n]-'a']++;
			 n++;	 
		 }
		 
	while(right < s.length()) {
		     //计算频率
		     char[] ss = s.substring(left, right+1).toCharArray();
			 int brr[] = new int[26]; 
			 int i= 0;
			 while( i  < p.length()) { 
				 brr[ss[i]-'a']++;
				 i++;	 
			 }
			 
			 // 比较两个数组的是否相等，如果相等list1就添加left.
			 boolean com = compare(arr, brr);
			 if(com) {
				 list1.add(left);
			 }
			 left++;
			 right++;
			  	 
		}
	    	 
		 return list1;   
}
	// 方法2  优化 ：不使用字符串的截取方法
	 public static List<Integer> findAnagrams1(String s, String p) {
		 List<Integer> list1 = new ArrayList<>();// 存储最终的结果的list集合
		 // 判断如果s小于p的长度直接返回
		  if (s == null || p == null || s.length() < p.length())
	             return list1;
		 // 滑动窗口[left, right]
		 int left  = 0,right = p.length() - 1;
		 char[] ch = p.toCharArray();
		 char[] ss = s.toCharArray();
		 // 计算p字符串的频率 、 与p长度相同的s中的字符串频率 
		 int arr[] = new int[26]; 
		 int brr[] = new int[26]; 
		 int n = 0;
		 while( n  < p.length()) { 
			 arr[ch[n]-'a']++;
			 brr[ss[n]-'a']++;
			 n++;	 
		 }
		 
		 while(right+1 < s.length()) {
			 // 比较两个数组的是否相等，如果相等list1就添加left.
			 boolean com = compare(arr, brr);
			 if(com) {
				 list1.add(left);
			 }
			 brr[ss[left++] - 'a']--;	 
			 brr[ss[++right] - 'a']++;  	 
		 }
		 // 要判断最后一次的窗口值是否满足
		 if(compare(arr, brr)) {
			 list1.add(left);
		 }
	    	 
		 return list1;   
}
	 public static boolean compare(int[] arr, int[] brr) {
		  for(int i = 0;i<arr.length;i++) {
			  if(arr[i] != brr[i]) {
				  return false;
			  }
		  }
		  return true;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> list = new ArrayList<>();
		list = findAnagrams1(s, p);
		System.out.print(list);
	}

}
