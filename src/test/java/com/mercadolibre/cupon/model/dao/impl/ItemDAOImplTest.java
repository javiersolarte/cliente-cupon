package com.mercadolibre.cupon.model.dao.impl;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.cupon.model.vo.ItemPrecio;
import com.mercadolibre.cupon.util.RespuestaExcepcion;

@ExtendWith(MockitoExtension.class)
public class ItemDAOImplTest {

	@InjectMocks
	private ItemDAOImpl itemDAOImpl = new ItemDAOImpl();

	@Mock
	private RestTemplate restTemplate;

	@Test
	public void testPrecioCupon() throws RespuestaExcepcion {
		String item = "MLA811601010";
		ItemPrecio itemPrecio = new ItemPrecio();
		itemPrecio.setId(item);
		itemPrecio.setPrice("5000");
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(itemPrecio);
		} catch (JsonProcessingException e) {

		}
		itemDAOImpl.consultarPrecio(item);
	}
}
