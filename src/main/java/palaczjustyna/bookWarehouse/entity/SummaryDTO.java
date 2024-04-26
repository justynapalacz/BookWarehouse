package palaczjustyna.bookWarehouse.entity;

import java.time.LocalDateTime;

public record SummaryDTO(
        Integer id,
        String number,
        LocalDateTime date,
        String status,
        String paymentType,
        Double amount,
        Integer clientId,
        Integer employeeId

        ) {
}
