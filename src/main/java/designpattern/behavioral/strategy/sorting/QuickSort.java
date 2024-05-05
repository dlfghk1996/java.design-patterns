package designpattern.behavioral.strategy.sorting;

// 구체적인 정렬: 퀵정렬
public class QuickSort<T extends Comparable<T>> implements SortStrategy<T> {

    private static final QuickSort instance = new QuickSort();

    private QuickSort() {
        // private 생성자로 싱글톤 패턴 적용
    }

    public static QuickSort getInstance() {
        return instance;
    }

    @Override
    public void sort(T[] array) {
        // 퀵 정렬 구현
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}