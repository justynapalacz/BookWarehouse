package palaczjustyna.bookWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import palaczjustyna.bookWarehouse.entity.Employee;
import palaczjustyna.bookWarehouse.entity.EmployeeDTO;
import palaczjustyna.bookWarehouse.entity.Summary;
import palaczjustyna.bookWarehouse.entity.SummaryDTO;
import palaczjustyna.bookWarehouse.repository.EmployeeDAO;
import palaczjustyna.bookWarehouse.repository.SummaryDAO;

import java.util.List;

@RestController
public class SummaryService {
    @Autowired
    private SummaryDAO summaryDAO;

    @GetMapping("/getSummaries")
    public List<Summary> getSummaries() {
        return summaryDAO.getSummary();
    }

    @GetMapping("/getSummaryById")
    public Summary getSummaryById(@RequestParam(value = "id") Integer id){
        return summaryDAO.getSummaryById(id);
    }

    @PostMapping("/addSummary")
    public void addSummary(@RequestBody SummaryDTO summaryDTO){
        summaryDAO.addSummary(summaryDTO);
    }

    @PutMapping("/updateSummary")
    public void updateSummary(@RequestBody SummaryDTO summaryDTO){
        summaryDAO.updateSummary(summaryDTO);
    }

    @DeleteMapping("/deleteSummary")
    public String deleteSummary (@RequestParam(value = "id") Integer id){
        return summaryDAO.deleteSummary(id);
    }


}
