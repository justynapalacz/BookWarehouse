package palaczjustyna.bookWarehouse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "book_order")
@NoArgsConstructor
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    private Summary summary;

    @ManyToOne()
    private Book book;

    @Column(name = "quantity")
    private Integer quantity;

    public BookOrder(Integer quantity, Book book, Summary summary) {
        this.quantity = quantity;
        this.book = book;
        this.summary = summary;
    }
}
