package threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenCondition {
	
	private Lock lock = new ReentrantLock();
	private Condition oddPrinter = lock.newCondition();
	private Condition evenPrinter = lock.newCondition();
	boolean isEvenPrinted = true;
	
	public void printEven() throws InterruptedException {
		for(int i=2; i<=100; i+=2) {
			lock.lock();
			while(isEvenPrinted) {
				evenPrinter.await();
			}
			System.out.println(i);
			isEvenPrinted = true;
			oddPrinter.signal();
			lock.unlock();
		}
	}
	
	public void printOdd() throws InterruptedException {
		for(int i=1; i<=100; i+=2) {
			lock.lock();
			while(!isEvenPrinted) {
				oddPrinter.await();
			}
			System.out.println(i);
			isEvenPrinted = false;
			evenPrinter.signal();
			lock.unlock();
		}
	}
	
	public static void main(String args[]) {
		PrintOddEvenCondition printOddEven = new PrintOddEvenCondition();
		
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
