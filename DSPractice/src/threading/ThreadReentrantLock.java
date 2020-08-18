package threading;

public class ThreadReentrantLock {
	
	Thread lockedBy = null;
	boolean isLocked = false;
	int count = 0;
	
	public synchronized void lock() throws InterruptedException {
		if(isLocked && lockedBy != Thread.currentThread()) {
			wait();
		}
		isLocked = true;
		count++;
	}
	
	public synchronized void unlock() {
		if(lockedBy == Thread.currentThread()) {
			count--;
			if(count==0) {
				isLocked = false;
				notify();
			}
		}
	}
}
