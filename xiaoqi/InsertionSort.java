package algorithm;
/**
 * @date 11.20
 * @author xiaoqi
 * @��������
 * ˼�룺�ӵڶ���Ԫ�ؿ�ʼ���ҵ�����ȷ��λ�ã�ֻҪǰ���Ԫ�ش����Լ���ǰ���Ԫ�ؾ������һλ��
 */
public class InsertionSort {
	public static int[] insertionSort(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			 int current = arr[i]; // ע�Ᵽ��Ҫ�����Ԫ�أ��������� arr[preIndex+1] = arr[preIndex]�Ḳ�Ǹ�ֵ
			 int preIndex = i -1;// ��ǰԪ�ص�ǰһ��Ԫ�ص�ָ��
			 // ֻҪ��ǰ��Ԫ��С��ǰ���Ԫ�أ��ͽ�ǰ���Ԫ�غ���һλ������preIndexָ��--,
			 while(preIndex >= 0 && arr[preIndex] >  current) {
				 arr[preIndex+1] = arr[preIndex]; 
				 preIndex--;
			 }
			 arr[preIndex + 1] = current;
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,4,2,4,6,7,2};
		int[] newArr = insertionSort(arr);
		for(int i = 0;i<newArr.length;i++) {
			System.out.print(newArr[i] + " ");
		}
		

	}

}
