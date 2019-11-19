package algorithm;
/**
 * @data 11.19
 * @author xiaoqi
 * @题目:
 *	给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class Test977 {
	 /*
	  * 同样是采用归并排序的思路，将数组分为负数部分与正数部分。负数部分倒着比，正数部分正这比。
	  */
	    public static int[] sortedSquares(int[] A) {
	    	// 双指针 i指向负数，j指向正数,k是遍历辅助空间的指针
	    	 int i,j = 0,k=0;
	    	 // 定义一个辅助空间，长度与A的长度一样
	    	 int[] newA = new int[A.length];
	    	 // 找出正数与负数的分界线  必须保证j<A.length
	    	 while(j<A.length && A[j]<0) {
	    		 j++;
	    	 }
	        
	    	 i = j-1;
	    	 // 因为负数部分的平方是降序的，所以负数部分倒过来比较 
	        while(i>=0 && j<A.length) {
	        	 if(A[i]*A[i] < A[j]*A[j]) {
	        		 newA[k++] = A[i]*A[i--]; 
	        	 }else {
	        		 newA[k++] = A[j]*A[j++];
	        	 }
	        }
	        while(i>=0) {
	        	newA[k++] = A[i]*A[i--];
	        }
	        while(j<A.length) {
	        	newA[k++] = A[j]*A[j++];
	        }
	        return newA;
        }
	       
	        
	    
	   
	public static void main(String[] args) {
			int[] arr = {-7,-4,-1,4,5,6};
			int[] newarr = sortedSquares(arr);
			 for(int m = 0;m<newarr.length; m++) {
		        	 System.out.print(newarr[m]+ " ");
		        }
	}

}
