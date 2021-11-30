package pl.coderslab.form;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/add")
    public String showRegistrationForm() {
        return "person/add";
    }
//#2
//    @PostMapping("/add")
//    public String processForm(Person person, @RequestParam("save1") String pdf) {
//        personDao.save(person);
//        return "person/add";
//    }

//#1
    @PostMapping("/add")
    public String processFormSimple(@RequestParam String login,
                                    @RequestParam String password,
                                    @RequestParam String email) {
        Person person = new Person();
        person.setEmail(email);
        person.setLogin(login);
        person.setPassword(password);
        personDao.save(person);
        return "person/add";
    }

}
