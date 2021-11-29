package pl.coderslab.elf;

import javax.persistence.*;
import java.util.List;

@Entity
public class Santa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int bellySize;

    @OneToMany(mappedBy = "santa")
    private List<Elf> elfs;

}
