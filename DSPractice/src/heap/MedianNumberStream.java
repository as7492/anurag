package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianNumberStream {
	
	static PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
	static PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>();
	static double currMedian = 0;

	public static void main(String[] args) {
		int count = 1;
		while(count<11) {
			System.out.println(getCurrMedian(count));
			count++;
		}
			
	}
	
	public static double getCurrMedian(int num) {
		if(minQueue.size()==0 && maxQueue.size()==0) {
			minQueue.add(num);
			currMedian = num;
		}else {
			if(minQueue.size() > maxQueue.size()) {
				
				if(num < currMedian) {
					maxQueue.add(minQueue.poll());
					minQueue.add(num);
				}else {
					maxQueue.add(num);
				}
				currMedian=(double)(minQueue.peek()+maxQueue.peek())/2;
				
			}else if(maxQueue.size() > minQueue.size()) {
				
				if(num > currMedian) {
					minQueue.add(maxQueue.poll());
					maxQueue.add(num);
				}else {
					minQueue.add(num);
				}
				currMedian=(double)(minQueue.peek()+maxQueue.peek())/2;
			}else {
				if(num > currMedian) {
					maxQueue.add(num);
					currMedian = maxQueue.peek();
				}else {
					minQueue.add(num);
					currMedian = minQueue.peek();
				}
			}
		}
		return currMedian;
	}
	
	

}
