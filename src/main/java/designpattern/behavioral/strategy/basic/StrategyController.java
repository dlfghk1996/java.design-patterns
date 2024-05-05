package designpattern.behavioral.strategy.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/strategy")
public class StrategyController {
    private final Context context;

    @GetMapping("")
    public int test(@RequestParam String request) {

        if (request.equals("addition")) {
            context.setStrategy(new ConcreteStrategyAdd());
        }
        if (request.equals("subtraction")) {
            context.setStrategy(new ConcreteStrategySubtract());
        }
        if (request.equals("multiplication")) {
            context.setStrategy(new ConcreteStrategyMultiply());
        }

        return context.executeStrategy(2, 3);
    }
}


