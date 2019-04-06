package br.com.fiap.orderservice.dto;

import br.com.fiap.orderservice.enums.Brand;
import br.com.fiap.orderservice.enums.TransactionType;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    @NotNull(message = "Campo 'brand' obrigatório")
    private Brand brand;
    @NotNull(message = "Campo 'transactionType' obrigatório")
    private TransactionType transactionType;
    @NotNull(message = "Campo 'cardNumber' obrigatório")
    private String cardNumber;
    @NotNull(message = "Campo 'expDate' obrigatório")
    private String expDate;
    @NotNull(message = "Campo 'cvv' obrigatório")
    @Size(min=3, max=3)
    private String cvv;
    @Digits(integer=5, fraction=2)
    private BigDecimal price;
    private String uuidAcquirerTransaction;
}
