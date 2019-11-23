package algorithm;
/**
 * @date 11.23
 * @author xiaqi
 *@��Ŀ������һ���Ѱ����������� ���������飬�ҵ�������ʹ���������֮�͵���Ŀ������
 *
 */
public class Test167 {
	// �����ⷨ
	 public static int[] twoSum1(int[] numbers, int target) {
		 	int count = 0;
		 	int[] arr = new int[numbers.length]; 
		 	int index = 0;	        
	        for(int i = 0;i<numbers.length;i++) {
	        	for(int j = i+1; j<numbers.length;j++) {
	        		if(numbers[i] + numbers[j] == target) {
	        			arr[index++] = i + 1;
	        			arr[index] = j + 1;
	        			index ++;
	        			count += 2;
	        		}
	        	}
	        }
	        int[] newArr = new int[count];
	        for(int i = 0;i<count;i++) {
	        	newArr[i] = arr[i];
	        }
	        return newArr;
	    }
	 // ���ֲ���     
	 /*
	  * �̶���ֵ�����ö��ֲ����ҵ��ұ߲��ֵ�����һ������target-numbers[left]����λ��
	  */
	 public static  int binary(int[] numbers, int left, int right, int target){
	      	    while (left<=right){
	      	     int mid = left + (right - left) /2;
	            if(target == numbers[mid]) {
	                return mid;
	            }else if(target<numbers[mid]) {
	                right = mid -1;
	            }else{
	                left = mid +1;
	            }
	        }
	        return  -1;
	 }
	 // ָ����ײ
	 /*
	  * ��������ָ����ײ����Ϊ���������飬������ָ��Ԫ��֮��С��targetʱ��leftָ��++����ָ��Ԫ��֮�ʹ���targetʱ��rightָ��++����ָ��Ԫ��֮�͵���targetʱ�� ��������ָ��λ�á�
	  */
	 public static int[] crash(int[] nums,int left,int right ,int target) {
		 	 
		 	 while(left < right) {
		 		 if(nums[left] + nums[right] > target) {
		 			 right--;
		 		 }else if(nums[left] + nums[right] < target) {
		 			 left++;
		 		 }else { 
		 			  return new int[] {left+1,right+1} ;
		 		 }
		 	 }
		 	 throw new RuntimeException("û��������ֵ");
		 	 
		 	 
	 }
	 
	 

	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,2,3,5,4};
		int target = 6;
		
		// int[] newArr = twoSum1(arr,6);
		// int[] newArr = twoSum2(arr,6);
//		 int len = numbers.length;
//	        // ���һ���������Ϊ��ʼ������
//	        for (int left = 0; left < numbers.length - 1; left++) {
//	            // �������ֲ���
//	            int right = binary(numbers, left + 1, len - 1, target - numbers[left]);
//	            if (right != -1) {
//	            	 newArr[0] = left+ 1;
//	            	 newArr[1] = right +1;
//	            }
//	        }
		int[] newArr = crash(numbers,0,numbers.length -1,target);
	     
	        System.out.print(newArr[0]+" "+ newArr[1]);

	 
		 
	}

}
