package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publishers", publisherDao.getAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String processForm(Book book) {
        bookDao.save(book);
        return "redirect:/book-form/list";
    }
}
