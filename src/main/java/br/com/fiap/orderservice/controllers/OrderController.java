package br.com.fiap.orderservice.controllers;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.exceptions.EntityNotFoundException;
import br.com.fiap.orderservice.exceptions.EntityNotUpdatedException;
import br.com.fiap.orderservice.exceptions.InternalServerErrorException;
import br.com.fiap.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("orders")
public class OrderController {
	
	private OrderRepository repository = new OrderRepository();

    @GetMapping()
    public ResponseEntity<ArrayList<OrderDTO>> all() throws InternalServerErrorException {

        return new ResponseEntity<>(repository.all(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<OrderDTO> findById(@PathVariable(value = "uuid", required = true) String uuid) throws EntityNotFoundException {
    	
    	OrderDTO orderDTO = repository.findById(uuid);
    	
    	if (orderDTO != null) {			
			
    		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
			
			
		} else {
			
			throw new EntityNotFoundException("Pedido não encontrado");
		}
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) throws InternalServerErrorException {
    	
		OrderDTO order = repository.save(orderDTO);

		return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<OrderDTO> update(@PathVariable("uuid") String uuid, @RequestBody OrderDTO orderDTO) throws EntityNotUpdatedException {
    	
    	OrderDTO order = repository.update(uuid, orderDTO);
    	
    	if (order != null) {			
			
    		return new ResponseEntity<>(order, HttpStatus.OK);
			
		} else {
			
			throw new EntityNotUpdatedException("Pedido não encontrado");
		}
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<OrderDTO> delete(@PathVariable("uuid") String uuid) throws EntityNotFoundException {

    	OrderDTO orderDTO = repository.delete(uuid);
    	
    	if (orderDTO != null) {			
			
    		return new ResponseEntity<>(orderDTO, HttpStatus.OK);

		} else {
			
			throw new EntityNotFoundException("Pedido não encontrado");
		}
    }

}
