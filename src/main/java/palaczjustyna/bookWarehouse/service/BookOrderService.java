package palaczjustyna.bookWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import palaczjustyna.bookWarehouse.entity.BookOrder;
import palaczjustyna.bookWarehouse.entity.BookOrderDTO;
import palaczjustyna.bookWarehouse.repository.BookOrderDAO;

import java.util.List;
@RestController
public class BookOrderService {

    @Autowired
    private BookOrderDAO bookOrderDAO;

    @GetMapping("/getBookOrders")
    public List<BookOrder> getBookOrders() {
        return bookOrderDAO.getBookOrders();
    }

    @GetMapping("/getBookOrderBySummaryId")
    public List<BookOrder> getBookOrderBySummaryId(@RequestParam(value = "summaryId") Integer summaryId){
        return bookOrderDAO.getBookOrderBySummaryId(summaryId);
    }

    @PostMapping("/addBookOrder")
    public BookOrder addBookOrder(@RequestBody BookOrderDTO bookOrderDTO){
        return bookOrderDAO.addBookOrder(bookOrderDTO);
    }

}
