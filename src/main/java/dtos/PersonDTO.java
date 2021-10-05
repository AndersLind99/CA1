/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;


import entities.Hobby;

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
    private AddressDTO addressDTO;

    private List<HobbyDTO> hobbies;



    public PersonDTO(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDTO(Person pn) {
        if (pn.getId() != null)
            this.id = pn.getId();
        this.email = pn.getEmail();
        this.firstName = pn.getFirstName();
        this.lastName = pn.getLastName();
        this.addressDTO = new AddressDTO(pn.getAddress());

        this.hobbies = getHobbyDtos(pn.getHobbies());




    }

    public static List<PersonDTO> getDtos(List<Person> rms) {
        List<PersonDTO> rmdtos = new ArrayList();
        rms.forEach(pn -> rmdtos.add(new PersonDTO(pn)));
        return rmdtos;
    }

    public static List<HobbyDTO> getHobbyDtos(List<Hobby> hobbyList) {

        List<HobbyDTO> hobbyDTOList = new ArrayList<>();
        if (hobbyList != null)
        hobbyList.forEach(hb -> hobbyDTOList.add(new HobbyDTO(hb)));
        return hobbyDTOList;
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

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
