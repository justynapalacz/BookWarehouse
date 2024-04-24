package palaczjustyna.bookWarehouse.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import palaczjustyna.bookWarehouse.entity.Book;

import java.util.List;

@Repository
public class BookDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Book> getBooks() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Book getBookbyId(Integer id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
       criteriaQuery.where(idPredicate);
        TypedQuery<Book> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    public void addBook (String title, String author, String category, Double price, Integer total){
        Book book = new Book(title, author,category,price,total);
        em.persist(book);
    }

    @Transactional
    public Book updateBookTotal(Integer id,Integer total){
        Book book = getBookbyId(id);
        book.setTotal(total);
        em.merge(book);
        return book;
    }

    @Transactional
    public String deleteBook (Integer id){
        Book book = getBookbyId(id);
        em.remove(book);
        return "Book by id " + id + " is deleted";
    }
}
