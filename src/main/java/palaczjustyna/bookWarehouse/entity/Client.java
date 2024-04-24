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
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "nip")
    private  String nip;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public Client(String name, String nip, String city, String street, String postCode, String phone, String email) {
        this.name = name;
        this.nip = nip;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
    }
}
