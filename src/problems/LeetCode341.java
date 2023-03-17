package problems;

import java.util.Iterator;
import java.util.List;

public class LeetCode341 {
}

class NestedIterator implements Iterator<Integer> {

    public NestedIterator(List<NestedInteger> nestedList) {

    }

    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
