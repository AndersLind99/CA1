package entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "CityInfo.deleteAllRows", query = "DELETE from CityInfo")
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany
//    @JoinColumn(name = "cityInfo")
//    private List<Person> persons;

    public CityInfo() {
    }

    private long zipCode;
    private String city;

    @OneToMany
    private List<Person> persons;

    public CityInfo(long zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
        this.persons = new ArrayList<>();
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
