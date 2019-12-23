package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 12/23
 * @author xiaoqi
 * @题目： 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
	示例 1:
	输入:
	"tree"
	输出:
	"eert"
	解释:
	'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 */
public class Test451 {
	 public static String frequencySort(String s) {
		 char[] sh = s.toCharArray();
		 // 使用int数组来保存字符出现的频率
		 int[] freq = new int[256];
	     for (int i = 0;i < sh.length;i++) {
	            freq[sh[i]]++;
	        }
	    
		 Map<Integer, String> map = new HashMap<>();
		 for(int i = 0; i< freq.length;i++) {
			 if(freq[i]!=0) {
				 // 把索引转为字符
				 char ch = (char) i;
				 String str = map.get(freq[i]);
				 // 将频率出现相同的字符拼接在一起，在放入
				 if(str != null) {
					 String strNew = str.concat(build(ch, freq[i]));
					 map.put(freq[i], strNew);
				 }else {
					 map.put(freq[i], build(ch, freq[i]));
				 }
			 }
		 }
		 // 将map的key排序 
		 Integer[] keys = map.keySet().toArray(new Integer[] {});
		 Arrays.sort(keys);
		 StringBuffer sb1 = new StringBuffer();
		 // 倒序输出
		 for(int i = keys.length -1; i>=0;i-- ) {
			 sb1.append(map.get(keys[i]));
		 }
		 
		  
		return sb1.toString();
	        
	    }
	 // 得到一个字符串： 此字符串由同一个字符组成，出现几次，就有几个相同的字符
	 private static String build(char ch, int times) {
		 String string = Character.toString(ch);
		 StringBuffer res = new StringBuffer(string);
		 int t = 1;
		 while(t < times) {
			 res.append(string);
			 t++;
		 }
		 return res.toString();
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tree";
		System.out.print(frequencySort(s));
	}

}
