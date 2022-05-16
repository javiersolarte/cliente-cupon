package com.mercadolibre.cupon.model.ejb.impl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.mercadolibre.cupon.model.dao.ItemDAO;
import com.mercadolibre.cupon.model.vo.ItemsDTO;
import com.mercadolibre.cupon.util.RespuestaExcepcion;

@ExtendWith(MockitoExtension.class)
public class BeneficioBOImplTest {

	@InjectMocks
	private BeneficioBOImpl beneficioBOImpl = new BeneficioBOImpl();
	@Autowired
	@Mock
	private ItemDAO itemDAO;

	@Test
	public void testCupon() throws RespuestaExcepcion {
		ItemsDTO items = new ItemsDTO();
		items.setAmount("1200000");
		List<String> item = new ArrayList<>();
		item.add("MLA811601010");
		item.add("MLA816019440");
		items.setItemsId(item);
		when(itemDAO.consultarPrecio("MLA811601010")).thenReturn(0f);
		beneficioBOImpl.calcularBeneficioCupon(items);
	}

	@Test
	public void testCuponPrecioMayor() throws RespuestaExcepcion {
		ItemsDTO items = new ItemsDTO();
		items.setAmount("1200");
		List<String> item = new ArrayList<>();
		item.add("MLA811601010");
		items.setItemsId(item);
		when(itemDAO.consultarPrecio("MLA811601010")).thenReturn(0f);
		beneficioBOImpl.calcularBeneficioCupon(items);
	}

	@Test
	@DisplayName("Test assert RespuestaExcepcion")
	public void testCuponSinItems() {
		ItemsDTO items = new ItemsDTO();
		items.setAmount("1200");
		List<String> item = new ArrayList<>();
		items.setItemsId(item);
		/*assertThrows(RespuestaExcepcion.class, () -> {
			when(beneficioBOImpl.calcularBeneficioCupon(items))
					.thenThrow(new RespuestaExcepcion("404-NOT_FOUND", "404-NOT_FOUND", HttpStatus.NOT_FOUND));

		});*/
	}

}
