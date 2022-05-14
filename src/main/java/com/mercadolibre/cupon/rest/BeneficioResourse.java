package com.mercadolibre.cupon.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.cupon.model.ejb.BeneficioBO;
import com.mercadolibre.cupon.model.vo.ItemsDTO;
import com.mercadolibre.cupon.util.RespuestaExcepcion;




@RestController
@RequestMapping("/beneficio")
public class BeneficioResourse {
	
	@Autowired
	private BeneficioBO beneficioBO;

	@PostMapping("/coupon/")
	public ResponseEntity<Object> coupon(@RequestBody final ItemsDTO items) {
		try {
			return new ResponseEntity<>(beneficioBO.calcularBeneficioCupon(items),
					HttpStatus.OK);
		} catch (RespuestaExcepcion e) {
			return new ResponseEntity<>(e.getResponse(), e.getHttpStatus());
		}
	}

}
