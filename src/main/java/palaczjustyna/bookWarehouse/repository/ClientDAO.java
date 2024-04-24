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
import palaczjustyna.bookWarehouse.entity.Client;
import palaczjustyna.bookWarehouse.entity.ClientDTO;

import java.util.List;

@Repository
public class ClientDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Client> getClients() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Client getClientById(Integer id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(idPredicate);
        TypedQuery<Client> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    public void addClient(ClientDTO clientDTO) {
        Client client = new Client(clientDTO.name(), clientDTO.nip(), clientDTO.city(), clientDTO.street(), clientDTO.postCode(), clientDTO.phone(), clientDTO.email());
        em.persist(client);
    }

    @Transactional
    public void updateClient(ClientDTO clientDTO) {
        Client client = getClientById(clientDTO.id());
        if (clientDTO.name() != null) {
            client.setName(clientDTO.name());
        }
        if (clientDTO.nip() != null) {
            client.setNip(clientDTO.nip());
        }
        if (clientDTO.city() != null) {
            client.setCity(clientDTO.city());
        }
        if (clientDTO.street() != null) {
            client.setStreet(clientDTO.street());
        }
        if (clientDTO.postCode() != null) {
            client.setPostCode(clientDTO.postCode());
        }
        if (clientDTO.phone() != null) {
            client.setPhone(clientDTO.phone());
        }
        if (clientDTO.email() != null) {
            client.setEmail(clientDTO.email());
        }
        em.merge(client);
    }
    @Transactional
    public String deleteClient(Integer id) {
        Client client = getClientById(id);
        em.remove(client);
        return "Client by id " + id + " is deleted";
    }
}
