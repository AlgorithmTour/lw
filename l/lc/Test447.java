package cn.andios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author LSD
 *
 * @datetime 2019年12月10日上午11:48:30
 *
 */
public class Test447 {

    public static int numberOfBoomerangs(int[][] points) {
    	int res=0;
        Map<Integer,Integer> map = new HashMap<>();
    	//	遍历points
    	for (int i = 0; i < points.length; i++) {   		
    		//	用一个map，键为i点到其他点的距离，值为这个距离出现的次数
        	map.clear();
        	
			for (int j = 0; j < points.length; j++) {
				if(j != i)
					map.put(dis(points[i],points[j]),map.getOrDefault(dis(points[i],points[j]), 0)+1);
			}	
			
			//	遍历map，取它的value
	    	//	比如key=2，value=3即表示离i距离为2的点有3个，那么k有3种取值情况，j有2种取值情况
	    	//	比如key=5，value=7即表示离i距离为5的点有7个，那么k有7种取值情况，j有6种取值情况
	    	Set<Entry<Integer, Integer>> entrySet = map.entrySet();
	    	Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
	    	while (iterator.hasNext()) {
				Entry<Integer, Integer> next = iterator.next();			
				res += next.getValue()*(next.getValue()-1);					
			}
		} 	
    	
    	return res;
    }
    
    public static Integer dis(int[] point1, int[] point2) {
    	return (int) (Math.pow(point1[0]-point2[0], 2) + Math.pow(point1[1]-point2[1], 2));
	}
 
	public static void main(String[] args) {
		//int numberOfBoomerangs = numberOfBoomerangs(new int [][] {{0,0},{1,0},{2,0}});
		int numberOfBoomerangs = numberOfBoomerangs(new int [][] {{0,0},{1,0},{-1,0},{0,1},{0,-1}});
		System.out.println(numberOfBoomerangs);
	}
}

