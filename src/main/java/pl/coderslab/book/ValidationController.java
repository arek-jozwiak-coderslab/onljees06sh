package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")

    public String validate(Model model) {

        Book book = new Book();
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        List<String> stringList = new ArrayList<>();
        for (ConstraintViolation<Book> bookConstraintViolation : validate) {
            stringList.add(
                    bookConstraintViolation.getPropertyPath() + " : " + bookConstraintViolation.getMessage()
            );
        }
        model.addAttribute("validateErrors", stringList);

        return "/validate/test";
    }
}
