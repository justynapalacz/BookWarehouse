package palaczjustyna.bookWarehouse.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import palaczjustyna.bookWarehouse.entity.Employee;
import palaczjustyna.bookWarehouse.entity.EmployeeDTO;

import java.util.List;

@Repository
public class EmployeeDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Employee> getEmployees() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Employee getEmployeeById(Integer id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(idPredicate);
        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee client = new Employee(employeeDTO.firstName(), employeeDTO.lastName(), employeeDTO.phone(), employeeDTO.email());
        em.persist(client);
    }

    @Transactional
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(employeeDTO.id());
        if (employeeDTO.firstName() != null) {
            employee.setFirstName(employeeDTO.firstName());
        }
        if (employeeDTO.lastName() != null) {
            employee.setLastName(employeeDTO.lastName());
        }
        if (employeeDTO.phone() != null) {
            employee.setPhone(employeeDTO.phone());
        }
        if (employeeDTO.email() != null) {
            employee.setEmail(employeeDTO.email());
        }
        em.merge(employee);
    }

    @Transactional
    public String deleteEmployee(Integer id) {
        Employee employee = getEmployeeById(id);
        em.remove(employee);
        return "Employee by id " + id + " is deleted";
    }
}
