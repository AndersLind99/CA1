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

    public Person() {

    }

    public Person(long id, String email, String firstName, String lastName) {
    }


    // Person attributes

    private String email;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "persons", cascade = CascadeType.PERSIST)
    List<Hobby> hobbies;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Person(Long id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String email, String firstName, String lastName, Address address) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public Person(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = getAddress();
        this.hobbies = getHobbies();
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

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
