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

        public Address(){
        }

        @OneToMany
        private List<Person> person;

        public Address(String street, long additionalInfo) {
            this.street = street;
            this.additionalInfo = additionalInfo;
            this.person = new ArrayList<>();
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

}
