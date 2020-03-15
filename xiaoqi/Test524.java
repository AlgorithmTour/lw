package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @date : 3/15
 * @author xiaoqi
 * @题目：给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 *      如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

		示例 1:
		输入:
		s = "abpcplea", d = ["ale","apple","monkey","plea"]
		输出: 
		"apple"

		示例 2:
		输入:
		s = "abpcplea", d = ["a","b","c"]
		输出: 
		"a"
 */
public class Test524 {
	public static String findLongestWord(String s, List<String> d) {
		Map<Integer,String> map = new HashMap<>();
		for(int i = 0;i<d.size();i++) {
			String temp = d.get(i);
			int left = 0;
//			int right = temp.length()-1;
			int sleft = 0;
//			int sright = s.length()-1;
			// 双指针方式 遍历是否满足
			while(left<= temp.length() -1 && sleft<=s.length()-1) {
				if(s.charAt(sleft) == temp.charAt(left)) {
					sleft++;
					left++;
				}else {
					sleft++;
				}
			}
//			while(left <=right &&  sleft<=sright) {	 
//				if(s.charAt(sleft) == temp.charAt(left)) {
//						sleft++;
//						left++;
//				}else {
//					sleft++;
//				}
//				if(s.charAt(sright) == temp.charAt(right)) {
//					sright--;
//					right--;
//			   }else {
//				   sright--;
//			   }
//			}
			// 如果是temp字符串走完，temp符合条件
			if(left == temp.length()) {
				// 如果包含相同长度的字符 ,比较字典顺序	
				if(map.containsKey(temp.length())) {
					String s1 = map.get(temp.length());
					if(s1.compareTo(temp)>0) {
						map.put(temp.length(), temp);
					}
					 
				}else {
					map.put(temp.length(), temp);
				}
				 
			}
		}
		// 如果map中没有元素，则没有满足条件的字符串，返回""
		if(map.isEmpty()) {
			return "";
		}
		
		 // 根据map的key排序
		 Integer[] keys = map.keySet().toArray(new Integer[] {});
		 Arrays.sort(keys);
		 // 返回最后一个元素
		 return map.get(keys[keys.length-1]);
	}
 
	    public static String   findLongestWord2(String s, List<String> d) {
	        String str="";// 记录最长的子序列 并且 该子序列的字典序列最小
	        for(int k = 0;k<d.size();k++) {
	        	String sstr = d.get(k);
	            for(int i=0,j=0;i<s.length()&&j<sstr.length();i++){
	                if(s.charAt(i)==sstr.charAt(j)) j++;
	                // 如果j等以sstr的长度，表示sstr满足要求1（是给定字符串的子序列）
	                if(j==sstr.length()){
	                	// 如果sster的长度比前一个子序列的长度长      直接替换  ； 如果sster的长度与前一个子序列的长度相等  ， 比较它们的字典序列，返回字典序列小的
	                    if(sstr.length()>str.length()||(sstr.length()==str.length()&&str.compareTo(sstr)>0)) 
	                     str=sstr;
	                }
	            }
	        }
	        return str;
	        
	    }
 
	    public static String findLongestWord3(String s, List<String> d) {
	        String longestWord = "";
	        for (String target : d) {
	            int l1 = longestWord.length(), l2 = target.length();
	            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
	                continue;
	            }
	            if (isSubstr(s, target)) {
	                longestWord = target;
	            }
	        }
	        return longestWord;
	    }

	    private static boolean isSubstr(String s, String target) {
	        int i = 0, j = 0;
	        while (i < s.length() && j < target.length()) {
	            if (s.charAt(i) == target.charAt(j)) {
	                j++;
	            }
	            i++;
	        }
	        return j == target.length();
	    }

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bab";
		List<String> d = new ArrayList<String>() {{
//			s = "abpcplea", d = ["ale","apple","monkey","plea"]
//			"bab"
//			["ba","ab","a","b"]
			add("ba");
			add("ab");
			add("a");
			add("b");
		}};
		
		System.out.print(findLongestWord3(s,d));
	}
	
}
