package cn.andios;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月3日上午10:47:02
 *
 */
public class Test205 {

    public static boolean isIsomorphic(String s, String t) {
    	char[] sArr = s.toCharArray();
    	char[] tArr = t.toCharArray();
    	Map<Integer,Integer> map = new HashMap();
    	
    	for (int i = 0; i < tArr.length; i++) {
    		if(map.containsKey((int)sArr[i])) {
    			if(map.get((int)sArr[i])!=(int)tArr[i]) {
    				return false;
    			}
    		}else{
				if(map.containsValue((int)tArr[i])) {   			
					return false;
				}else {
					map.put((int)sArr[i], (int)tArr[i]);
				}
    		}   		
		}
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isIsomorphic("paper", "title"));
	}
}
