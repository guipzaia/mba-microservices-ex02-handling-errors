package br.com.fiap.orderservice.dto;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private String uuid;
    @NotNull(message = "Campo 'description' obrigatório")
    private String description;
    @Digits(integer=5, fraction=2)
    private BigDecimal price;
}
