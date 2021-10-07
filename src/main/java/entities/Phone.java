package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "Phone.deleteAllRows", query = "DELETE from Phone ")
public class Phone implements Serializable {

    private static final long serialVersionUID = 4l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "phoneList")
//    private List<Person> persons;

    public Phone() {
 }

    private long number;
    private String description;

    @OneToOne
    private List<Person> persons;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
