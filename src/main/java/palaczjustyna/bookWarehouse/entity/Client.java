package palaczjustyna.bookWarehouse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "client")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nip")
    private  String nip;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "post_code")
    private String post_code;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Client(String name, String nip, String city, String street, String post_code, String phone, String email) {
        this.name = name;
        this.nip = nip;
        this.city = city;
        this.street = street;
        this.post_code = post_code;
        this.phone = phone;
        this.email = email;
    }
}
