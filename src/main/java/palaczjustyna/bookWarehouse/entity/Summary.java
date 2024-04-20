package palaczjustyna.bookWarehouse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@Table (name = "summary")
@NoArgsConstructor
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "status")
    private String status;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne()
//    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @ManyToOne()
//    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    @OneToMany(mappedBy = "summary")
    private List<BookOrder> bookOrderListOrder;

    public Summary(String number, LocalDateTime date, String status, String paymentType, Double amount, Client client, Employee employee) {
        this.number = number;
        this.date = date;
        this.status = status;
        this.paymentType = paymentType;
        this.amount = amount;
        this.client = client;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                ", client=" + client +
                ", employee=" + employee +
                '}';
    }
}
