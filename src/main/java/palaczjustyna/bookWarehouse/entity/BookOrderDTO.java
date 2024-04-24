package palaczjustyna.bookWarehouse.entity;

public record BookOrderDTO(
        Integer id,
        Integer summaryId,
        Integer bookId,
        Integer quantity

        ) {
}
