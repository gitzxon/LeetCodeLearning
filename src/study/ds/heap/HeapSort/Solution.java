package study.ds.heap.HeapSort;

public class Solution {
    public int[] heapSort(int[] array) {

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            heapify(array, array.length - 1 - i, 0);
        }
        return array;
    }

    public void heapify(int[] array, int length, int start) {
        int largest = start;
        int left = start * 2 + 1;
        int right = start * 2 + 2;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != start) {
            swap(array, start, largest);

            heapify(array, length, largest);
        }
    }

    public void swap(int[] array, int a, int b) {
        int swap = array[a];
        array[a] = array[b];
        array[b] = swap;
    }
}
