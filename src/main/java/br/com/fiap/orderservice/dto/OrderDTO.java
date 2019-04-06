package br.com.fiap.orderservice.dto;

import br.com.fiap.orderservice.enums.OrderStatus;
import br.com.fiap.orderservice.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String uuid;
    @NotNull(message = "Campo 'email' obrigatório")
    @Email
    private String email;
    @NotNull(message = "Campo 'fullName' obrigatório")
    @Size(min = 3, max = 90)
    private String fullName;
    @NotNull(message = "Campo 'shippingAddress' obrigatório")
    @Size(min = 3, max = 120)
    private String shippingAddress;
    @NotNull(message = "Campo 'quantity' obrigatório")
    private Integer quantity;
    @Digits(integer=5, fraction=2)
    private BigDecimal price;
    @NotNull(message = "Campo 'paymentMethod' obrigatório")
    private PaymentMethod paymentMethod;
    private OrderStatus status;
    @JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
    private Calendar date;
    private PaymentDTO payment = new PaymentDTO();
    private ArrayList<OrderItemDTO> items = new ArrayList<>();
    
	public String getUuid() {
		return this.uuid;
	}
}
