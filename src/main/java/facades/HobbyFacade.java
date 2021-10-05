package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import entities.Hobby;
import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class HobbyFacade {

    private static HobbyFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private HobbyFacade() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static HobbyFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public HobbyDTO create(HobbyDTO hb) {
        Hobby hobby = new Hobby(hb.getName(), hb.getDescription());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HobbyDTO(hobby);


    }

    public long getHobbyCount(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            long HobbyCount = (long) em.createQuery("SELECT COUNT(p) FROM Person p INNER JOIN p.hobbies h WHERE h.name = :name").setParameter("name", name).getSingleResult();
            return HobbyCount;



        } finally {
            em.close();
        }
    }

}
