package palaczjustyna.bookWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/getBookbyId")
    public Book getBookbyId(@RequestParam(value = "id") Integer id){
        return bookDAO.getBookbyId(id);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestParam(value = "title")  String title,@RequestParam(value = "author") String author,
                        @RequestParam (value = "category") String category,@RequestParam (value = "price") Double price,
                        @RequestParam (value = "total")Integer total){
        bookDAO.addBook(title,author,category,price,total);
    }

    @PutMapping("/updateBook")
    public Book updateBookTotal(@RequestParam(value = "id")Integer id,@RequestParam(value = "total")Integer total){
        return bookDAO.updateBookTotal(id,total);
    }

    @DeleteMapping("/deleteBook")
    public String deleteBook (@RequestParam(value = "id") Integer id){
        return bookDAO.deleteBook(id);
    }
}