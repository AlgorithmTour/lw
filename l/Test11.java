package cn.andios;

/**
 * 167 125 344 345 11
 * @author LSD
 *
 * @datetime 2019年11月16日下午8:50:00
 *
 */
public class Test11 {

    public static int maxArea(int[] height) {
    	int i = 0,j = height.length-1;
    	int maxArea = 0;
    	while(i < j) {
    		if(height[i]>height[j]) {
    			maxArea = Math.max(maxArea, (j-i)*height[j]);
    			j --;
    		}else {
    			maxArea = Math.max(maxArea, (j-i)*height[i]);
    			i ++;
    		}
    	}
        return maxArea;
    }
	public static void main(String[] args) {
		int [] height = {1,8,6,2,5,4,8,3,7};
		int area = maxArea(height);
		System.out.println(area);
	}
}
