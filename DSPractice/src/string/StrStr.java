package string;

public class StrStr {
	
	public static int strStr(String haystack, String needle) {
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        if(arr2.length == 0){
            return 0;
        }
        
        int j=0;
        int previ=0;
        
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] == arr2[j]){
                if(j == arr2.length-1){
                    return i-arr2.length+1;
                }
                if(j==0){
                    previ = i;
                }
                j++;
            }else{
            	if(j > 0) {
            		i = previ;
            	}
                j=0;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		System.out.println(strStr("mississippi","issip"));
	}

}
