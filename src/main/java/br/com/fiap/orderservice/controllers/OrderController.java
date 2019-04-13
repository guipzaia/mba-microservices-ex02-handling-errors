package br.com.fiap.orderservice.controllers;

import br.com.fiap.orderservice.dto.OrderDTO;
import br.com.fiap.orderservice.exceptions.EntityNotFoundException;
import br.com.fiap.orderservice.exceptions.EntityNotUpdatedException;
import br.com.fiap.orderservice.exceptions.InternalServerErrorException;
import br.com.fiap.orderservice.repository.OrderRepository;
import br.com.fiap.paymentservice.dto.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import java.util.ArrayList;

@RestController
@RequestMapping("orders")
@Api(value = "Order", description = "Order REST API")
public class OrderController {
	
	private OrderRepository repository = new OrderRepository();

    @GetMapping()
    @ApiOperation(httpMethod = "GET", value = "Get all orders")
	@ApiResponses(value = {
		@ApiResponse(
            code = 200,
            message = "Get all orders",
            response = ArrayList.class
        )
    })
    public ResponseEntity<ArrayList<OrderDTO>> all() throws InternalServerErrorException {

        return new ResponseEntity<>(repository.all(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    @ApiOperation(httpMethod = "GET", value = "Get an order by Id")
	@ApiResponses(value = {
			@ApiResponse(
	            code = 200,
	            message = "Get an order by Id",
	            response = OrderDTO.class
	        ),
			@ApiResponse(
		            code = 404,
		            message = "Order not found"
		        )
	    })
    public ResponseEntity<OrderDTO> findById(
    		@PathVariable(value = "uuid", required = true)
    		@ApiParam( value = "Order Id", required = true)
    		String uuid) throws EntityNotFoundException {
    	
    	OrderDTO orderDTO = repository.findById(uuid);
    	
    	if (orderDTO != null) {			
			
    		return new ResponseEntity<>(orderDTO, HttpStatus.OK);
			
			
		} else {
			
			throw new EntityNotFoundException("Pedido não encontrado");
		}
    }

    @PostMapping()
    @ApiOperation(httpMethod = "POST", value = "Save an order")
	@ApiResponses(value = {
			@ApiResponse(
	            code = 200,
	            message = "Save an order",
	            response = OrderDTO.class
	        )
	    })
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO) throws InternalServerErrorException {
    	
		OrderDTO order = repository.save(orderDTO);

		return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    @ApiOperation(httpMethod = "PUT", value = "Update an order by Id")
	@ApiResponses(value = {
			@ApiResponse(
	            code = 200,
	            message = "Update an order by Id",
	            response = OrderDTO.class
	        ),
			@ApiResponse(
		            code = 400,
		            message = "Order not updated"
		        )
	    })
    public ResponseEntity<OrderDTO> update(
    		@ApiParam( value = "Order Id", required = true)
    		@PathVariable("uuid") String uuid, @RequestBody OrderDTO orderDTO) throws EntityNotUpdatedException {
    	
    	OrderDTO order = repository.update(uuid, orderDTO);
    	
    	if (order != null) {			
			
    		return new ResponseEntity<>(order, HttpStatus.OK);
			
		} else {
			
			throw new EntityNotUpdatedException("Pedido não encontrado");
		}
    }

    @DeleteMapping("/{uuid}")
    @ApiOperation(httpMethod = "DELETE", value = "Delete an order by Id")
	@ApiResponses(value = {
			@ApiResponse(
	            code = 200,
	            message = "Delete an order by Id",
	            response = OrderDTO.class
	        ),
			@ApiResponse(
		            code = 404,
		            message = "Order not deleted"
		        )
	    })
    public ResponseEntity<OrderDTO> delete(
    		@ApiParam( value = "Order Id", required = true)
    		@PathVariable("uuid") String uuid) throws EntityNotFoundException {

    	OrderDTO orderDTO = repository.delete(uuid);
    	
    	if (orderDTO != null) {			
			
    		return new ResponseEntity<>(orderDTO, HttpStatus.OK);

		} else {
			
			throw new EntityNotFoundException("Pedido não encontrado");
		}
    }

}
