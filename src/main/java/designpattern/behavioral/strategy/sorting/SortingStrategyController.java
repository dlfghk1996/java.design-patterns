package designpattern.behavioral.strategy.sorting;


import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// 각 정렬 알고리즘은 싱글톤 패턴을 적용하여 인스턴스화 된다.
// 팩토리 메서드를 통해 동적으로 선택된다.
// SorterContext는 정렬 타입에 따라 적절한 정렬 전략을 선택한다.
@RequiredArgsConstructor
@RestController
@RequestMapping("/strategy/sorting")
public class SortingStrategyController {
    @GetMapping("")
    public void test(@RequestParam String request) {

        Integer[] numbers = {5, 2, 7, 1, 3};

        // 버블 정렬
        SorterContext<Integer> bubbleSorter = new SorterContext<>("bubble");
        bubbleSorter.sort(numbers);
        System.out.println("Bubble Sorted Array: " + Arrays.toString(numbers));

        // 퀵 정렬
        SorterContext<Integer> quickSorter = new SorterContext<>("quick");
        quickSorter.sort(numbers);
        System.out.println("Quick Sorted Array: " + Arrays.toString(numbers));
    }
}
