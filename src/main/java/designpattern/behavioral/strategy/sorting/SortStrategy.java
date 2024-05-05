package designpattern.behavioral.strategy.sorting;

// 정렬 전략 인터페이스
public interface SortStrategy<T extends Comparable<T>> {
    void sort(T[] array);
}
