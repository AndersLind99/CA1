package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@NamedQuery(name = "Hobby.deleteAllRows", query = "DELETE from Hobby")
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Hobby() {
    }


    // Hobby attributes

    private String name;
    private String description;

    public Hobby(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Hobby(String name, String description) {
        this.name = name;
        this.description = description;
    }
}