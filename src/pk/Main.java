package pk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1-Creates an instance of book
Book book = new Book();
book.setId(5l);
// 2-Obtains an entity manager and a transaction
EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
EntityManager em = emf.createEntityManager();
// 3-Persists the book to the database
EntityTransaction tx = em.getTransaction();
tx.begin();
em.persist(book);
tx.commit();
// 4-Executes the named query
book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
// 5-Closes the entity manager and the factory
em.close();
emf.close();
}
    
}
