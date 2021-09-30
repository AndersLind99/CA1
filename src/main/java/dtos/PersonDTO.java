/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import com.mysql.cj.util.DnsSrv;
import entities.Person;
import entities.RenameMe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class PersonDTO {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String adress;
    private String cityInfo;
    private long phone;


    public PersonDTO(String email, String firstName, String lastName, String adress, String cityInfo, long phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.cityInfo = cityInfo;
        this.phone = phone;
    }

    public PersonDTO(Person pn) {
        if(pn.getId() != null)
            this.id = pn.getId();
        this.email = pn.getEmail();
        this.firstName = pn.getFirstName();
        this.lastName = pn.getLastName();
        this.adress = pn.getAdress();
        this.cityInfo = pn.getCityInfo();
        this.phone = pn.getPhone();

    }

    public static List<PersonDTO> getDtos(List<Person> rms){
        List<PersonDTO> rmdtos = new ArrayList();
        rms.forEach(pn->rmdtos.add(new PersonDTO(pn)));
        return rmdtos;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setAdress() {
        this.adress = adress;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo() {
        this.cityInfo = cityInfo;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone() {
        this.phone = phone;
    }
}
