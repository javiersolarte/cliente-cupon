package com.mercadolibre.cupon.rest;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.cupon.model.vo.ItemsDTO;

@WebMvcTest(BeneficioResourse.class)
class BeneficioResourceTest {
	@MockBean
	  BeneficioResourse beneficioResourse;
	@Autowired
	  MockMvc mockMvc;
	@Autowired
	  ObjectMapper objectMapper;
	

	@Test
	void testCoupon() throws Exception {
		ItemsDTO items = new ItemsDTO();
		items.setAmount("1200000");
		List<String> item= new ArrayList<>();
		item.add("MLA811601010");
		items.setItemsId(item);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<?> responseEntity = new ResponseEntity<>(
		    "some response body",
		    header, 
		    HttpStatus.OK
		);
		when(beneficioResourse.coupon(items)).thenReturn((ResponseEntity<Object>) responseEntity);
		mockMvc.perform(post("/beneficio/coupon/").contentType(MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString(items)))
		        .andExpect(status().isOk())
		        .andDo(print());
	  
	}

}
