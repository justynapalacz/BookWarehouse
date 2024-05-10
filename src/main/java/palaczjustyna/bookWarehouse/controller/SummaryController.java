package palaczjustyna.bookWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import palaczjustyna.bookWarehouse.entity.Summary;
import palaczjustyna.bookWarehouse.entity.SummaryDTO;
import palaczjustyna.bookWarehouse.repository.SummaryDAO;

import java.util.List;

@RestController
public class SummaryController {
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
    public Summary addSummary(@RequestBody SummaryDTO summaryDTO){
        return summaryDAO.addSummary(summaryDTO);
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
