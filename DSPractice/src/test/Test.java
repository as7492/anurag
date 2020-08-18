package test;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.longestCommonPrefix(new String[] {"flower","flow","flight"}));
		
		
	}
	

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length-1);
    }
    
    public String longestCommonPrefix(String[] strs, int start, int end) {
        if(start == end){
            return strs[start];
        }else{
            int mid = (start+end)/2;
            String left = longestCommonPrefix(strs, start, mid);
            String right = longestCommonPrefix(strs, mid+1, end);
            return getLCP(left,right);
        }
        
    }

    public String getLCP(String left, String right){
    	 int min = Math.min(left.length(), right.length());       
    	    for (int i = 0; i < min; i++) {
    	        if ( left.charAt(i) != right.charAt(i) )
    	            return left.substring(0, i);
    	    }
    	    return left.substring(0, min);
    }

}
