package string;

public class FindString {

	public static void main(String[] args) {
		String string = "nanana";
		String find = "nana";
		char[] findArr = find.toCharArray();
		
		int findIndex = 0;
		int count = 0;
		for(char c : string.toCharArray()) {
			if(c == findArr[findIndex]) {
				findIndex++;
			}else {
				findIndex = 0;
			}
			if(findIndex == findArr.length) {
				count++;
				findIndex = 0;
			}
		}
		
		System.out.println(count);
	}

}
