package algorithm;
/**
 * @date 11.17
 * @author xiaoqi
 * ���ֲ���
 */
public class BinarySearch {
	public static int binarySeach(int arr[],  int target) {
		int left = 0, right = arr.length - 1;
		int mid =   left + (right - left)/2;
		// ֻҪ����Ԫ�ؾ�Ҫѭ��
		while(left <= right) {
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				left = mid + 1;
			}else {
				right = mid-1;
			}
		}
		// ���û�з���-1
		 return  -1;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array []  = {1,2,3,4,6,8,9,10};
		int n = binarySeach(array,4);
		System.out.print(n);
	}

}
