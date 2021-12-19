public class Solution {
	public int hammingDistance(int x, int y) {
        int val = x^y,count = 0;
        
        while(val != 0){            
            if(val % 2 == 1) 
                count++;            
            val /=2;
        }
        return count;
    }
}
