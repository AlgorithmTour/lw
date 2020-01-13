package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019年11月19日下午7:23:11
 *
 */
public class Test438 {

	/**
	 * 因为不考字母顺序，只考虑包含相同的字母，所以用数组来存储，
	 * 只记录各个字母存在的次数，而不管顺序
	 */
    public static List<Integer> findAnagrams2(String s, String p) {    	
    	 List<Integer> list = new ArrayList<>();
         if (s == null || p == null || s.length() < p.length())
             return list;
         //记录p中的字母
         int [] pArr = new int[26];
         //记录s中的字母
         int [] window = new int[26];

         for (int i=0; i<p.length(); i++){
        	 //记录p串有哪些字符
        	 pArr[p.charAt(i) - 'a']++;     
        	 //记录s中长度 为p.length(),滑动窗口为[i,j]的字母，判断这一部分是否与pArr相等。
        	 //如果相等，表示找到了
        	 //如果不等，区间后移一位
             window[s.charAt(i) - 'a']++;
         }

         //固定宽度的窗口[i,j]，长度为p.length(),从s的0索引位置开始
         int i = 0;
         int j = p.length()-1;

         //窗口右边界滑到s右边界之前
         while (j+1 < s.length()){
        	 //如果p与窗口[i,j]的元素相同，将i放入list
             if (isSame(pArr, window))
                 list.add(i);
             //如果p与窗口[i,j]的元素不同，窗口右移一位，
             //即i和j都++，但i位置值要去掉，j+1位置值要加到window内
             window[s.charAt(i++) - 'a']--;
             window[s.charAt(++j) - 'a']++; 
         }
         //窗口最后一次右移时，j移到了s最末尾，此时跳出了循环，没有经过循环中的if判断，所以这里要补一次
         if (isSame(pArr, window))   // 检查最末尾的 p.length() 个字符是否符合条件
             list.add(i);
         
         return list;
    }
	
    public static boolean isSame(int[] arr1, int[] arr2){
        for (int i=0; i<arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

	//超时
    public static List<Integer> findAnagrams1(String s, String p) {
    	if(s == null || s.length() < p.length()) {
    		return new ArrayList<Integer>();
    	}
        List<Integer> list = new ArrayList<Integer>();
        
        List<Character> list2 = new ArrayList<Character>();
        
        fillList(list2, p);
        
        int l=0,r=-1;//滑动区间[l,r]
        int len=0;//记录滑动区间内元素的个数
        
        while(l < s.length()-p.length()+1) {
        	if(r+1 < s.length()) {
        		if(list2.indexOf(s.charAt(++r)) == -1){
        			if(list2.size() != p.length())
        				fillList(list2, p);
	        		l = s.indexOf(s.charAt(r), l)+1;
	        		r = l-1;
        		}else{  
	        		len = r-l+1;
	        		list2.remove(new Character(s.charAt(r)));
	        		if(len == p.length() && list2.size() == 0) {
	        			fillList(list2, p);
	        			list.add(l);
	        			l ++;
	        			r = l-1;
	        		}
	        	}        		
        	}
        	
        }
        return list;
    }
    public static void fillList(List<Character> list,String p) {
    	list.clear();
    	for (int i = 0; i < p.length(); i++) {
			list.add(p.charAt(i));
		}
    }
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abe";
		//List<Integer> list1 = findAnagrams1(s, p);
		List<Integer> list2 = findAnagrams2(s, p);
		list2.forEach(System.out::println);
		
	}
}
