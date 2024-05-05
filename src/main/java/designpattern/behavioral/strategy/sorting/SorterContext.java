package designpattern.behavioral.strategy.sorting;


// 제네릭 타입 T를 받아 해당 데이터에 대한 정렬를 수행한다.
public class SorterContext<T extends Comparable<T>> {
    private SortStrategy<T> sortStrategy;

    // 생성자에서 정렬 타입을 받아 해당 타입의 전략 인스턴스를 생성한다.
    public SorterContext(String type) {
        this.sortStrategy = SortStrategyFactory.getSortStrategy(type);
    }

    // 정렬 수행 위임
    public void sort(T[] array) {
        sortStrategy.sort(array);
    }
}
