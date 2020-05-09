package study.list.single.FlatternNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 想在 hasNext 和 next 的时候动态判断。但是出了好多错。
 * 最大的问题就是，当 list 为 empty 的时候，可能导致 hashNext return true 但是 next 只能返回 null。
 * 看来还是 new 的时候直接把 list 构造完比较简单，少出错。
 *
 */
public class NestedIteratorFail implements Iterator<Integer> {

    Stack<List<NestedInteger>> headStack;
    Stack<Integer> indexStack;

    public NestedIteratorFail(List<NestedInteger> nestedList) {
        headStack = new Stack<>();
        indexStack = new Stack<>();

        if (validList(nestedList)) {
            headStack.push(nestedList);
            indexStack.push(0);
        }

    }

    @Override
    public Integer next() {
        List<NestedInteger> head = headStack.peek();
        int curIndex = indexStack.pop();
        NestedInteger nestedInteger = head.get(curIndex);
        if (nestedInteger.isInteger()) {
            indexStack.push(curIndex + 1);
            return nestedInteger.getInteger();
        } else {
            if (validList(nestedInteger.getList())) {
                headStack.push(nestedInteger.getList());
                indexStack.push(curIndex + 1);
                indexStack.push(0);
                return next();
            } else {

                if (curIndex + 1 < head.size()) {
                    indexStack.push(curIndex + 1);
                } else {
                    headStack.pop();
                }
                return next();
            }
        }
    }

    @Override
    public boolean hasNext() {

        if (headStack == null || headStack.size() == 0 || indexStack == null || indexStack.size() == 0) {
            return false;
        }

        List<NestedInteger> head = headStack.peek();
        int curIndex = indexStack.peek();
        if (head != null && curIndex >= 0 && curIndex < head.size()) {
            return head.get(curIndex).isInteger() || head.get(curIndex).getList().size() != 0;
        } else {
            headStack.pop();
            indexStack.pop();
            return hasNext();
        }
    }

    private boolean validList(List<NestedInteger> head) {
        if (head == null) {
            return false;
        }

        if (head.size() == 0) {
            return false;
        } else {
            if (head.get(0).isInteger()) {
                return true;
            } else {
                return validList(head.get(0).getList());
            }
        }
    }
}