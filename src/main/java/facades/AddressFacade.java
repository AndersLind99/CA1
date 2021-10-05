package facades;

import dtos.AddressDTO;
import dtos.CityInfoDTO;
import entities.Address;
import entities.CityInfo;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressFacade {

    private static AddressFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private AddressFacade() {}

    public static AddressFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddressFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

    public AddressDTO getByAddress(long id){
        EntityManager em = emf.createEntityManager();
        return new AddressDTO(em.find(Address.class, id));
    }

    public List<AddressDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Address> query = em.createQuery("SELECT a FROM Address a", Address.class);
        List<Address> rms = query.getResultList();
        return AddressDTO.getDtos(rms);
    }
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        AddressFacade fe = getFacadeExample(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }
}
