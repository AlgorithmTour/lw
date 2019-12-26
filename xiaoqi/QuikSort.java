package algorithm;
/**
 * @date 11.20
 * @author xiaoqi
 * @����
 * ˼�룺��һ�֣�ѡ��һ���������������������С�ڻ�����Ԫ�ط�����ߣ����ڻ�����Ԫ�ط����Ҳࡣ
 *  �����Ϊ������֮�󣬵ݹ��������������֣�ԭ�����һ��һ����
 */
public class QuikSort {
	public static int[] quickSort(int[] arr,int left, int right) {
		 if(left < right) {
			 int partitionIndex = partition(arr, left, right); 
			 quickSort(arr, left, partitionIndex -1);// �ݹ�������߲���
			 quickSort(arr, partitionIndex + 1,right);// �ݹ������ұ߲���
		 }
		
		return arr;
	}
	// �������ΪС�ڻ����ʹ��ڻ���������
	public static int partition(int[] arr, int left,int  right) {
		int pivot = left; // �趨��ʼ��׼ֵ(���ĵ�)
		int index = pivot + 1;// ��¼С�ڻ������ֵķֽ���
		for(int  i = index;i <= right;i++) { 
			if(arr[i] < arr[pivot]) { // ֻҪС�ڻ�����Ԫ�ؾͽ�����arr[index]��λ��
				 swap(arr,i,index);
				 index++;// ÿ����һ�� index++;
			}
		}
		swap(arr,pivot,index-1);// ����������ֽ��ߵ�λ�ã�ʹ��ǰһ���ֶ���С�ڻ�����Ԫ�أ����沿�ֶ��Ǵ��ڻ�����Ԫ��
		return index -1;// ���ػ���ָ��λ��
	}
	public static void swap(int[]arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
	}
	public static void main(String[] args) {
		 int[] arr = {5, 3, 4, 7,6,8};
		 int[] newArr = quickSort(arr,0,arr.length - 1);
		 for(int i = 0;i<newArr.length; i++) {
			 System.out.print(newArr[i] + " ");
		 }

	}

}
