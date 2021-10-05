package entities;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 2l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private long additionalInfo;

    public Address() {
    }

    @OneToMany(mappedBy = "address")
    private List<Person> person;

    @ManyToOne
    private CityInfo cityInfo;


    public Address(String street, long additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityInfo = getCityInfo();
        this.person = new ArrayList<>();

    }

    public Address(String street, long additionalInfo, CityInfo cityInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.cityInfo = cityInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(long additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }
}
