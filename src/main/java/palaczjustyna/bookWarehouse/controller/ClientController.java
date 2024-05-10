package palaczjustyna.bookWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import palaczjustyna.bookWarehouse.entity.Client;
import palaczjustyna.bookWarehouse.entity.ClientDTO;
import palaczjustyna.bookWarehouse.repository.ClientDAO;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientDAO clientDAO;

    @GetMapping("/getClients")
    public List<Client> getClients() {
        return clientDAO.getClients();
    }

    @GetMapping("/getClientById")
    public Client getClientById(@RequestParam(value = "id") Integer id){
        return clientDAO.getClientById(id);
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody ClientDTO clientDTO){
        clientDAO.addClient(clientDTO);
    }

    @PutMapping("/updateClient")
    public void updateClient(@RequestBody ClientDTO clientDTO){
        clientDAO.updateClient(clientDTO);
    }

    @DeleteMapping("/deleteClient")
    public String deleteClient (@RequestParam(value = "id") Integer id){
        return clientDAO.deleteClient(id);
    }

}
