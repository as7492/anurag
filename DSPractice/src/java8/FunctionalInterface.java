package java8;

public class FunctionalInterface {

	public static void main(String[] args) {
		Calculate cal = (int x, int y) -> {
			return x + y;
		};
		System.out.println(cal.add(2, 3));
		System.out.println(cal.multiply(2, 3));
	}

}
