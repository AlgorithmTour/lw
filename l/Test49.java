package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
    	
      	Map<String,List> map = new HashMap<>();
      	
      	for (String str: strs) {
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String string = String.valueOf(charArray);
			if(!map.containsKey(string)) {
				map.put(string, new ArrayList());
			}
			map.get(string).add(str);
      	}
      	return  new ArrayList(map.values());
    }

      	
	public static void main(String[] args) {
		List<List<String>> groupAnagrams = groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		for (List<String> list : groupAnagrams) {
			for (String str : list) {
				System.out.println(str);
			}
		}
	}
}
