import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
	Set<Integer> set;
	public RandomizedSet() {
        set = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
        return set.add(val);
    }
    
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    public int getRandom() {
        int size = set.size(), item = new Random().nextInt(size), i = 0;
        for(int j : set) 
        	if(i++ == item)
        		return j;
        return -1;
    }
}

