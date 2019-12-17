package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @data 12/17
 * @author xiaoqi
 * @题目： 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @思路： 
 */
public class Test242 {
	// 方法一：使用hashMap
    public static boolean isAnagram(String s, String t) {
    	Map<Character, Integer> map1 = new HashMap<>();
    	char[] sh = s.toCharArray();
    	char[] th = t.toCharArray();
    	for(int  i = 0; i< sh.length;i++) {	 
    	   map1.put(sh[i],map1.getOrDefault(sh[i],  0) + 1 );	 
    	}
    	for(int i = 0;i<th.length;i++) {
    		// 如果不包含就返回false
    		if(!map1.containsKey(th[i])) {
    			return false;
    		}
    		// 包含就将值减一
    	   map1.put(th[i],map1.get(th[i])- 1 );
    	   // 如果值减为0 就将这个键移除
    	   if(map1.get(th[i]) == 0) {
    		   map1.remove(th[i]);
    	   }
    	}
    	// 最后 如果map1中刚好为空说明是异同数
//    	if(map1.isEmpty()) {
//    		return true;
//    	}
//    	return false;
    	return map1.isEmpty();
        
    }
    // 方法二：使用数组
    public static boolean isAnagram2(String s, String t) {
    	int[] sh = new int[26];
    	int[] th = new int[26];
    	char[] sh1 = s.toCharArray();
    	char[] th1 = t.toCharArray();
    	for(int i =0;i<sh1.length;i++) {
    		sh[sh1[i] - 'a']++;
    	}
    	for(int i = 0;i<th1.length;i++) {
    		th[th1[i] - 'a']++;
    	}
    	for(int i = 0;i<sh.length;i++) {
    		if(sh[i] != th[i]) {
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		String t = "ab";
		System.out.print(isAnagram2(s, t));	
	}

}
