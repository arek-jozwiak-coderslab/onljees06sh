package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        return entityManager.createQuery("select  b from Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("select b from Book b where b.rating=:rat")
                .setParameter("rat", rating).getResultList();
    }

    public Book findOneByRating(int rating) {
        return (Book) entityManager.createQuery("select b from Book b where b.rating=:rat")
                .setParameter("rat", rating).getSingleResult();
    }

}
