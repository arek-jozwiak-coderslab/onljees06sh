package pl.coderslab.form;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }
    

}
