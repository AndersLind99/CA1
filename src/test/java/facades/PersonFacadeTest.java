package facades;

import dtos.PersonDTO;
import entities.Person;
import entities.RenameMe;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = PersonFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(new Person("text", "another text", "another text", "another text", "another text", 88888888));
            em.persist(new Person("text", "another text", "another text", "another text", "another text", 88888888));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }


    @Test
    void create() {
        facade.create(new PersonDTO("email", "ole", "olesen", "jagtvej", "info", 88888888));
        assertEquals(3, facade.getPersonCount());
    }

    @Test
    void getById() {
    }

    @Test
    void getPersonCount() throws Exception {
        assertEquals(2, facade.getPersonCount(), "Expects two rows in the database");
    }

    @Test
    void update() {

        Person person = new Person(0, "email", "lars","yeet", "jagtvej", "info",80808080);
        PersonDTO personDTO = facade.create(new PersonDTO(person));

        Person person1 = new Person(personDTO.getId(),"email", "lars", "yeet", "jagtvej", "info", 88888888);


        assertEquals(person1.getEmail(), facade.update(new PersonDTO(person1)).getEmail());


    }

    @Test
    void getAll() {
    }
}