package algorithm;
/**
 * @date 11.20
 * @author xiaoqi
 * @快排
 * 思想：第一轮，选定一个基数，根据这个基数将小于基数的元素放在左边，大于基数的元素放在右侧。
 *  数组分为两部分之后，递归排序左右两部分，原理与第一轮一样。
 */
public class QuikSort {
	public static int[] quickSort(int[] arr,int left, int right) {
		 if(left < right) {
			 int partitionIndex = partition(arr, left, right); 
			 quickSort(arr, left, partitionIndex -1);// 递归排序左边部分
			 quickSort(arr, partitionIndex + 1,right);// 递归排序右边部分
		 }
		
		return arr;
	}
	// 将数组分为小于基数和大于基数两部分
	public static int partition(int[] arr, int left,int  right) {
		int pivot = left; // 设定初始基准值(中心点)
		int index = pivot + 1;// 记录小于基数部分的分界线
		for(int  i = index;i <= right;i++) { 
			if(arr[i] < arr[pivot]) { // 只要小于基数的元素就交换与arr[index]的位置
				 swap(arr,i,index);
				 index++;// 每交换一次 index++;
			}
		}
		swap(arr,pivot,index-1);// 交换基数与分界线的位置，使得前一部分都是小于基数的元素，后面部分都是大于基数的元素
		return index -1;// 返回基数指针位置
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
