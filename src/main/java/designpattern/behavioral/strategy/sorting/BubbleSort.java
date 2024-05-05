package designpattern.behavioral.strategy.sorting;

// 구체적인 전략 : 버블 정렬
public class BubbleSort<T extends Comparable<T>> implements SortStrategy<T> {
    private static final BubbleSort instance = new BubbleSort();

    private BubbleSort() {
        // private 생성자로 싱글톤 패턴 적용 =>  생성자를 통한 인스턴스 생성을 막는다.
    }

    // 인스턴스 접근 메서드
    public static BubbleSort getInstance() {
        return instance;
    }

    @Override
    public void sort(T[] array) {
        // 버블 정렬 구현
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
