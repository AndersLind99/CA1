package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Person(long id, String email, String firstName, String lastName, String adress, String cityInfo, long phone) {
    }


    // Person attributes

    private String email;
    private String firstName;
    private String lastName;
    private String adress;
    private String cityInfo;
    private long phone;

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.PERSIST)
    List<Hobby> hobbies;



    public Person(Long id, String email, String firstName, String lastName, String adress, long phone) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.cityInfo = cityInfo;
        this.phone = phone;
    }


    public Person(String email, String firstName, String lastName, String adress, String cityInfo, long phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.cityInfo = cityInfo;
        this.phone = phone;
        this.hobbies = new ArrayList<>();
    }


    public void addHobby(Hobby hobby) {

        if (hobby != null) {
            this.hobbies.add(hobby);
            hobby.getPersons().add(this);

        }


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo() {
        this.cityInfo = cityInfo;
    }

    public long getPhone() {
        return getPhone;
    }

    public void setPhone() {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", cityInfo='" + cityInfo + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
