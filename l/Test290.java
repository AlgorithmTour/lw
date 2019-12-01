package cn.andios;

import java.util.HashMap;
import java.util.Map;

public class Test290 {

	/**
	 * 
	 */
    public static boolean wordPattern(String pattern, String str) {
        char[] pArr = pattern.toCharArray();  
        String[] strSplit = str.split(" ");
        if(pArr.length != strSplit.length) {
        	return false;
        }
        char ch ;
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < strSplit.length; i++) {
        	ch = pArr[i];
        	//如果map中有ch这个key,那么当前strSplit中的字符串必须与对应的value相等
        	if(map.containsKey(ch)) {
        		if(!map.get(ch).equals(strSplit[i])) {
        			return false;
        		}
        	}else {
            	//如果map中有这个value,那么当前ch必须已经存在于map中作为key,但执行到这里，进入了else块后
        		//说明map中不包含ch这个key，所以直接返回false
        		if(map.containsValue(strSplit[i])) {
        			return false;
        		}
        		map.put(ch, strSplit[i]);
        	}
			
		}        
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}
}
