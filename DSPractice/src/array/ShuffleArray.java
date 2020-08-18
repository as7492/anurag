package array;

import java.util.Arrays;
import java.util.Random;

class ShuffleArray {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
    	System.out.println(i+"-"+j);
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
    
    public static void main(String args[]) {
    	int[] nums = {1,2,3,4,5,6,7,8,9};
    	ShuffleArray shuffleArray = new ShuffleArray(nums);
    	System.out.println(Arrays.toString(shuffleArray.shuffle()));
    	
    }
}
