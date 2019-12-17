package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @data 12/17
 * @author xiaoqi
 * @��Ŀ�� ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * @˼·�� 
 */
public class Test242 {
	// ����һ��ʹ��hashMap
    public static boolean isAnagram(String s, String t) {
    	Map<Character, Integer> map1 = new HashMap<>();
    	char[] sh = s.toCharArray();
    	char[] th = t.toCharArray();
    	for(int  i = 0; i< sh.length;i++) {	 
    	   map1.put(sh[i],map1.getOrDefault(sh[i],  0) + 1 );	 
    	}
    	for(int i = 0;i<th.length;i++) {
    		// ����������ͷ���false
    		if(!map1.containsKey(th[i])) {
    			return false;
    		}
    		// �����ͽ�ֵ��һ
    	   map1.put(th[i],map1.get(th[i])- 1 );
    	   // ���ֵ��Ϊ0 �ͽ�������Ƴ�
    	   if(map1.get(th[i]) == 0) {
    		   map1.remove(th[i]);
    	   }
    	}
    	// ��� ���map1�иպ�Ϊ��˵������ͬ��
//    	if(map1.isEmpty()) {
//    		return true;
//    	}
//    	return false;
    	return map1.isEmpty();
        
    }
    // ��������ʹ������
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
