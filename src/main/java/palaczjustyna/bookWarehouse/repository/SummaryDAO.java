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
import palaczjustyna.bookWarehouse.entity.*;

import java.util.List;

@Repository
public class SummaryDAO {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Summary> getSummary() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Summary> criteriaQuery = criteriaBuilder.createQuery(Summary.class);
        Root<Summary> root = criteriaQuery.from(Summary.class);
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Summary getSummaryById(Integer id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Summary> criteriaQuery = criteriaBuilder.createQuery(Summary.class);
        Root<Summary> root = criteriaQuery.from(Summary.class);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(idPredicate);
        TypedQuery<Summary> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    public Summary addSummary(SummaryDTO summaryDTO) {
        Client client = clientDAO.getClientById(summaryDTO.clientId());
        Employee employee = null;
        if(summaryDTO.employeeId() != null) {
            employee = employeeDAO.getEmployeeById(summaryDTO.employeeId());
        }

        Summary summary = new Summary(summaryDTO.number(), summaryDTO.date(), summaryDTO.status(), summaryDTO.paymentType(), summaryDTO.amount(), client, employee);
        em.persist(summary);
        return summary;
    }

    @Transactional
    public void updateSummary(SummaryDTO summaryDTO) {
        Summary summary = getSummaryById(summaryDTO.id());
        if (summaryDTO.number() != null) {
            summary.setNumber(summaryDTO.number());
        }
        if (summaryDTO.status() != null) {
            summary.setStatus(summaryDTO.status());
        }
        if (summaryDTO.paymentType() != null) {
            summary.setPaymentType(summaryDTO.paymentType());
        }
        em.merge(summary);
    }

    @Transactional
    public String deleteSummary(Integer id) {
        Summary summary = getSummaryById(id);
        em.remove(summary);
        return "Summary by id " + id + " is deleted";
    }
}
