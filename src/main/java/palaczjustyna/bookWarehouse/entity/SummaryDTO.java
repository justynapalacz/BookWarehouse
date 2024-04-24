package palaczjustyna.bookWarehouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.List;

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
