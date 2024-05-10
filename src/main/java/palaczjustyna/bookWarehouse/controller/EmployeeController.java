package palaczjustyna.bookWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import palaczjustyna.bookWarehouse.entity.Employee;
import palaczjustyna.bookWarehouse.entity.EmployeeDTO;
import palaczjustyna.bookWarehouse.repository.EmployeeDAO;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(@RequestParam(value = "id") Integer id){
        return employeeDAO.getEmployeeById(id);
    }

    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeDAO.addEmployee(employeeDTO);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeDAO.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee (@RequestParam(value = "id") Integer id){
        return employeeDAO.deleteEmployee(id);
    }


}
