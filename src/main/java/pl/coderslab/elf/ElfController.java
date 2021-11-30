package pl.coderslab.elf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/elf")
public class ElfController {

    private final Validator validator;

    public ElfController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/check")
    @ResponseBody
    public String checkElf() {

        Elf elf = new Elf();
        elf.setName("Albin");
        elf.setRating(-10);


        Set<ConstraintViolation<Elf>> validate = validator.validate(elf);
        for (ConstraintViolation<Elf> elfConstraintViolation : validate) {
            System.out.println(elfConstraintViolation.getMessage());
            System.out.println(elfConstraintViolation.getPropertyPath());
        }

        return "okok";
    }
}
