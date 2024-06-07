package designpattern.behavioral.strategy.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/strategy/validator")
public class ValidationStrategyController {
    @GetMapping("")
    public void test(@RequestParam String request) {

        String username = "john_doe";
        String email = "johndoe@example"; // 잘못된 이메일 형식

        ValidationContext<String> validationContext = new ValidationContext<>();
        validationContext.addValidationStrategy(new LengthValidationStrategy(5, 15));
        validationContext.addValidationStrategy(new EmailValidationStrategy());

        try {
            validationContext.validate(username);
            validationContext.validate(email); // 유효성 검사 실패
            System.out.println("All validations passed successfully.");
        } catch (Exception e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
