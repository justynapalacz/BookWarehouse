package palaczjustyna.bookWarehouse.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column (name = "category")
    private String category;

    @Column (name = "price")
    private Double price;

    @Column (name = "total")
    private Integer total;

    public Book(String title, String author, String category, Double price, Integer total) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.total = total;
    }
}
