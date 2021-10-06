package facades;

import dtos.CityInfoDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.CityInfo;
import entities.Person;
import entities.RenameMe;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityInfoFacade {

    private static CityInfoFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CityInfoFacade() {}


    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CityInfoFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CityInfoFacade();
        }
        return instance;
    }

public List<PersonDTO> getPeopleByCity(long id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p INNER JOIN p.address a WHERE a.cityInfo.zipCode = :id",Person.class);
        query.setParameter("id", id);
        List<Person> people = query.getResultList();
        return PersonDTO.getDtos(people);

}

    public CityInfoDTO getByZipcode(long id){
        EntityManager em = emf.createEntityManager();
        return new CityInfoDTO(em.find(CityInfo.class, id));
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<CityInfoDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<CityInfo> query = em.createQuery("SELECT c FROM CityInfo c", CityInfo.class);
        List<CityInfo> rms = query.getResultList();
        return CityInfoDTO.getDtos(rms);
    }

    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        CityInfoFacade fe = getFacadeExample(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }

}