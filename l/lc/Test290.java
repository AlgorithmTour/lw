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
        	//���map����ch���key,��ô��ǰstrSplit�е��ַ����������Ӧ��value���
        	if(map.containsKey(ch)) {
        		if(!map.get(ch).equals(strSplit[i])) {
        			return false;
        		}
        	}else {
            	//���map�������value,��ô��ǰch�����Ѿ�������map����Ϊkey,��ִ�е����������else���
        		//˵��map�в�����ch���key������ֱ�ӷ���false
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
