package com.mercadolibre.cupon.model.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mercadolibre.cupon.model.dao.ItemDAO;
import com.mercadolibre.cupon.model.vo.ItemPrecio;

@Service
public class ItemDAOImpl implements ItemDAO {
	@Value("${cupon.api.url}")
	private String api;

	@Autowired(required = true)
	private RestTemplate restTemplate;

	@Override
	public Float consultarPrecio(String item) {
		try {

			MultiValueMap<String, String> headers = new HttpHeaders();
			ItemPrecio precio = restTemplate.exchange(api.concat("items/{$ITEM_ID1}"), HttpMethod.GET,
					new HttpEntity(headers), new ParameterizedTypeReference<ItemPrecio>() {
					}, item).getBody();
			return Float.valueOf(precio.getPrice());
		} catch (RestClientException e) {
			return null;
		}

	}

}
