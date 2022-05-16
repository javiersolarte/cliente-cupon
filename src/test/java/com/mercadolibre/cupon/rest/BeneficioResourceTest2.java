package com.mercadolibre.cupon.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mercadolibre.cupon.model.ejb.BeneficioBO;
import com.mercadolibre.cupon.model.vo.ItemsDTO;
import com.mercadolibre.cupon.util.RespuestaExcepcion;

@ExtendWith(MockitoExtension.class)
public class BeneficioResourceTest2 {

	@InjectMocks
	private BeneficioResourse beneficioResourse = new BeneficioResourse();

	@Mock
	private BeneficioBO beneficioBO;

	@Test
	public void testCupon() throws RespuestaExcepcion {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		ItemsDTO items = new ItemsDTO();
		items.setAmount("1200000");
		List<String> item = new ArrayList<>();
		item.add("MLA811601010");
		items.setItemsId(item);
		when(beneficioBO.calcularBeneficioCupon(items)).thenReturn(items);
		ResponseEntity<Object> responseEntity = beneficioResourse.coupon(items);
	}
}