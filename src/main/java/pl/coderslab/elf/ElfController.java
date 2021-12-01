package pl.coderslab.elf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/elf")
public class ElfController {

    private final ElfRepository elfRepository;
    private final Validator validator;

    public ElfController(ElfRepository elfRepository, Validator validator) {
        this.elfRepository = elfRepository;
        this.validator = validator;
    }


    @RequestMapping("/list")
    @ResponseBody
    public String getAll() {

        List<Elf> all = elfRepository.findAll();

        all.forEach(e -> System.out.println(e.getName()));

        return "";
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
