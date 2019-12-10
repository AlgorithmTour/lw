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
 * @datetime 2019��12��10������11:48:30
 *
 */
public class Test447 {

    public static int numberOfBoomerangs(int[][] points) {
    	int res=0;
        Map<Integer,Integer> map = new HashMap<>();
    	//	����points
    	for (int i = 0; i < points.length; i++) {   		
    		//	��һ��map����Ϊi�㵽������ľ��룬ֵΪ���������ֵĴ���
        	map.clear();
        	
			for (int j = 0; j < points.length; j++) {
				if(j != i)
					map.put(dis(points[i],points[j]),map.getOrDefault(dis(points[i],points[j]), 0)+1);
			}	
			
			//	����map��ȡ����value
	    	//	����key=2��value=3����ʾ��i����Ϊ2�ĵ���3������ôk��3��ȡֵ�����j��2��ȡֵ���
	    	//	����key=5��value=7����ʾ��i����Ϊ5�ĵ���7������ôk��7��ȡֵ�����j��6��ȡֵ���
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

