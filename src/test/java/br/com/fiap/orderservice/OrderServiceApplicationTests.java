package br.com.fiap.orderservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.fiap.orderservice.controllers.OrderController;
import br.com.fiap.orderservice.repository.OrderRepository;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
@ContextConfiguration
public class OrderServiceApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private OrderRepository repository;

	@Test
	public void OrderNotFounded() throws Exception {
		
		when(repository.findById("88ec268b-c178-8fcc-7165-c7ddd0eb25dc")).thenReturn(null);
		
		mvc.perform(get("/orders/88ec268b-c178-8fcc-7165-c7ddd0eb25dc")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void FindAllOrders() throws Exception {
		
		mvc.perform(get("/orders")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void OrderNotDeleted() throws Exception {
		
		when(repository.delete("88ec268b-c178-8fcc-7165-c7ddd0eb25dc")).thenReturn(null);
		
		mvc.perform(delete("/orders/88ec268b-c178-8fcc-7165-c7ddd0eb25dc")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void CreateNewOrderError() throws Exception {
		
		mvc.perform(post("/orders")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void UpdateOrderError() throws Exception {
		
		mvc.perform(put("/orders/88ec268b-c178-8fcc-7165-c7ddd0eb25dc")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}

}
