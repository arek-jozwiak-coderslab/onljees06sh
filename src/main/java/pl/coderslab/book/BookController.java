package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    private final PublisherDao publisherDao;
    private final BookDao bookDao;

    public BookController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @RequestMapping("/test-add")
    @ResponseBody
    public String saveBookSample(){
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setPublisher(publisher);
        bookDao.save(book);
        return "added";
    }
}
