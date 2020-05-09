package study.list.single.FlatternNestedListIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            addToQueue(nestedInteger);
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return queue.size() > 0;
    }

    private void addToQueue(NestedInteger nestedInteger) {
        if (nestedInteger == null) return;
        if (nestedInteger.isInteger()) {
            queue.add(nestedInteger.getInteger());
            return;
        }

        if (nestedInteger.getList() == null || nestedInteger.getList().size() == 0) {
            return;
        }

        List<NestedInteger> list = nestedInteger.getList();
        for (NestedInteger integer : list) {
            addToQueue(integer);
        }
    }
}