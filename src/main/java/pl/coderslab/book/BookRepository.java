package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long categoryId);

    @Query("select b from Book b where b.title=?1")
    List<Book> bestBook(String title);

    @Query("select b from Book b where b.category=?1")
    List<Book> byCategory(Category category);

}
