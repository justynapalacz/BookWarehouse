package palaczjustyna.bookWarehouse.entity;

public record ClientDTO(
        Integer id,
        String name,
        String nip,
        String city,
        String street,
        String postCode,
        String phone,
        String email

        ) {
}
