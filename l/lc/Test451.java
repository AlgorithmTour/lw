package cn.andios;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月4日上午11:26:54
 *
 */
public class Test451 {
		
    /**
     * hashmap priorityQueue
     */
    public static String frequencySort1(String s) {

    	char[] sArr = s.toCharArray();
    	
    	Map<Character,Integer> map = new HashMap<>();
    	for (int i = 0; i < sArr.length; i++) {
			map.put(sArr[i], map.getOrDefault(sArr[i], 0)+1);
		}
  	
		PriorityQueue<Map.Entry<Character,Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {return b.getValue() -a.getValue();}) ;
        
		priorityQueue.addAll(map.entrySet());
        
        StringBuffer sb = new StringBuffer();
        while(!priorityQueue.isEmpty()) {
        	Map.Entry<Character, Integer> entry = priorityQueue.poll();
        	for (int i = 0; i < entry.getValue(); i++) {
        		sb.append(entry.getKey());
			}    	
        }
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(frequencySort1("tree"));
	}

}
