package array;

import java.util.Arrays;

public class MergeSortedArray {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        while(m>0 && n>0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[index] = nums1[m-1];
                m--;
            }else{
                nums1[index] = nums2[n-1];
                n--;
            }
            index--;
        }
        while(m>0){
            nums1[index] = nums1[m-1];
            m--;
            index--;
        }
        while(n>0){
            nums1[index] = nums2[n-1];
            n--;
            index--;
        }
    }

	public static void main(String[] args) {
		int[] nums1 = {4,5,6,0,0,0};
		int[] nums2 = {1,2,3};
		merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
