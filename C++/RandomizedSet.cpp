#include <iostream>
#include <vector>
#include <algorithm>

class RandomizedSet {
public:
    std::vector<int> set;
    RandomizedSet() {
        
    }
    
    bool insert(int val) {
        if(!count(set.begin(), set.end(), val)) {
           set.push_back(val);
           return true;
        }
        return false;
    }
    
    bool remove(int val) {
        if(count(set.begin(), set.end(), val)) {
           set.erase(std::remove(set.begin(), set.end(), val), set.end());
           return true;
        }
        return false;
    }

    int getRandom() {
        int index = rand() % set.size();
        return set[index];
    } 
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
