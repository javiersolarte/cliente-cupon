package com.mercadolibre.cupon.model.vo;


import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class RespuestaDTO {

	private String codigoEstado;
	private String codigoCampo;
	private Integer codigoError;
	private String detalle;
	private String mensaje;
	private boolean exito;



	public RespuestaDTO() {
		super();
	}

	public RespuestaDTO(final String codigoEstado, final String detalle, final HttpStatus httpStatus) {
		super();
		this.codigoEstado = codigoEstado;
		this.detalle = detalle;
		this.exito = false;
		this.codigoCampo = null;
		this.codigoError = httpStatus.value();
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public String getCodigoCampo() {
		return codigoCampo;
	}

	public Integer getCodigoError() {
		return codigoError;
	}

	public String getDetalle() {
		return detalle;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(final String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(final boolean exito) {
		this.exito = exito;
	}

}

