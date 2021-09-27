package entity.write;

import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 9:38 2021/08/26
 * @Description:
 */
public class WriteQuickSort {
	public static void main(String[] args) {
		int[] ints = new int[]{72,6,57,88,60,42,83,73,48,85};
		quick_sort(ints,0,ints.length-1);
		System.out.println("ints:"+ Arrays.toString(ints));
	}
	public static void  quick_sort(int[] src,int l,int r){
		if (l<r) {
			int i = l,j = r,x = src[l];
            while(i<j){
            	while (i<j&&src[j]>x)
            		j--;
	            if (i < j) {
		            src[i++] = src[j];
	            }
	            while (i<j&&src[i]<=x)
	            	i++;
	            if (i < j) {
		            src[j--] = src[i];
	            }
            }
            src[i] = x;
			quick_sort(src,l,i-1);
			quick_sort(src,i+1,r);

		}
	}
}
