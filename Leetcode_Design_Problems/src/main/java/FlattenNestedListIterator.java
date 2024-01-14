import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

    public static void main(String[] args) {

    }
}

class NestedIterator implements Iterator<Integer> {

    List<Integer> list = new ArrayList<>();
    int index=0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattenTheList(nestedList);
    }

    void flattenTheList(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if(ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                flattenTheList(ni.getList());
            }
        }

    }

    @Override
    public Integer next() {
        if (index > list.size()) {
            return -1;
        }
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index< list.size();
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


class CustomInteger implements NestedInteger  {

    Integer value;
    List<NestedInteger> list;

    CustomInteger(Integer value) {
        this.value = value;
        this.list = new ArrayList<>();
    }

    @Override
    public boolean isInteger() {
        return value!=null;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
