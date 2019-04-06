package br.com.fiap.orderservice.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.fiap.orderservice.dto.OrderDTO;

@Component
public class OrderRepository {
	
	public ArrayList<OrderDTO> orders = new ArrayList<>();

    public ArrayList<OrderDTO> all() {
    	
        return this.orders;
    }

    public OrderDTO findById(String uuid) {

        for (OrderDTO orderDTO: this.orders) {
        	
        	if (orderDTO.getUuid().equalsIgnoreCase(uuid)) {
            	
            	return orderDTO;
            }
        }

        return null;
    }

    public OrderDTO save(OrderDTO order) {
    	
        this.orders.add(order);
        
        return order;
    }

    public OrderDTO update(String uuid, OrderDTO order) {
    	
    	int i = 0;
    	
    	for (OrderDTO orderDTO: this.orders) {
        	
            if (orderDTO.getUuid().equalsIgnoreCase(uuid)) {
            	
            	this.orders.set(i,order);
            	return order;
            }
            
            i++;
        }
    	
    	return null;
    }

    public OrderDTO delete(String uuid) {
    	
        for (OrderDTO orderDTO: this.orders) {
        	
        	if (orderDTO.getUuid().equalsIgnoreCase(uuid)) {
        		
            	this.orders.remove(orderDTO);
            	return orderDTO;
            }
        }
        
        return null;
    }
}
