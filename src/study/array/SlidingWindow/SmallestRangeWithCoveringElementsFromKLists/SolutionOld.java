package study.array.SlidingWindow.SmallestRangeWithCoveringElementsFromKLists;

import java.util.*;

/**
 * 超时了。看起来每次从候选list 里面取 getNext 的方式会引起超时。
 * 看看直觉的 合并到一个 list 里面会不会超时。
 */
class SolutionOld {
    public int[] smallestRange(List<List<Integer>> nums) {

        Map<Integer, Integer> mapNumToIndex = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                mapNumToIndex.put(
                        nums.get(i).get(j),
                        mapNumToIndex.getOrDefault(nums.get(i).get(j), 0) + 1
                );
            }
        }

        List<Integer> leftIndexList = new ArrayList<>(nums.size());
        List<Integer> rightIndexList = new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            leftIndexList.add(0);
            rightIndexList.add(0);
        }

        HashMap<Integer, List<Integer>> targetMapValueToRowList = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int value = nums.get(i).get(j);
                if (targetMapValueToRowList.containsKey(value)) {
                    targetMapValueToRowList.get(value).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    targetMapValueToRowList.put(value, list);
                }
            }
        }

        // value to row index
        HashMap<Integer, List<Integer>> curMapValueToRowList = new HashMap<>();
        // row index to count
        HashMap<Integer, Integer> progressMapRowToCount = new HashMap<>();

        Pointer right = getNext(nums, rightIndexList, 0);
        Pointer left = getNext(nums, leftIndexList, 0);

        int resultStart = 0;
        int resultEnd = 0;
        boolean resultGot = false;

        while (right.row != -1) {

            if (curMapValueToRowList.containsKey(right.value)) {
                curMapValueToRowList.get(right.value).add(right.row);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(right.row);
                curMapValueToRowList.put(right.value, list);
            }

            progressMapRowToCount.put(right.row, progressMapRowToCount.getOrDefault(right.row, 0) + 1);

            while (progressMapRowToCount.size() == nums.size() && left.row != -1 && left.sequence <= right.sequence)  {

                if (resultGot) {
                    if (right.value - left.value < resultEnd - resultStart) {
                        resultStart = left.value;
                        resultEnd = right.value;
                    }
                } else {
                    resultStart = left.value;
                    resultEnd = right.value;
                    resultGot = true;
                }


                List<Integer> rowList = curMapValueToRowList.get(left.value);
                Iterator<Integer> iterator = rowList.iterator();
                while (iterator.hasNext()) {
                    Integer rowIndex = iterator.next();
                    iterator.remove();

                    int count = progressMapRowToCount.getOrDefault(rowIndex, 1) - 1;
                    if (count == 0) {
                        progressMapRowToCount.remove(rowIndex);
                    } else {
                        progressMapRowToCount.put(rowIndex, count);
                    }
                }

                Pointer tmp = left;
                left = getNext(nums, leftIndexList, left.sequence + 1);
                recycle(tmp);
            }

            Pointer tmp = right;
            right = getNext(nums, rightIndexList, right.sequence + 1);
            recycle(tmp);
        }

        int[] result = new int[2];
        result[0] = resultStart;
        result[1] = resultEnd;
        return result;
    }

    final Pointer getNext(List<List<Integer>> nums, List<Integer> indexList, int sequence)  {
        int min = Integer.MAX_VALUE;
        int row = -1;
        int col = -1;
        for (int i = 0; i < indexList.size(); i++) {
            int tmpRow = i;
            int tmpCol = indexList.get(i);
            if (tmpCol == -1) {
                continue;
            }

            int value = nums.get(tmpRow).get(tmpCol);

            if (value < min) {
                row = tmpRow;
                col = tmpCol;
                min = value;
            }
        }


        if (row != -1) {
            if (col + 1 == nums.get(row).size()) {
                indexList.set(row, -1);
            } else {
                indexList.set(row, col + 1);
            }
        }

        return obtain(row, col, min, sequence);
    }

    private static final class Pointer {

        int row;
        int col;
        int value;
        int sequence;

        public Pointer(int row, int col, int value, int sequence) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.sequence = sequence;
        }

        @Override
        public String toString() {
            return "Pointer{" +
                    "row=" + row +
                    ", col=" + col +
                    ", value=" + value +
                    ", sequence=" + sequence +
                    '}';
        }

        Pointer update(int row, int col, int value, int sequence) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.sequence = sequence;
            return this;
        }
    }

    Pointer[] pointersPool = new Pointer[4];
    private void recycle(Pointer pointer) {
        for (int i = 0; i < pointersPool.length; i++) {
            if (pointersPool == null) {
                pointersPool[i] = pointer;
            }
        }
    }

    private Pointer obtain(int row, int col, int value, int sequence) {
        Pointer pointer = null;
        for (int i = 0; i < pointersPool.length; i++) {
            if (pointersPool[i] != null) {
                pointer = pointersPool[i];
                pointersPool[i] = null;
            }
        }

        if (pointer == null) {
            return new Pointer(row, col, value, sequence);
        } else {
            return pointer.update(row, col, value, sequence);
        }
    }
}
