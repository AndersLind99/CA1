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
    private Long zipCode;


    public CityInfo() {
    }


    private String city;

    @OneToMany(mappedBy = "cityInfo")
    private List<Address> addresses;

    public CityInfo(long zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
        this.addresses = new ArrayList<>();
    }

    public Long getZipCode() {
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


}
