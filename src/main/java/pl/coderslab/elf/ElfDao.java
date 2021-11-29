package pl.coderslab.elf;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

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

    public List<Elf> getAll() {
        Query select = entityManager.createQuery("SELECT e from Elf e");
        List<Elf> resultList = select.getResultList();
        return resultList;
    }

    public List<Elf> getAllSimple() {
        return entityManager.createQuery("SELECT e from Elf e")
                .getResultList();

    }
    public List<Elf> getRetiredElfs(){
        Query query = entityManager.createQuery("select  e from Elf e where e.retired=:dddd");
        query.setParameter("dddd", true);
        return query.getResultList();
    }

}
