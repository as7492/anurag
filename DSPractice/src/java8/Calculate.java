package java8;

public interface Calculate {
	public int add(int x, int y);
	
	//default method
	default int multiply(int x, int y) {
		return x*y;
	}
}
