package algorithm;
/**
 * @data 11.19
 * @author xiaoqi
 * @��Ŀ:
 *	����һ�����ǵݼ�˳��������������� A������ÿ�����ֵ�ƽ����ɵ������飬Ҫ��Ҳ���ǵݼ�˳������
 */
public class Test977 {
	 /*
	  * ͬ���ǲ��ù鲢�����˼·���������Ϊ�����������������֡��������ֵ��űȣ�������������ȡ�
	  */
	    public static int[] sortedSquares(int[] A) {
	    	// ˫ָ�� iָ������jָ������,k�Ǳ��������ռ��ָ��
	    	 int i,j = 0,k=0;
	    	 // ����һ�������ռ䣬������A�ĳ���һ��
	    	 int[] newA = new int[A.length];
	    	 // �ҳ������븺���ķֽ���  ���뱣֤j<A.length
	    	 while(j<A.length && A[j]<0) {
	    		 j++;
	    	 }
	        
	    	 i = j-1;
	    	 // ��Ϊ�������ֵ�ƽ���ǽ���ģ����Ը������ֵ������Ƚ� 
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
