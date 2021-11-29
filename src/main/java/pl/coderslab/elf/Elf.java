package pl.coderslab.elf;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "elf")
public class Elf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Transient
    private String nameCamelCase;

    private LocalDateTime created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCamelCase() {
        return nameCamelCase;
    }

    public void setNameCamelCase(String nameCamelCase) {
        this.nameCamelCase = nameCamelCase;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
