package algorithm;
 /**
  * @data 11.18
  * @author xiaoqi
  * ����һ��û����������������ʹ�ù鲢�㷨
  */
public class Guibing {
	public static int[] sort(int[] arr,int l, int h) {
        if(l == h) {
            return new int[] {arr[l]};
        }
        int i = 0,n=0,m=0;
        int mid = l + (h-l)/2;
        // �ݹ���� ���������������Ϊ��������
        int[] left = sort(arr,l,mid);
        int[] right = sort(arr,mid+1,h);
        int[] newnum = new int[left.length + right.length];
        while(n<left.length && m<right.length) {
            newnum[i++] = left[n] < right[m]?left[n++]:right[m++];
        } 
        while(n<left.length){
            newnum[i++] = left[n++];
        }
        while(m<right.length){
            newnum[i++] = right[m++];
        }
        return newnum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {4,6,2,3,7};
		 int[] newnum = sort(arr, 0,arr.length-1); 
		 for(int i = 0;i<newnum.length;i++) {
			 System.out.print(newnum[i]+ " ");
		 }
	}

}
