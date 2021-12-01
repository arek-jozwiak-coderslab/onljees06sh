package pl.coderslab.elf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElfRepository extends JpaRepository<Elf, Long> {

    List<Elf> findByNameAndRatingLessThan(String name, int ttttt);
}
