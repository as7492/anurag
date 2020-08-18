package string;

public class CountAndSay {

	public static void main(String[] args) {
		String str = "1211";
		int count = 1;
        String result = "";
        char[] arr = str.toCharArray();
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1]){
                count++;
            }else{
                result = result+count+arr[i-1];
                count = 1;
            }
        }
        result = result+count+arr[arr.length-1];
        System.out.println(result);
	}
}
