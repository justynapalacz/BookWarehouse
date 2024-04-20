package palaczjustyna.bookWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import palaczjustyna.bookWarehouse.entity.Book;
import palaczjustyna.bookWarehouse.repository.BookDAO;

import java.util.List;

@RestController
public class BookService {
    @Autowired
    private BookDAO bookDAO;

    @GetMapping("/getBooks")
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }
}