/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.*;

import javax.persistence.EntityManagerFactory;

import utils.EMF_Creator;

import java.util.List;

/**
 * @author tha
 */
public class Populator {
    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        HobbyFacade hf = HobbyFacade.getFacadeExample(emf);
       Hobby h1 = new Hobby("Fodbold", "Du sparker en bold");

        hf.create(new HobbyDTO(h1));

        CityInfoFacade cf = CityInfoFacade.getFacadeExample(emf);

        CityInfo cityInfo = new CityInfo(cf.getByZipcode(3700).getZipCode(),cf.getByZipcode(3700).getCity());

        Address address = new Address("Smallesund",110,cityInfo);

        PersonFacade pf = PersonFacade.getFacadeExample(emf);
        Person p1 = new Person("anders@gmail.com", "Simon", "Lukasen", address);
        pf.create(new PersonDTO(p1));



//        p1.addHobby(h1);
//
//
//
//       pf.updateHobbies(p1.getId(),);



    }

    public static void main(String[] args) {
        populate();
    }
}
