package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student("Jan", "Kowalski");
        model.addAttribute("student", student);
        return "student/add";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processForm(Student student) {
        System.out.println(student.getFirstName());
        return "student/add";
    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        System.out.println("run ");
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }
}
