package palaczjustyna.bookWarehouse.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import palaczjustyna.bookWarehouse.entity.Book;
import palaczjustyna.bookWarehouse.entity.BookOrder;
import palaczjustyna.bookWarehouse.entity.BookOrderDTO;
import palaczjustyna.bookWarehouse.entity.Summary;

import java.util.List;
@Repository
public class BookOrderDAO {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SummaryDAO summaryDAO;
    @Autowired
    private BookDAO bookDAO;

    public List<BookOrder> getBookOrders() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<BookOrder> criteriaQuery = criteriaBuilder.createQuery(BookOrder.class);
        Root<BookOrder> root = criteriaQuery.from(BookOrder.class);
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public List<BookOrder> getBookOrderBySummaryId(Integer summaryId) {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<BookOrder> criteriaQuery = criteriaBuilder.createQuery(BookOrder.class);
            Root<BookOrder> root = criteriaQuery.from(BookOrder.class);
            Predicate idPredicate = criteriaBuilder.equal(root.get("summary").get("id"), summaryId);
            criteriaQuery.where(idPredicate);
            TypedQuery<BookOrder> query = em.createQuery(criteriaQuery);
            return query.getResultList();
    }

    @Transactional
    public void addBookOrder(BookOrderDTO bookOrderDTO) {
        Summary summary = summaryDAO.getSummaryById(bookOrderDTO.summaryId());
        Book book = bookDAO.getBookbyId(bookOrderDTO.bookId());
        BookOrder bookOrder = new BookOrder(bookOrderDTO.quantity(), book, summary);
        em.persist(bookOrder);
    }

}
