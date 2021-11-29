package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.elf.Elf;
import pl.coderslab.elf.ElfDao;

@Controller
public class HomeController {

    private final ElfDao elfDao;

    public HomeController(ElfDao elfDao) {
        this.elfDao = elfDao;
    }

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Elf elf = new Elf();
        elf.setName("Elmo");

        elfDao.save(elf);

        return "hello world";
    }
}
