package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/book-form")
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "book/list";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "book/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book-form/list";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.getAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String processForm(@Valid Book book, BindingResult result,Model model) {
        if(result.hasErrors()){
            model.addAttribute("publishers", publisherDao.getAll());
            return "book/add";
        }
        bookDao.save(book);
        return "redirect:/book-form/list";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable long id) {
        model.addAttribute("publishers", publisherDao.getAll());
        model.addAttribute("book", bookDao.findById(id));
        return "book/update";
    }

    @PostMapping("/update/{id}")
    public String processUpdate(@Valid Book book, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("publishers", publisherDao.getAll());
            return "book/update";
        }
        bookDao.update(book);
        return "redirect:/book-form/list";
    }
}
