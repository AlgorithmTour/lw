package cn.andios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author LSD
 *
 * @datetime 2019��11��27������9:09:46
 *
 */
public class Test242 {

	/**
	 * ����
	 * @param s
	 * @param t
	 * @return
	 */
	private static boolean isAnagram2(String s, String t) {
		if(s== null || t == null || s.length() != t.length()) {
    		return false;
    	}
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		int[] arr = new int[26];
		for (int i = 0; i < tArr.length; i++) {
			arr[sArr[i]-'a']++;
			arr[tArr[i]-'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if(arr[i]!=0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * hashmap
	 */
    public static boolean isAnagram1(String s, String t) {
    	if(s== null || t == null || s.length() != t.length()) {
    		return false;
    	}
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < s.length(); i++) {
    		//s���ַ��Ž�ȥ
			map.put((int) s.charAt(i),map.getOrDefault((int)s.charAt(i), 0)+1);
			//��ȥt���ַ�
        	map.put((int)t.charAt(i), map.getOrDefault((int)t.charAt(i),0)-1);			
		}						
    	//���tû��s����ͷ���false
		for (int i = 0; i < s.length(); i++) {
			if(map.get((int)s.charAt(i))!=0) {
				return false;
			}		
		}	
		return true;
    }
	public static void main(String[] args) {
		//boolean isAnagram1 = isAnagram1("anagram", "nagaram");
		boolean isAnagram2 = isAnagram2("anagram", "nagaram");
		//System.out.println(isAnagram1);
		System.out.println(isAnagram2);
	}

}
