package threading;

public class PrintAaBb {
	
	boolean isEvenPrinted = false;
	
	public synchronized void printEven() throws InterruptedException {
		for(int i=65; i<=90; i++) {
			if(isEvenPrinted) {
				wait();
			}
			System.out.print((char)i);
			isEvenPrinted = true;
			notify();
		}
	}
	
	public synchronized void printOdd() throws InterruptedException {
		for(int i=97; i<=122; i++) {
			if(!isEvenPrinted) {
				wait();
			}
			System.out.print((char)i);
			isEvenPrinted = false;
			notify();
		}
	}
	
	public static void main(String args[]) {
		PrintAaBb printOddEven = new PrintAaBb();
		
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
