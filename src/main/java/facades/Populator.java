/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.Hobby;
import entities.Person;
import entities.RenameMe;

import javax.persistence.EntityManagerFactory;

import utils.EMF_Creator;

/**
 * @author tha
 */
public class Populator {
    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        HobbyFacade hf = HobbyFacade.getFacadeExample(emf);
        Hobby h1 = new Hobby("Fodbold", "Du sparker en bold");

        hf.create(new HobbyDTO(h1));

        PersonFacade pf = PersonFacade.getFacadeExample(emf);
        Person p1 = new Person("anders@gmail.com", "Simon", "Lukasen");
       // pf.create(new PersonDTO(p1));
        p1.addHobby(h1);
        pf.updateHobbies(p1);

    }

    public static void main(String[] args) {
        populate();
    }
}
