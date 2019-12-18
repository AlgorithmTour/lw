package algorithm;
/**
 * @Date 12/18
 * @author xiaoqi
 * @题目:给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
		这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
	输入: pattern = "abba", str = "dog cat cat dog"
           输出: true
    @思路：使用HashMap来存储某种对应关系
 
 */
import java.util.HashMap;
import java.util.Map;

public class Test290 {
	
	public static  boolean wordPattern(String pattern, String str) {
		String[] s = str.split(" ");// 分割为数组
		char [] ch = pattern.toCharArray();// 变为字符数组
		Map<Character,String > map = new HashMap<>();// 建立map
		if(s.length != ch.length) {
			return false;
			
		}
		for(int i = 0;i<s.length;i++) {
			if(!map.containsKey(ch[i])) { // 如果不含这个键，就添加这个键，并且添加相应的s中的键值
				if(map.containsValue(s[i])) { // 如果不包含这个键，但是前面的键又占用了本次的s[i]值，则也返回false
					return false; 
				}
				map.put(ch[i], s[i]);
			}else {// 如果包含
				if(!map.get(ch[i]).equals(s[i])) {// 如果与前面的成ch[i]值不相等就返回false
					return false;
				}
			}
		}
			
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog car cjr dog";
		System.out.print(wordPattern(pattern, str));
	}

}
