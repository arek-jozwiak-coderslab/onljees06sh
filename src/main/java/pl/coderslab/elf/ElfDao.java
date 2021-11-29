package pl.coderslab.elf;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.awt.print.Book;

@Repository
@Transactional
public class ElfDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Elf elf) {
        entityManager.persist(elf);
    }

    public Elf findById(Long id) {
        return entityManager.find(Elf.class, id);
    }

    public void update(Elf elf) {
        entityManager.merge(elf);
    }

    public void delete(Elf elf) {
        entityManager.remove(entityManager.contains(elf) ?
                elf : entityManager.merge(elf));
    }

}
