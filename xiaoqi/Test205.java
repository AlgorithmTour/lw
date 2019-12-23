package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @data 12/21
 * @author xiaoqi
 * @题目： 给定两个字符串 s 和 t，判断它们是否是同构的。
                      如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
                       所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
	例：输入: s = "egg", t = "add"
	输出: true
 
 */

public class Test205 {
	// 思路：使用Hashmap
	public  static boolean isIsomorphic(String s, String t) {
		char[] sh = s.toCharArray();
		char[] th = t.toCharArray();
		Map<Character,Character> map = new HashMap<>();
		// 如果长度不一样 返回false
		if(sh.length != th.length) {
			return false;
		}
		for(int i = 0;i<sh.length;i++) {
			// 如果前面不含sh[i]这个键，但是包含th[i]这个键值，返回false;   即当sh = “ad”, th=“aa”时 不成立
			if(map.containsValue(th[i]) && (!map.containsKey(sh[i]))) {
				return false;
			}
			// 当前面包含sh[i]这个键，但是此时的th[i]与前面的值不一致，则返回false; 即sh="egg" th="ade"时 不成立
			if(map.containsKey(sh[i])) {
				if(map.get(sh[i]) != th[i]) {
					return false;
				}
			}
			map.put(sh[i], th[i]);
		}
		System.out.print(map);
		return true;
	        
	}
	// 方法二： 使用索引
	public  static boolean isIsomorphic2(String s, String t) {
		char[] sh = s.toCharArray();
		char[] th = t.toCharArray();
		// 如果长度不一样 返回false
		if(sh.length != th.length) {
			return false;
		}
		// 如果两个字符串中的每一个字符的索引都相等的话就是true，否则就是false
		for(int i = 0;i<sh.length;i++) {
			if(s.indexOf(sh[i]) != t.indexOf(th[i])) {
				return false;
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s = "a";
			String t = "a";
			System.out.print(isIsomorphic(s, t));
			
	}

}
