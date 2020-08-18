package threading;

public class PrintOddEven {
	
	boolean isEvenPrinted = true;
	
	public synchronized void printEven() throws InterruptedException {
		for(int i=2; i<=100; i+=2) {
			if(isEvenPrinted) {
				wait();
			}
			System.out.println(i);
			isEvenPrinted = true;
			notify();
		}
	}
	
	public synchronized void printOdd() throws InterruptedException {
		for(int i=1; i<=100; i+=2) {
			if(!isEvenPrinted) {
				wait();
			}
			System.out.println(i);
			isEvenPrinted = false;
			notify();
		}
	}
	
	public static void main(String args[]) {
		PrintOddEven printOddEven = new PrintOddEven();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					printOddEven.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					printOddEven.printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
		
	}

}
