package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Rename Class to a relevant name Add add relevant facade methods
 */

public class PersonFacade {

    private static PersonFacade instance;
    private static CityInfoFacade cityInfoFacade;
    private static AddressFacade addressFacade;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonDTO create(PersonDTO pn) {
        Person person =
                new Person(pn.getEmail(), pn.getFirstName(), pn.getLastName(),
                        new Address( pn.getAddressDTO().getStreet(), pn.getAddressDTO().getAdditionalInfo(),
                                new CityInfo(pn.getAddressDTO().getCityInfoDTO().getZipCode(), pn.getAddressDTO().getCityInfoDTO().getCity())));
        EntityManager em = emf.createEntityManager();





        try {
            em.getTransaction().begin();





            em.persist(person);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }

    public void remove(long id) {

        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);

        if (p != null) {

            try {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            } finally {
                em.close();
            }


        } else {
            throw new WebApplicationException("fejl person not found", 400);

        }


    }

    public PersonDTO getById(long id) {
        EntityManager em = emf.createEntityManager();
        return new PersonDTO(em.find(Person.class, id));
    }

    public List<PersonDTO> getByHobby(String name) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT  p FROM Person p INNER JOIN p.hobbies h WHERE h.name = :name", Person.class);
        query.setParameter("name", name);
        List<Person> rms = query.getResultList();
        return PersonDTO.getDtos(rms);
    }

    public PersonDTO update(PersonDTO pn) {
        Person p = new Person(pn.getId(), pn.getEmail(), pn.getFirstName(), pn.getLastName(),
                new Address(pn.getAddressDTO().getId(), pn.getAddressDTO().getStreet(), pn.getAddressDTO().getAdditionalInfo(),
                        new CityInfo(pn.getAddressDTO().getCityInfoDTO().getZipCode(), pn.getAddressDTO().getCityInfoDTO().getCity())));

        EntityManager em = emf.createEntityManager();

        if (em.find(Person.class, pn.getId()) != null) {

            try {
                em.getTransaction().begin();
                em.merge(p);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
            return new PersonDTO(p);

        } else {
            throw new WebApplicationException("fejl person not found", 400);

        }

    }

    public PersonDTO updateHobbies(long id, List<HobbyDTO> hobbies) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);

        if (p != null) {


            for (int i = 0; i < hobbies.size(); i++) {

                Hobby h = em.find(Hobby.class, hobbies.get(i).getId());

                if (h != null) {

                    p.addHobby(h);
                } else {
                    throw new WebApplicationException("fejl Hobby not found", 400);

                }
            }

            try {
                em.getTransaction().begin();
                p = em.merge(p);
                em.getTransaction().commit();
            } finally {
                em.close();
            }


            return new PersonDTO(p);
        } else {
            throw new WebApplicationException("fejl person not found", 400);

        }

    }


    public long getPersonCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long personCount = (long) em.createQuery("SELECT COUNT(p) FROM Person p").getSingleResult();
            return personCount;
        } finally {
            em.close();
        }
    }

    public List<PersonDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> rms = query.getResultList();
        return PersonDTO.getDtos(rms);
    }

    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade fe = getFacadeExample(emf);
        fe.getAll().forEach(dto -> System.out.println(dto));
    }

}
