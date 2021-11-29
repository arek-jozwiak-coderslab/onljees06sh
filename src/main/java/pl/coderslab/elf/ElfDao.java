package pl.coderslab.elf;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ElfDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Elf elf){
        entityManager.persist(elf);
    }

}
