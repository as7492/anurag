package threading;

public class ThreadLock {
	
	boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException {
		if(isLocked) {
			wait();
		}
		isLocked = true;
	}
	
	public synchronized void unlock() {
		isLocked = false;
		notify();
	}

}
