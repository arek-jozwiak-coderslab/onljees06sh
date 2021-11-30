package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    @ResponseBody
    public String validate() {

        Book book = new Book();


        Set<ConstraintViolation<Book>> validate = validator.validate(book);

        for (ConstraintViolation<Book> bookConstraintViolation : validate) {
            System.out.println(
                    bookConstraintViolation.getPropertyPath() + " : " + bookConstraintViolation.getMessage()
            );
        }


        return "";
    }
}
