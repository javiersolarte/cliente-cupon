package com.mercadolibre.cupon.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.mercadolibre.cupon.model.vo.RespuestaDTO;

public class RespuestaExcepcion extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String detalle;
	private final HttpStatus httpStatus;
	private final transient RespuestaDTO response;

	public RespuestaExcepcion(final String codigoEstado, final String detalle, final HttpStatus httpStatus) {
		super();
		this.detalle = detalle;
		this.httpStatus = httpStatus;
		this.response = new RespuestaDTO(codigoEstado, detalle, httpStatus);
	}

	public String getDetalle() {
		return detalle;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public RespuestaDTO getResponse() {
		return response;
	}
}
