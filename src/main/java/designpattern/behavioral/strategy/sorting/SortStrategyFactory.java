package designpattern.behavioral.strategy.sorting;

// 정렬 전략 팩토리
// 정렬 전략 인스턴스를 생성하고 반환한다
public class SortStrategyFactory {
    public static <T extends Comparable<T>> SortStrategy<T> getSortStrategy(String type) {
        if ("bubble".equalsIgnoreCase(type)) {
            return (SortStrategy<T>) BubbleSort.getInstance();
        } else if ("quick".equalsIgnoreCase(type)) {
            return (SortStrategy<T>) QuickSort.getInstance();
        }
        throw new IllegalArgumentException("Unsupported sort strategy: " + type);
    }
}
